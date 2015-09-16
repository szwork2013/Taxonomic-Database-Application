package com.unep.wcmc.controller;

import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.filter.SpeciesFilter;
import com.unep.wcmc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;

@RestController
@RequestMapping("/species")
public class SpeciesController extends AbstractController<Species, SpeciesService> implements ServletContextAware {

    @Autowired
    ThreatCategoryService threatCategoryService;
    @Autowired
    ThreatsService threatsService;
    @Autowired
    MultimediaService multimediaService;

    ServletContext ctx;

    @Override
    public void setServletContext(ServletContext servletContext) {
        ctx = servletContext;
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @RequestMapping(method = RequestMethod.POST, value = "/search", produces = "application/json")
    public Page<Species> search(@Valid @RequestBody SpeciesFilter filter,
    								  @PageableDefault(page = 0, size = 30) Pageable pageable) {
        return service.findByFilter(filter, pageable);
    }

    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @RequestMapping(method = RequestMethod.POST, value = "/autocomplete", produces = "application/json")
    public Page<Species> autoComplete(@Valid @RequestBody SpeciesFilter filter,
    									 @PageableDefault(page = 0, size = 30) Pageable pageable) {
        return service.findByTerm(filter, pageable);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method= RequestMethod.POST, value = "/addthreat", produces = "application/json")
    public Species addThreat(@RequestBody HashMap<String,String> params){

        ThreatCategory thc = threatCategoryService.get(new Long(params.get("threatId")));
        Species sp = service.get(new Long(params.get("id")));
        sp.addThreat(new Threat(thc));

        return service.save(sp);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method= RequestMethod.DELETE, value = "/removethreat/{id}/{threatId}", produces = "application/json")
    public Species removeThreat(@PathVariable Long id, @PathVariable Long threatId){

        Species sp = service.get(id);

        sp.getThreats().remove(threatsService.get(threatId));
        threatsService.delete(threatId);

        return service.save(sp);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method= RequestMethod.POST, value = "/addcustomthreat", produces = "application/json")
    public Species removeThreat(@RequestBody HashMap<String,String> params){

        ThreatCategory thc = threatCategoryService.get(new Long(params.get("threatId")));
        Species sp = service.get(new Long(params.get("id")));

        Threat th = new Threat(params.get("description"));
               th.setCategory(thc);

        sp.addThreat(th);

        return service.save(sp);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method= RequestMethod.POST, value="uploadfile")
    public Species uploadFile(@RequestParam("id") Long id,
                              @RequestParam("title") String title,
                              @RequestParam("author") String author,
                              @RequestParam("legend") String legend,
                              @RequestParam("description") String description,
                              @RequestParam("cover_photo") Boolean coverPhoto,
                              @RequestParam("file") MultipartFile file) {

        Species sp = service.get(id);

        if (!file.isEmpty()) {

            log.info(ctx.getMimeType(file.getOriginalFilename()));

            String mimeType = ctx.getMimeType(file.getOriginalFilename());

            try {
                    Multimedia media = new Multimedia(file);
                    media.setTitle(title);
                    media.setAuthor(author);
                    media.setLegend(legend);
                    media.setAuthor(author);
                    media.setDescription(description);
                    media.setSpecie(sp);

                    if(coverPhoto && mimeType.startsWith("image/")){
                        //to fix the bug The fix for HHH-6848 causes IllegalStateException
                        // when merging an entity results in merging more than one representation of the same detached entity.
                        //https://hibernate.atlassian.net/browse/HHH-9106
                        Multimedia mediaPhoto = new Multimedia(file);
                        mediaPhoto.setTitle(title);
                        mediaPhoto.setAuthor(author);
                        mediaPhoto.setLegend(legend);
                        mediaPhoto.setAuthor(author);
                        mediaPhoto.setDescription(description);
                        sp.setCoverPhoto(multimediaService.save(mediaPhoto));
                    }

                    multimediaService.save(media);

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return service.save(sp);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletemedia/{id}/{specie_id}", produces = "application/json")
    public Species deleteMedia(@PathVariable("id") Long id, @PathVariable("specie_id") Long specie_id){

        Species sp = service.get(specie_id);
        multimediaService.delete(id);

        return service.save(sp);
    }
}


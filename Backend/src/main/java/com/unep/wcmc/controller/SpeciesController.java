package com.unep.wcmc.controller;

import com.unep.wcmc.domain.SuccessResponse;
import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.filter.SpeciesFilter;
import com.unep.wcmc.service.SpeciesService;
import com.unep.wcmc.service.ThreatCategoryService;
import com.unep.wcmc.service.ThreatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RestController
@RequestMapping("/species")
public class SpeciesController extends AbstractController<Species, SpeciesService> {

    @Autowired
    ThreatCategoryService threatCategoryService;
    @Autowired
    ThreatsService threatsService;

    @RequestMapping(method = RequestMethod.POST, value = "/search", produces = "application/json")
    public Page<Species> search(@Valid @RequestBody SpeciesFilter filter,
    								  @PageableDefault(page = 0, size = 30) Pageable pageable) {
        return service.findByFilter(filter, pageable);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/autocomplete", produces = "application/json")
    public Page<Species> autoComplete(@Valid @RequestBody SpeciesFilter filter,
    									 @PageableDefault(page = 0, size = 30) Pageable pageable) {
        return service.findByTerm(filter, pageable);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/addthreat", produces = "application/json")
    public Species addThreat(@RequestBody HashMap<String,String> params){

        ThreatCategory thc = threatCategoryService.get(new Long(params.get("threatId")));
        Species sp = service.get(new Long(params.get("id")));
        sp.addThreat(new Threat(thc));

        return service.save(sp);
    }

    @RequestMapping(method= RequestMethod.DELETE, value = "/removethreat/{id}/{threatId}", produces = "application/json")
    public Species removeThreat(@PathVariable Long id, @PathVariable Long threatId){

        Species sp = service.get(id);

        sp.getThreats().remove(threatsService.get(threatId));

        return service.save(sp);
    }

    @RequestMapping(method= RequestMethod.POST, value = "/addcustomthreat", produces = "application/json")
    public Species removeThreat(@RequestBody HashMap<String,String> params){

        ThreatCategory thc = threatCategoryService.get(new Long(params.get("threatId")));
        Species sp = service.get(new Long(params.get("id")));

        Threat th = new Threat(params.get("description"));
               th.setCategory(thc);

        sp.addThreat(th);

        return service.save(sp);
    }

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
            try {

                Image img = new Image(file);
                      img.setTitle(title);
                      img.setAuthor(author);
                      img.setLegend(legend);
                      img.setAuthor(author);
                      img.setDescription(description);
                sp.addImage(img);

                if(coverPhoto){
                    sp.setCoverPhoto(img);
                }

                return service.save(sp);

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return sp;
    }
}


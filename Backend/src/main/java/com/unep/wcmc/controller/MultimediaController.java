package com.unep.wcmc.controller;


import com.unep.wcmc.model.Image;
import com.unep.wcmc.service.AttachmentService;
import com.unep.wcmc.service.ImageService;
import com.unep.wcmc.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/media")
public class MultimediaController {

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    ImageService imageService;

    @Autowired
    SpeciesService speciesService;

    @ResponseBody
    @PreAuthorize("isAnonymous() or isAuthenticated()")
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage( @PathVariable Long id ) throws IOException {
        return attachmentService.get(id).getFile();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/images/{id}", produces = "application/json")
    public Page<Image> listImages(@PathVariable Long id,@PageableDefault(page = 0, size = 6) Pageable pageable){
        return imageService.findAllBySpecie(speciesService.get(id), pageable);
    }

}

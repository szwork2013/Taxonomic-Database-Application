package com.unep.wcmc.controller;


import com.unep.wcmc.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/media")
public class MultimediaController {

    @Autowired
    AttachmentService attachmentService;

    @ResponseBody
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage( @PathVariable Long id ) throws IOException {

        return attachmentService.get(id).getFile();
    }
}

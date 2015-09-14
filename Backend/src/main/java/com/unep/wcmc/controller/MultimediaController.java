package com.unep.wcmc.controller;


import com.unep.wcmc.model.Attachment;
import com.unep.wcmc.model.Multimedia;
import com.unep.wcmc.service.AttachmentService;
import com.unep.wcmc.service.MultimediaService;
import com.unep.wcmc.service.SpeciesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media")
public class MultimediaController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    SpeciesService speciesService;

    @Autowired
    MultimediaService multimediaService;

    @ResponseBody
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage( @PathVariable Long id ) {
        return attachmentService.get(id).getFile();
    }

    @RequestMapping(value = "/audio/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpEntity<byte[]> getSound( @PathVariable Long id ) {

        Attachment audio = attachmentService.get(id);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("audio", "audio.mp3"));
        header.setContentLength(audio.getFile().length);

        return new HttpEntity<>(audio.getFile(), header);
    }

    @RequestMapping(value = "/video/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public HttpEntity<byte[]> getVideo( @PathVariable Long id ) {

        Attachment video = attachmentService.get(id);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("video", "video.mpeg"));
        header.setContentLength(video.getFile().length);

        return new HttpEntity<>(video.getFile(), header);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/medias", produces = "application/json")
    public Page<Multimedia> listImages(@RequestParam("id") Long id,  @PageableDefault(page = 0, size = 4) Pageable pageable){
        return multimediaService.findAllBySpecie(speciesService.get(id), pageable);
    }
}

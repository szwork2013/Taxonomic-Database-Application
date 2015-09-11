package com.unep.wcmc.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;

@Entity
public class Image extends Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specie_id")
    private Species specie;

    public Image(){}

    public Image(MultipartFile file){

        try {

            this.setAttachment(new Attachment(file.getBytes()));
            this.setFilename(file.getOriginalFilename());
            this.setMimeType(file.getContentType());
            this.setDate(new Date());
            this.setSize(file.getSize());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Species getSpecie() {
        return specie;
    }

    public void setSpecie(Species specie) {
        this.specie = specie;
    }
}
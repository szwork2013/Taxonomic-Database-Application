package com.unep.wcmc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"specie"})
public class Multimedia implements BaseEntity {

    protected static Logger log = LoggerFactory.getLogger(Multimedia.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "legend")
    private String legend;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private Date date;

    @Column(name = "site_description")
    private String site;

    @Column(name = "filename")
    private String filename;

    @Column(name = "mime_type")
    private String mimeType;

    @Column(name = "size")
    private Long size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private Attachment attachment;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "specie_id")
    private Species specie;

    public Multimedia(){}

    public Multimedia(MultipartFile file){

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

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Species getSpecie() {
        return specie;
    }

    public void setSpecie(Species specie) {
        this.specie = specie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

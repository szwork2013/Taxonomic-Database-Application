package com.unep.wcmc.model;

import javax.persistence.Column;
import java.util.Date;

public class Multimedia {

    @Column
    private String legend;
    @Column
    private String author;
    @Column
    private Date date;
    @Column
    private String site;
    @Column
    private byte[] file;
}

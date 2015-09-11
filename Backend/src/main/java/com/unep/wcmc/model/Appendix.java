package com.unep.wcmc.model;

import javax.persistence.Embeddable;

@Embeddable
public class Appendix {

    private String type;

    private String annotation;

    private String hashAnnotation;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getHashAnnotation() {
        return hashAnnotation;
    }

    public void setHashAnnotation(String hashAnnotation) {
        this.hashAnnotation = hashAnnotation;
    }
}

package com.unep.wcmc.model;

public class ErrorMessage implements BaseEntity {

    private static final long serialVersionUID = -2088995976378504993L;
    private final long id;
    private final String message;
    
    public ErrorMessage(long id, String message) {
        this.id = id;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
    }
}

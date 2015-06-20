package com.unep.wcmc.model;

public final class ErrorMessage implements BaseEntity {

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
    
    /*
     * (non-Javadoc)
     * @see com.unep.wcmc.model.BaseEntity#getId()
     */
    @Override
    public Long getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     * @see com.unep.wcmc.model.BaseEntity#setId(java.lang.Long)
     */
    @Override
    public void setId(Long id) {
    }
}

package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Model that defines an application's permission
 * access
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@Entity
public final class Permission implements BaseEntity {
    
    private static final long serialVersionUID = -3942955339677014610L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    
    public Permission() {
    }
    
    public String getPermission() {
        return name;
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
		this.id = id;
	}
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}

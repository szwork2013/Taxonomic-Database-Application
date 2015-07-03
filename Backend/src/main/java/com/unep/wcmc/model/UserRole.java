package com.unep.wcmc.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model that defines application's roles
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@Entity
@Table(name = "user_role", uniqueConstraints = { @UniqueConstraint(columnNames = { "role" }), @UniqueConstraint(columnNames = { "name" }) })
public final class UserRole implements BaseEntity {
    
    private static final long serialVersionUID = 6489176128185083200L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "userRoleId", fetch = FetchType.EAGER)
    private Set<Authority> authorities;
    
    public UserRole() {
    }

    public String getRole() {
        return role;
    }
    
    public String getName() {
    	return name;
    }
    
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 41 * ((role == null) ? 1 : role.hashCode());
	}
    
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() == getClass()) {
			final UserRole other = (UserRole)obj;
			return role == null ? other.role == null : role.equalsIgnoreCase(other.role);
		}
		return false;
	}
	
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return role;
    }
}

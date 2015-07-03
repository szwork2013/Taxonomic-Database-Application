package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

/**
 * Authority granted to an authentication object
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@Entity
@IdClass(Authority.class)
public final class Authority implements GrantedAuthority {

    private static final long serialVersionUID = -3291119889078747200L;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRole userRoleId;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Permission permissionId;
    
    public Authority() {
    }
    
    public Authority(UserRole userRoleId) {
        this.userRoleId = userRoleId;
    }
    
    public void getPermission(Permission permission) {
        this.permissionId = permission;
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    @Override
    public String getAuthority() {
        return permissionId.getPermission();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = 17;
        result *= 41 * (userRoleId == null ? 1 : userRoleId.hashCode());
        result *= 41 * (permissionId == null ? 1 : permissionId.hashCode());
        return result;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() == getClass()) {
            final Authority auth = (Authority)other;
            return (userRoleId == null ? auth.userRoleId == null : 
                    userRoleId.equals(auth.userRoleId)) &&    
                   (permissionId == null) ? auth.permissionId == null : 
                       permissionId.equals(auth.permissionId);
        }
        return false;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return permissionId == null ? null : permissionId.toString();
    }
}

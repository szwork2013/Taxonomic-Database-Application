package com.unep.wcmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unep.wcmc.exception.UserAlreadyExistException;
import com.unep.wcmc.exception.UserNotFoundException;
import com.unep.wcmc.exception.UserRoleNotFoundException;
import com.unep.wcmc.model.User;
import com.unep.wcmc.model.UserRole;
import com.unep.wcmc.repository.UserRepository;
import com.unep.wcmc.repository.UserRoleRepository;

/**
 * User service api
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@Service
public final class UserService extends AbstractService<User, UserRepository> implements UserDetailsService {

    @Autowired
    private UserRoleRepository userRoleRepo;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    
    public User registerNewUser(User user) {
        validateUser(user, repo.findByEmail(user.getEmail()));
        validateUser(user, repo.findByUsername(user.getUsername()));
        final String role = user.getRole();
        user.setUserRole(getUserRole(role));
        return repo.save(user);
    }
    
    public User updatePersonalInfor(User editedUser, String id) {
        final long userId = Long.valueOf(id);
        final User user = get(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        validateUser(editedUser, repo.findByEmail(editedUser.getEmail()));
        validateUser(editedUser, repo.findByUsername(editedUser.getUsername()));
        editedUser.setPassword(user.getPassword());
        editedUser.setEnabled(user.isEnabled());
        editedUser.setUserRole(user.getUserRole());
        return save(editedUser);
    }
    
    public void setUserEnabled(String id, boolean enabled) {
        final User user = get(Long.valueOf(id));
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        // false xor true = true
        // true xor false = true
        if (user.isEnabled() ^ enabled) {
        	user.setEnabled(enabled);
        	repo.save(user);        	
        }
    }


    
    public void assignUserRoles(String id, String role) {    	
        final User user = get(Long.valueOf(id));
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        detailsChecker.check(user);
        final UserRole userRole = userRoleRepo.findByName(role);
        if (userRole == null) {
        	throw new UserRoleNotFoundException("Role not found: " + role);
        }
        if (!user.getUserRole().equals(userRole)) {
        	user.setUserRole(userRole);
        	save(user);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        detailsChecker.check(user);
        return user;
    }
    
    public User findByEmail(String email) throws UserNotFoundException {
        final User user = repo.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }
        detailsChecker.check(user);
        return user;        
    }
    
    private void validateUser(User user, User other) {
        if ((user == null) || (other == null) || (user.getId() == other.getId())) {
            return;
        }
        if (other.getEmail().equals(user.getEmail()) ||
            other.getUsername().equals(user.getUsername())) {
            throw new UserAlreadyExistException("User already exists");
        }
    }

    public Page<User> findByFilter(String name, Pageable pageable) {
        return repo.findByFirstNameContaining(name, pageable);
    }

    @Override
    public User save(User entity) {
            if (entity != null) {
            UserRole role = entity.getUserRole();
            if (role != null) {
                role = userRoleRepo.findByRole(role.getRole());
                entity.setUserRole(role);
            }
        }
        return super.save(entity);
    }
    
    private UserRole getUserRole(String role) {
    	UserRole userRole;    	
    	final UserRole.RoleType publicUser = UserRole.RoleType.PUBLIC_USER;
    	try {
    		userRole = userRoleRepo.findByRole(role == null ? publicUser.name() : role);
    	} catch (Exception e) {
    		userRole = userRoleRepo.findByRole(publicUser.name());
    	}
    	return userRole;
    }
}

package com.unep.wcmc.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import com.unep.wcmc.exception.*;
import com.unep.wcmc.helper.MailUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.unep.wcmc.model.ForgetPasswordToken;
import com.unep.wcmc.model.User;
import com.unep.wcmc.model.UserRole;
import com.unep.wcmc.repository.ForgetPasswordTokenRepository;
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

    @Autowired
    private UserRepository userRepo;

	@Autowired
	private ForgetPasswordTokenRepository passwordTokenRepository;

	@Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Environment environment;

    @Autowired
    private MailUtils mailUtils;

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    
    public User registerNewUser(User user) {
        validateUser(user, repo.findByEmail(user.getEmail()));
        validateUser(user, repo.findByUsername(user.getUsername()));
        final String role = user.getRole();
        user.setUserRole(getUserRole(role));
        // setting the user enabled temporary to allow new users to log in on the web site
        user.setEnabled(true);
        return save(user);
    }
    
    public User updatePersonalInfor(User editedUser, String id) {
        final long userId = Long.valueOf(id);
        final User user = get(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        validateUser(editedUser, userRepo.findByEmail(editedUser.getEmail()));
        validateUser(editedUser, userRepo.findByUsername(editedUser.getUsername()));
        // setting the fields to update
        editedUser.setUserRole(user.getUserRole());
        editedUser.setEnabled(user.isEnabled());
        // saving the user
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
    
    public void forgetPassword(String email, String urlCallback) {
        final User user = repo.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User email not found");
        }

        Map<String, Object> mailParameters = new HashMap<>();
        mailParameters.put("username", user.getUsername());
        mailParameters.put("url", getUrl(user, urlCallback));
        mailUtils.sendEmail(email, environment.getProperty("support.email"), "Reset Password",
                MailUtils.FORGOT_PASSWORD_TEMPLATE, mailParameters);
    }

    public User changePassword(User user, String password, String oldPassword) {
        if (!user.getPassword().equals(oldPassword)) {
            throw new InvalidPasswordException("Passwords do not match");
        }
        detailsChecker.check(user);
        user.setPassword(password);
        return userRepo.save(user);
    }

    public void forgetPassword(String email) {
        final User user = findByEmail(email);
        if (user == null) {
            throw new EmailNotFoundException("email not found");
        }
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reset Password");
        message.setText("Reset Password");
        message.setFrom(environment.getProperty("support.email"));
        emailSender.send(message);
    }

    public void resetPassword(String token, String password) {
    	final ForgetPasswordToken passwordToken = passwordTokenRepository.findByToken(token);
    	if (passwordToken == null) {
    		throw new IllegalArgumentException("Invalid token");
    	}
    	final Calendar calendar = Calendar.getInstance();
    	final Date expiryDate = passwordToken.getExpiryDate();
    	if (expiryDate.before(calendar.getTime())) {
    		throw new IllegalStateException("Reset Password Link expired");
    	}
    	final User user = passwordToken.getUser();
    	user.setPassword(password);
    	repo.save(user);
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

    private String getUrl(User user, String urlCallback) {
    	final String token = UUID.randomUUID().toString();
        final ForgetPasswordToken passwordToken = new ForgetPasswordToken(token, urlCallback, user);
        passwordTokenRepository.save(passwordToken);
    	return String.format(urlCallback + "?token=%s", token);
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

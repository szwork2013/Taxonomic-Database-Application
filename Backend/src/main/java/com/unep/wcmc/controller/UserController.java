package com.unep.wcmc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unep.wcmc.domain.SuccessResponse;
import com.unep.wcmc.model.User;
import com.unep.wcmc.service.UserService;

/**
 * User controller restful api 
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User, UserService> {
	
    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public User signUp(@Valid @RequestBody User user) {
        return service.registerNewUser(user);
    }
    
    @RequestMapping(value = "/changelanguage", method= RequestMethod.POST)
    @PreAuthorize("hasAuthority('PERM_CHANGE_LANGUAGE')")
    public void changeLanguage() {
    }

   /* @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/isauthenticated", method= RequestMethod.GET)
    public SuccessResponse isAuthenticated() {
        return new SuccessResponse(service.isAuthenticated().toString());
    }*/
    
    @RequestMapping(value = "/changerole/{id}/role/{role}", method= RequestMethod.POST)
    @PreAuthorize("hasAuthority('PERM_CHANGE_USER_ROLE')")
    public SuccessResponse changeUserRoles(@PathVariable String id, @PathVariable String role) {
    	service.assignUserRoles(id, role);
    	return new SuccessResponse("changed user role");
    }

    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/resetpassword", method= RequestMethod.POST)
    public SuccessResponse resetPassword(@RequestParam(value = "token") String token, @RequestParam(value = "password") String password) {
    	service.resetPassword(token, password);
        return new SuccessResponse();
    }        
    
    @RequestMapping(value = "/assignrole/{id}/grant/role/{role}", method= RequestMethod.POST)
    @PreAuthorize("hasAuthority('PERM_ASSIGN_ROLE')")
    public SuccessResponse assignUserRoles(@PathVariable String id, @PathVariable String role) {
    	service.assignUserRoles(id, role);
    	return new SuccessResponse("role granted");
    }
    
    @RequestMapping(method= RequestMethod.PUT, value="/deactiveuser/{id}")
    @PreAuthorize("hasAuthority('PERM_DEACTIVATE_USER')")
    public SuccessResponse deactiveUser(@PathVariable String id) {
    	service.setUserEnabled(id, false);
    	return new SuccessResponse("user deactivated");
    }

    @RequestMapping(method= RequestMethod.PUT, value="/activeuser/{id}")
    @PreAuthorize("hasAuthority('PERM_ACTIVATE_USER')")
    public SuccessResponse activeUser(@PathVariable String id) {
    	service.setUserEnabled(id, true);
    	return new SuccessResponse("user activated");
    }
    
    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    //@PreAuthorize("hasAuthority('PERM_UPDATE_PERSONAL_INFO')")
    public User edit(@Valid @RequestBody User editedUser, @PathVariable String id) {
        return service.updatePersonalInfor(editedUser, id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/search/{filter}", produces = "application/json")
    public Page<User> search(@PathVariable("filter") String filter,
                                            @PageableDefault(page = 0, size = 20) Pageable pageable) {
        return service.findByFilter(filter, pageable);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/search", produces = "application/json")
    public Page<User> search(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return service.findByFilter("", pageable);
    }

    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/forgetpassword", method= RequestMethod.POST)
    public SuccessResponse forgetPassword(@RequestParam(value = "email") String email,
    									  @RequestParam(value = "callback") String urlCallback,
    									  HttpServletRequest request) {
    	service.forgetPassword(email, urlCallback, request);
        return new SuccessResponse();
    }            
}

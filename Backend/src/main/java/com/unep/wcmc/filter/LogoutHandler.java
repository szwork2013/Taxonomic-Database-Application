package com.unep.wcmc.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unep.wcmc.domain.SuccessResponse;
import com.unep.wcmc.service.TokenAuthenticationService;

/**
 * Handle that takes care about of nuts and bolts of 
 * logout operation
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class LogoutHandler extends SimpleUrlLogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutHandler {

    private final TokenAuthenticationService tokenAuthenticationService;
        
    public LogoutHandler(TokenAuthenticationService tokenAuthenticationService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.web.authentication.logout.LogoutHandler#logout(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        try {
            tokenAuthenticationService.removeAuthentication(httpRequest);
            SecurityContextHolder.getContext().setAuthentication(null);
        } catch (IOException e) {
            SecurityContextHolder.clearContext();
        }
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {        
        SuccessResponse successResponse = new SuccessResponse();
        String jsonResponse = new ObjectMapper().writeValueAsString(successResponse);
        response.addHeader("Content-Type", "application/json");
        response.getWriter().print(jsonResponse);    
    }
}
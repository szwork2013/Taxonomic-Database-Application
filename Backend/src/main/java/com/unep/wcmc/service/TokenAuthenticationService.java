package com.unep.wcmc.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unep.wcmc.domain.TokenResponse;
import com.unep.wcmc.exception.InvalidAuthenticationTokenException;
import com.unep.wcmc.model.User;

/**
 * Service responsible for taking care of 
 * all token generation as well as evicting
 * and persistence
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
@Service
public final class TokenAuthenticationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenAuthenticationService.class);
    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private static final int HALF_HOUR = 30 * 60 * 1000;
    @Autowired
    private UserService userService;
    private final String tokenSecret;
    private final Cache authTokenCache = CacheManager.getInstance().getCache("AuthTokenCache");

    @Autowired
    public TokenAuthenticationService(@Value("${token.secret}") String secret) {
        tokenSecret = secret;
    }
    
    @Scheduled(fixedRate = HALF_HOUR)
    public void evictExpiredTokens() {
        LOGGER.info("Evicting expired tokens");
        authTokenCache.evictExpiredElements();
    }

    public void addAuthentication(HttpServletResponse response, Authentication authentication) throws IOException {
        final User user = (User)authentication.getDetails();
        final String token = createTokenForUser(user);
        authTokenCache.put(new Element(token, getAuthentication(user)));
        response.addHeader(AUTH_HEADER_NAME, token);
        TokenResponse tokenResponse = new TokenResponse(token, user);
        String tokenJsonResponse = new ObjectMapper().writeValueAsString(tokenResponse);
        response.addHeader("Content-Type", "application/json");
        response.getWriter().print(tokenJsonResponse);
    }
    
    public void removeAuthentication(HttpServletRequest request) throws IOException {
        final Authentication authentication = getAuthentication(request);
        if (authentication == null) {
            throw new InvalidAuthenticationTokenException("invalid token");
        }
        final String token = request.getHeader(AUTH_HEADER_NAME);
        authTokenCache.remove(token);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (authTokenCache.get(token) != null) {
            try {
                final UserDetails user = parseUserFromToken(token);
                if (user != null) {
                    return getAuthentication(user);
                }
            } catch (MalformedJwtException e) {
                LOGGER.error(e.getMessage());
            }
        } 
        return null;
    }
    
    private Authentication getAuthentication(UserDetails user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        authenticationToken.setDetails(user);
        return authenticationToken;
    }
    
    private UserDetails parseUserFromToken(String token) {
        final String username = Jwts.parser()
                                    .setSigningKey(tokenSecret)
                                    .parseClaimsJws(token)
                                    .getBody()
                                    .getSubject();
        return userService.loadUserByUsername(username);
    }
 
    private String createTokenForUser(User user) {
        return Jwts.builder()
                   .setSubject(user.getUsername())
                   .signWith(SignatureAlgorithm.HS512, tokenSecret)
                   .setExpiration(new Date(System.currentTimeMillis() + HALF_HOUR))
                   .compact();
    }    
}

package com.group4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WebAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private WebAuthenticationManager authenticationManager;

    @Autowired
    public WebAuthenticationFilter(WebAuthenticationManager authenticationManager) {
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getParameter("username"),
                request.getParameter("password")
        );

        return getAuthenticationManager().authenticate(authentication);
    }
}

package com.group4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private WebAuthenticationFilter webAuthenticationFilter;

    @Autowired
    public void setWebAuthenticationFilter(WebAuthenticationFilter webAuthenticationFilter) {
        this.webAuthenticationFilter = webAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin").hasRole("admin")
            .antMatchers("/user").hasRole("user")
            .anyRequest().authenticated();

        http
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll();


   //     http.exceptionHandling()
   //             .authenticationEntryPoint(new SecurityAuthenticationEntryPoint());

        http.addFilterBefore(webAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

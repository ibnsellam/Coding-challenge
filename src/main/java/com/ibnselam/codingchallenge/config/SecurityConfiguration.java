package com.ibnselam.codingchallenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final  String ROOT_URL ="api/v1/products/**";
	private static final  String ADMIN ="ADMIN";
	private static final  String USER ="USER";
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("user").password("{noop}user").roles(USER)
        .and()
        .withUser("admin").password("{noop}admin").roles(USER, ADMIN);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      
         // http basic config
    	 http
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, ROOT_URL).hasRole(USER)
        .antMatchers(HttpMethod.POST, ROOT_URL).hasRole(ADMIN)
        .antMatchers(HttpMethod.PUT, ROOT_URL).hasRole(ADMIN)
        .antMatchers(HttpMethod.DELETE, ROOT_URL).hasRole(ADMIN)
        .and()
        .csrf().disable()
        .formLogin().disable()
        .headers().frameOptions().disable();
    	
    }

    
}

package com.bizarrecode.urlshortener.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bizarrecode.urlshortener.service.AppUserDetailsService;

@Configurable
@EnableWebSecurity
public class WebConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.authorizeRequests()
		.antMatchers("/api/v1/account/**","/api/v1/short/**").permitAll()
		.anyRequest().fullyAuthenticated().and()
		.logout()
        .permitAll()
		.logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/logout", "POST"))
        .and()
		.httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
		.csrf().disable();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	        }
	    };
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	
}

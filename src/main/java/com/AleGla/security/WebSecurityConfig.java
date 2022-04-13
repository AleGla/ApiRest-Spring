package com.AleGla.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import com.AleGla.security.Interceptor.CustomBasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static String REALM = "ApiRest-Spring";
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("AleGla|User=Person").password("{noop}AleGla|Pass=ADMIN.-Thanks for test my application!!=D").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("AleGla|User=Person").password("{noop}AleGla|Pass=ALL.-Thanks for test my application!!=D").roles("USER");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.csrf().disable()
        .authorizeRequests()
                   .antMatchers("/person/all").access("hasRole('ROLE_USER')")
                  .antMatchers("/person/search/{idPerson}").access("hasRole('ROLE_USER')")
                 .antMatchers("/person/new").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/person/modify").access("hasRole('ROLE_ADMIN')")
               .antMatchers("/person/delete/{idPerson}").access("hasRole('ROLE_ADMIN')")
        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

	@Autowired
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
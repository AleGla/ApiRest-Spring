package com.AleGla.security.Interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.AleGla.utils.BadResponse;


public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
    public void commence(final HttpServletRequest request, 
            final HttpServletResponse response, 
            final AuthenticationException authException) throws IOException {
        
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); 
        JSONObject json = new JSONObject();        
        PrintWriter writer = response.getWriter();      
        writer.println(BadResponse.exceptionAuthorization(json, authException, HttpServletResponse.SC_UNAUTHORIZED));
    }
     
    @Override
    public void afterPropertiesSet() {
        setRealmName("ApiRest-Spring");
        super.afterPropertiesSet();
    }
}



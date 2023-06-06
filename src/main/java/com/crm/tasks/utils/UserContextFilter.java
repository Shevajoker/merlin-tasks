package com.crm.tasks.utils;

import java.io.IOException;

import org.springframework.stereotype.Component;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class UserContextFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest =(HttpServletRequest) request;
		
		UserContextHolder.getContext()
		.setCorrelationId(
				httpServletRequest.getHeader(UserContext.CORRELATION_ID));
		
		UserContextHolder.getContext()
		.setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
		
		UserContextHolder.getContext()
		.setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
		
		UserContextHolder.getContext()
		.setOrganizationId(httpServletRequest.getHeader(UserContext.ORGANIZATION_ID));
		
		
		log.info("UserContextFilter Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
		
		chain.doFilter(httpServletRequest, response);
	}
	

}

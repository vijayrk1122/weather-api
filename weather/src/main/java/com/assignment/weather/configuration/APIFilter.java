package com.assignment.weather.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class APIFilter implements Filter {

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		/*
		 * This method is empty as it just initializes the API Filter
		 */
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		/*
		 * This method is empty as it is just overridden
		 */
	}

}

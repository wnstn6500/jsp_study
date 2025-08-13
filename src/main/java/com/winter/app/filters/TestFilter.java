package com.winter.app.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@WebFilter("")
//@Component
//@Order(1)
public class TestFilter implements Filter {
       
    
    public TestFilter() {
        super();
       
    }


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("Test Filter In");
		chain.doFilter(request, response);
		System.out.println("Test Filter out");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

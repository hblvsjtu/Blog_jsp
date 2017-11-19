package com.lvhongbin.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharactorFilter
 */

public class CharactorFilter implements Filter {
	
	String encoding=null;

    /**
     * Default constructor. 
     */
    public CharactorFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("=========== CharactorFilter ===========");
		System.out.println("执行了CharactorFilter中的构造方法方法");
		System.out.println("encoding："+encoding);
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		encoding=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if(encoding!=null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}
		// pass the request along the filter chain
		System.out.println("=========== CharactorFilter ===========");
		System.out.println("执行了CharactorFilter中的doFilter方法");
		System.out.println("encoding："+encoding);
		chain.doFilter(request, response);
		System.out.println("结束了CharactorFilter中的doFilter方法");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=fConfig.getInitParameter("encoding");
		System.out.println("=========== CharactorFilter ===========");
		System.out.println("执行了CharactorFilter中的init方法");
		System.out.println("encoding："+encoding);
	}

}

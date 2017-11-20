package com.lvhongbin.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 统计过滤器
 * @author Li YongQiang
 */

public class CountFilter implements Filter {
	// 来访数量
	private int count;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化参数
		String param = filterConfig.getInitParameter("count");
		// 将字符串转换为int
		count = Integer.valueOf(param);
		System.out.println("=========== CountFilter ===========");
		System.out.println("执行了CountFilter中的init方法");
		System.out.println("count："+count);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 访问数量自增
		count ++;
		// 将ServletRequest转换成HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取ServletContext
		ServletContext context = req.getSession().getServletContext();
		// 将来访数量值放入到ServletContext中
		context.setAttribute("count", count);
		// 向下传递过滤器
		System.out.println("=========== CountFilter ===========");
		System.out.println("执行了CountFilter中的doFilter方法");
		System.out.println("count："+count);
		chain.doFilter(request, response);
		System.out.println("结束了CountFilter中的doFilter方法");
	}

	@Override
	public void destroy() {

	}
}

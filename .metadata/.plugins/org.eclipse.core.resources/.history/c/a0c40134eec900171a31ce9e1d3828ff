package com.lvhongbin.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyTitleServlet
 */
@WebServlet("/MyTitleServlet")
public class MyTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String myTitle="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTitleServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("=========== MyTitleServlet ===========");
		System.out.println("执行了MyTitleServlet中的构造方法");
		System.out.println("myTitle："+myTitle);
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		myTitle = config.getInitParameter("myTitle");
		System.out.println("=========== MyTitleServlet ===========");
		System.out.println("执行了MyTitleServlet中的init方法");
		System.out.println("myTitle："+myTitle);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    Locale locale=request.getLocale();
	    if (locale.equals(Locale.US)){
	        myTitle="Bad Boy's Programmer Road";
	    }else{
	        myTitle="不良工科生的架构之路";
	    }
		// 获取ServletContext
		ServletContext context = request.getSession().getServletContext();
		// 将来访数量值放入到ServletContext中
		context.setAttribute("myTitle", myTitle);
		System.out.println("=========== MyTitleServlet ===========");
		System.out.println("执行了MyTitleServlet中的doGet方法");
		System.out.println("myTitle："+myTitle);
		request.getRequestDispatcher("/jsp/Index.jsp").forward(request,response);
		System.out.println("结束了MyTitleServlet中的doGet方法");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

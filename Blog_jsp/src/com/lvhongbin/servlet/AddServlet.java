package com.lvhongbin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("=========== AddServlet ===========");
		System.out.println("执行了AddServlet中的构造方法");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
		System.out.println("=========== AddServlet ===========");
		System.out.println("执行了AddServlet中的doGet方法");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=========== AddServlet ===========");
		System.out.println("执行了AddServlet中的doPost方法");
		PrintWriter out =response.getWriter();
		String id=request.getParameter("inputBookInforID");
		String name=request.getParameter("inputBookInforName");
		String author=request.getParameter("inputBookInforAuthor");
		String price=request.getParameter("inputBookInforPrice");
		String number=request.getParameter("inputBookInforNumber");
		out.print("<h2>图书信息添加成功</h2><hr>");
		out.print("图书编号："+id+"<br>");
		out.print("图书名称："+name+"<br>");
		out.print("作者："+author+"<br>");
		out.print("价格："+price+"<br>");
		out.print("数量："+number+"<br>");
		System.out.println("=========== AddServlet ===========");
		System.out.println("结束了AddServlet中的doPost方法");
		
	}

}

package com.lvhongbin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvhongbin.bean.User;
import com.lvhongbin.service.ServiceLoginCheck;

/**
 * Servlet implementation class LoginCheckServlet
 * 
 */

public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("======== 调用了LoginCheckServlet的doGet（）方法");
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		User user=new User();
		user.setName(username);
		user.setPassword(password);
		ServiceLoginCheck serviceLoginCheck =new ServiceLoginCheck(user);
		RequestDispatcher rd = null;
		ServletContext context = request.getSession().getServletContext();
		// 将来访数量值放入到ServletContext中
		if(serviceLoginCheck.check()) {
			context.setAttribute("flag", "true");
			rd=request.getRequestDispatcher("/jsp/Index.jsp");
			System.out.println("======== LoginCheckServlet验证成功 ========");
		}else {
			context.setAttribute("flag", "false");
			rd=request.getRequestDispatcher("/html/handsome.html");
			System.out.println("======== LoginCheckServlet验证失败 ========");
		}
		rd.forward(request, response);
		System.out.println("======== LoginCheckServlet请求转发成功 ========");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

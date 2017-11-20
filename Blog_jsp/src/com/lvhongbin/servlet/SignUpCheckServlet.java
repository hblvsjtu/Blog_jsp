package com.lvhongbin.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lvhongbin.util.StandardTime;
import com.lvhongbin.bean.User;
import com.lvhongbin.service.ServiceSignInAndUpCheck;
import com.lvhongbin.service.ServiceSignUpInsert;

/**
 * Servlet implementation class SignUpCheckServlet
 */
@WebServlet("/SignUpCheckServlet")
public class SignUpCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		boolean isExisted=false;
		boolean isSignUpFinish=false;
		boolean signUpFlag=false;
		User user=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		System.out.println("======== SignUpCheckServlet用户姓名："+username+" ========");
		System.out.println("======== SignUpCheckServlet用户密码："+password+" ========");
		System.out.println("======== SignUpCheckServlet用户邮件： "+email+" ========");
		System.out.println("======== SignUpCheckServlet用户性别： "+sex+" ========");
		if((""!=username && ""!=password && ""!=email && ""!=sex) 
			&& (null!=username && null!=password && null!=email && null!=sex)) {
			isSignUpFinish=true;
			user=new User();
			user.setName(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setSex(sex);
			user.setDate(new StandardTime().getTime());
			ServiceSignInAndUpCheck serviceSignInAndUpCheck = new ServiceSignInAndUpCheck(user);
			if(serviceSignInAndUpCheck.checkName()) {
				isExisted=true;
				System.out.println("======== SignUpCheckServlet注册失败，用户已存在! ========");
				user=null;
				session.setAttribute("user", user);
			}else {
				ServiceSignUpInsert ssui=new ServiceSignUpInsert();
				boolean isInsertSuccess =ssui.insert(user);
				if(isInsertSuccess) {
					signUpFlag=true;
					System.out.println("======== SignUpCheckServlet注册成功 ========");
				}else {
					signUpFlag=false;
					System.out.println("======== SignUpCheckServlet注册失败，写入数据库失败! ========");
					user=null;
					session.setAttribute("user", user);
				}
			}
		}else {
			isSignUpFinish=false;
			isExisted=false;
			signUpFlag=false;
			System.out.println("======== SignUpCheckServlet注册失败，用户信息不完整! ========");
			user=null;
			session.setAttribute("user", user);
		}
		session.setAttribute("isSignUpFinish", isSignUpFinish);
		session.setAttribute("isExisted", isExisted);
		session.setAttribute("signUpFlag", signUpFlag);
		session.setAttribute("user", user);
		response.sendRedirect("/Blog_jsp/jsp/signUp.jsp?fromPage=SignUpCheckServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.lvhongbin.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lvhongbin.bean.User;
import com.lvhongbin.service.ServiceSignInAndUpCheck;

/**
 * Servlet implementation class LoginCheckServlet
 * 
 */

public class SignInCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if (null!=request.getParameter("btnQuitSignIn")) {
			response.sendRedirect("index.jsp?isQuitSignIn=true");
		}else {
			System.out.println("======== 调用了SignInCheckServlet的doGet（）方法");
			boolean fromPageSignUp=false;
			boolean isSignInFinish=false;
			boolean signUpFlag=false;
			boolean signInFlag=false;
			boolean hasSignInName=false;
			User user=null;
			
			if(null!=request.getParameter("fromPage")){
	        	fromPageSignUp=(("signUp".equals(request.getParameter("fromPage").toString())))?true:false;
	        }
			if(fromPageSignUp) {
				user=(User)session.getAttribute("user");
				if(null!=session.getAttribute("signUpFlag")) {
					signUpFlag= (Boolean)session.getAttribute("signUpFlag");
					if(signUpFlag) {
						isSignInFinish=true;
						signInFlag=true;
						session.setAttribute("username", user.getName());
						session.setAttribute("signUpTime", user.getDate());
						System.out.println("======== signInCheckServlet验证成功,通过注册的方式，注册成功 ========");
					}else {
						isSignInFinish=false;
						signInFlag=false;
						hasSignInName=false;
						user=null;
						session.setAttribute("user", user);
						System.out.println("======== signInCheckServlet验证成功,通过注册的方式，注册失败 ========");
					}
				}
			}else {
				user=new User();
				String username = request.getParameter("user");
				String password = request.getParameter("pwd");
				if(""!=username && ""!=password) {
					isSignInFinish=true;
					user.setName(username);
					user.setPassword(password);
					ServiceSignInAndUpCheck serviceSignInAndUpCheck =new ServiceSignInAndUpCheck(user);
					if(serviceSignInAndUpCheck.check()) {
						signInFlag=true;
						hasSignInName=true;				
						System.out.println("======== signInCheckServlet验证成功 ========");
						session.setAttribute("username", username);
						session.setAttribute("signUpTime", user.getDate());
					}else if(serviceSignInAndUpCheck.checkName()) {
						signInFlag=false;
						hasSignInName=true;
						System.out.println("======== signInCheckServlet验证失败,用户已存在! ========");
						user=null;
						session.setAttribute("user", user);
					}else {
						signInFlag=false;
						hasSignInName=false;
						System.out.println("======== signInCheckServlet验证失败，用户不存在! ========");
						user=null;
						session.setAttribute("user", user);
					}
				}else {
					isSignInFinish=false;
					signInFlag=false;
					hasSignInName=false;
					System.out.println("======== signInCheckServlet验证失败，登陆信息填写不完整 ========");
					user=null;
					session.setAttribute("user", user);
				}
			}
			if(signInFlag) {
				Cookie cookie =new Cookie("myCookie", URLEncoder.encode(user.getName(),"UTF-8")+"#"+URLEncoder.encode(user.getDate(),"UTF-8"));
		        cookie.setMaxAge(60*60*24*30);
		       	response.addCookie(cookie);
			}
			session.setAttribute("isSignInFinish", isSignInFinish);
			session.setAttribute("hasSignInName", hasSignInName);
			session.setAttribute("signInFlag", signInFlag);
			response.sendRedirect("index.jsp?fromPage=SignInCheckServlet");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

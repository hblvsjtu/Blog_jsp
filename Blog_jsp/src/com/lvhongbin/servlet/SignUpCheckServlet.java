package com.lvhongbin.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(    
			     "yyyy-MM-dd HH:mm:ss");    
			   java.util.Date currentTime = new java.util.Date();    
			   String time = simpleDateFormat.format(currentTime).toString();
		User user=new User();
		//ServletContext context=request.getSession().getServletContext();
		user.setName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setSex(request.getParameter("sex"));
		user.setDate(time);
		System.out.println("========== 注册用户性别："+request.getParameter("sex")+" ==========");
		System.out.println("========== 注册时间："+time+" ==========");
		ServiceSignInAndUpCheck serviceSignInAndUpCheck = new ServiceSignInAndUpCheck(user);
		if(serviceSignInAndUpCheck.checkName()) {
			request.setAttribute("signUpFlag", "existed");
		}else {
			ServiceSignUpInsert ssui=new ServiceSignUpInsert();
			Boolean isInsertSuccess =ssui.insert(user);
			if(isInsertSuccess) {
				request.setAttribute("signUpFlag", "success");
				request.setAttribute("signUpUser", user);
			}else {
				request.setAttribute("signUpFlag", "fail");
			}
		}
		request.getRequestDispatcher("/jsp/signUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

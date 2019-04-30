package com.lvhongbin.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvhongbin.util.ConnectionFactory;

@WebServlet("/TestJDBCServlet")

public class TestJDBCServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public TestJDBCServlet() {
	        super();
	 }

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tbl_user WHERE id=1";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			ConnectionFactory cf=ConnectionFactory.getInstance();
			conn=cf.makeConnection();
			System.out.println("========== JDBC连接状态："+conn.getAutoCommit()+" ==========");
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				PrintWriter out=resp.getWriter();
				out.println("<html>");                                        
		        out.println("<head><title>第一个JDBCServelt</title></head>");
		        out.println("<body bgcolor=#FFCC66>");
		        out.println("<table width=300  height=30  border=1 cellpadding=0 cellspacing=0>");
		        out.println("<tr>\n");
		        out.println("<tr align=center>\n");
		        out.println("<td>通过Servlet输出HTML网页</td>\n");
		        out.println("</tr>\n");
		        out.println("<tr align=center>\n");
		        out.println("<td>id= "+rs.getInt("id")+"</td>\n");
		        out.println("</tr>\n");
		        out.println("<tr align=center>\n");
		        out.println("<td>name= "+rs.getString("name")+"</td>\n");
		        out.println("</tr>\n");
		        out.println("<tr align=center>\n");
		        out.println("<td>password= "+rs.getString("password")+"</td>\n");
		        out.println("</tr>\n");
		        out.println("<tr align=center>\n");
		        out.println("<td>email= "+rs.getString("email")+"</td>\n");
		        out.println("</tr>\n");
		        out.println("</table>");
		        out.println("</body>");
		        out.println("</html>");
		        out.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				st.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e4) {
				e4.printStackTrace();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}



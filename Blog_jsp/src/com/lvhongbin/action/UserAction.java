/**
 * 
 */
package com.lvhongbin.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Parameter;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.lvhongbin.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author hblvs
 *
 */
public class UserAction extends ActionSupport implements ServletRequestAware,SessionAware,ServletContextAware,ModelDriven<User>{

	/**
	 * @author hblvs
	 */
	
	private static final long serialVersionUID = 1L;
	private Map<String, Parameter> mapParameter=new HashMap<String, Parameter>();
	private String info;
	private HttpServletRequest requestImplements;
	private Map<String, Object> sessionImplements;
	private ServletContext contextImplements;
	private String name1;
	private String password1;
	private String sex1;
	private User user1=new User();
	private User user3;
	private List<User> list;
	private Map<String,User> Map=new HashMap<String, User>();
	private List<User> listOgnl=new ArrayList<>();
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.requestImplements=arg0;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionImplements=arg0;
		
	}
	@Override
	public void setServletContext(ServletContext arg0) {
		this.contextImplements=arg0;
	}

	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * @param password1 the password1 to set
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	/**
	 * @param sex1 the sex1 to set
	 */
	public void setSex1(String sex1) {
		this.sex1 = sex1;
	}
	
	/**
	 * @return the user3
	 */
	public User getUser3() {
		return user3;
	}

	/**
	 * @param user3 the user3 to set
	 */
	public void setUser3(User user3) {
		this.user3 = user3;
	}

	
	/**
	 * @return the list
	 */
	public List<User> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<User> list) {
		this.list = list;
	}

	public Map<String,User> getMap() {
		return Map;
	}

	public void setMap(Map<String,User> map) {
		Map = map;
	}

	/**
	 * @return the listOgnl
	 */
	public List<User> getListOgnl() {
		return listOgnl;
	}

	public String signIn() throws Exception{
		info="用户登录";
		return "signIn";
	}
	public String signUp() throws Exception{
		info="用户注册";
		return "signUp";
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String action1() throws Exception{
		ActionContext context=ActionContext.getContext();
		mapParameter=(Map<String, Parameter>) context.getParameters();
		ValueStack stack=context.getValueStack();
		if(null!=mapParameter.get("name") && null!=mapParameter.get("password") && null!=mapParameter.get("sex")) {
		System.out.println(mapParameter.get("name").toString());
		System.out.println(mapParameter.get("password").toString());
		System.out.println(mapParameter.get("sex").toString());
		stack.set("nameOgnl", mapParameter.get("name").toString()+"_nameOgnl");
		}else {
			System.out.println("为空指针");
		}
		return SUCCESS;
	}
	
	public String action2() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		System.out.println(request.getParameter("name").toString());
		System.out.println(request.getParameter("password").toString());
		System.out.println(request.getParameter("sex").toString());
		request.setAttribute("name7", request.getParameter("name").toString()+"_success");
		session.setAttribute("password7", request.getParameter("password").toString()+"_success");
		context.setAttribute("sex7", request.getParameter("sex").toString()+"_success");
		return SUCCESS;
	}
	
	public String action3() throws Exception{
		System.out.println(requestImplements.getParameter("name").toString());
		System.out.println(requestImplements.getParameter("password").toString());
		System.out.println(requestImplements.getParameter("sex").toString());
		requestImplements.setAttribute("name8", requestImplements.getParameter("name").toString()+"_success");
		sessionImplements.put("password8", requestImplements.getParameter("password").toString()+"_success");
		contextImplements.setAttribute("sex8", requestImplements.getParameter("sex").toString()+"_success");
		return SUCCESS;
	}

	public String action4() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		User user=new User();
		user.setName(request.getParameter("name").toString());
		user.setPassword(request.getParameter("password").toString());
		user.setSex(request.getParameter("sex").toString());
		System.out.println(user.toString());
		request.setAttribute("name9", request.getParameter("name").toString()+"_success");
		session.setAttribute("password9", request.getParameter("password").toString()+"_success");
		context.setAttribute("sex9", request.getParameter("sex").toString()+"_success");
		return SUCCESS;
	}
	
	public String action5() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		User user=new User();
		user.setName(this.name1);
		user.setPassword(this.password1);
		user.setSex(this.sex1);
		System.out.println(user.toString());
		request.setAttribute("name1", this.name1+"_success");
		session.setAttribute("password1", this.password1+"_success");
		context.setAttribute("sex1", this.sex1+"_success");
		return SUCCESS;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user1;
	}

	public String action6() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		System.out.println(this.user1.toString());
		request.setAttribute("name2", this.user1.getName()+"_success");
		session.setAttribute("password2", this.user1.getPassword()+"_success");
		context.setAttribute("sex2", this.user1.getSex()+"_success");
		return SUCCESS;
	}
	
	public String action7() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		System.out.println(this.user3.toString());
		request.setAttribute("name3", this.user3.getName()+"_success");
		session.setAttribute("password3", this.user3.getPassword()+"_success");
		context.setAttribute("sex3", this.user3.getSex()+"_success");
	    this.user3.setName(this.user3.getName()+"_OGNL");
	    this.user3.setPassword(this.user3.getPassword()+"_OGNL");
	    this.user3.setSex(this.user3.getSex()+"_OGNL");
		return SUCCESS;
	}
	
	public String action8() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		System.out.println(this.list.toString());
		request.setAttribute("name4", this.list.get(0).getName()+this.list.get(1).getName()+"_success");
		session.setAttribute("password4", this.list.get(0).getPassword()+this.list.get(1).getPassword()+"_success");
		context.setAttribute("sex4", this.list.get(0).getSex()+this.list.get(1).getSex()+"_success");
		User user1= new User();
		user1.setName(this.list.get(0).getName());
		user1.setPassword(this.list.get(0).getPassword());
		user1.setSex(this.list.get(0).getSex());
		User user2= new User();
		user2.setName(this.list.get(1).getName());
		user2.setPassword(this.list.get(1).getPassword());
		user2.setSex(this.list.get(1).getSex());
		listOgnl.add(user1);
		listOgnl.add(user2);
		return SUCCESS;
	}
	
	public String action9() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		HttpSession session =request.getSession();
		ServletContext context=ServletActionContext.getServletContext();
		System.out.println(this.Map);
		request.setAttribute("name5", this.Map.get("two").getName()+this.Map.get("one").getName()+"_success");
		session.setAttribute("password5", this.Map.get("two").getPassword()+this.Map.get("one").getPassword()+"_success");
		context.setAttribute("sex5", this.Map.get("two").getSex()+this.Map.get("one").getSex()+"_success");
		return SUCCESS;
	}

}

package com.lvhongbin.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lvhongbin.bean.Book;
import com.lvhongbin.bean.Book2;
import com.lvhongbin.factory.ApplicationContextFactory;
import com.lvhongbin.factory.DriverManagerDataSourceFactory;
import com.lvhongbin.service.SpringUserService;
import com.opensymphony.xwork2.ActionSupport;



/**
 * @author hblvs
 *
 */


public class TestSpring extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name1="";
	private String name2="";
	private String name3="";
	private String name4="";
	private String name5="";
	private String name6="";
	private String name9="";
	private String name10="";
	private String name11="";
	private String name12="";
	private double price=0;
	private String author="";
	private String pbookCount="";
	private String[] arr;
	private List<Object> list;
	private Map<String, Object> map;
	private Properties property;
	private Book2 book2;
	private Book book;
	private String feedbackMessage="";
	
	public String testIoC1() {
		//跟据spring配置文件，创建对象，用于加载xml配置文件	
//		Resource resource  =new ClassPathResource("applicationContext.xml");
//		BeanFactory factory=new XmlBeanFactory(resource);
//		//得到配置文件中的对象
//		Book book=(Book)factory.getBean("book");
		ApplicationContext context =ApplicationContextFactory.getInstance();
		Book book=(Book)context.getBean("book");
		book.testSpring1();
		this.name1=this.name1+"    set方法注入对象类型:"+ book.getUser().getName()+"    使用无参构造方法";
		this.price= book.getPrice();
		this.author=book.getAuthor();
		this.setPbookCount(book.getPbookCount());
		this.arr=book.getArr();
		this.list=book.getList();
		this.map=book.getMap();
		//this.property=book.getProperty();
		return SUCCESS;
	}
	public String testIoC2() {
		ApplicationContext context = ApplicationContextFactory.getInstance();
		book=(Book)context.getBean("testSpringBookFactory");
		book.testSpring2();
		this.name2=this.name2+" 使用静态工厂方法";
		return SUCCESS;
	}
	public String testIoC3() {
		ApplicationContext context =ApplicationContextFactory.getInstance();
		Book book=(Book)context.getBean("testSpringBookFactory3");
		book.testSpring3();
		this.name3=this.name3+" 使用实例工厂方法";
		return SUCCESS;
	}
	
	public String testIoC4() {
		book2 =(Book2)ApplicationContextFactory.getInstance().getBean("book2");
		book2.testSpring4();
		book2.setStr1(this.name4+" "+book2.getStr1());
		return SUCCESS;
	}
	public String testIoC5() {
		book2 =(Book2)ApplicationContextFactory.getInstance().getBean("book2");
		book2.testSpring5();
		book2.setStr2(this.name5+" "+book2.getStr2());
		return SUCCESS;
	}
	public String testIoC6() {
		book2 =(Book2)ApplicationContextFactory.getInstance().getBean("book2");
		book2.testSpring6();
		book2.setStr3(this.name6+" "+book2.getStr3());
		return SUCCESS;
	}
	public String testAop1() {
		try {
			Book book3 =(Book)ApplicationContextFactory.getInstance().getBean("book3");
			book3.testSpring5();
			this.feedbackMessage="";
			this.feedbackMessage="利用配置文件切面成功 ";
		} catch (Exception e) {
			e.printStackTrace();
			this.feedbackMessage="";
			this.feedbackMessage="利用配置文件切面失败 ";
		}finally {
			
		}
		return SUCCESS;
	}
	public String testAop2() {
		try {
			Book book5 =(Book)ApplicationContextFactory.getInstance().getBean("book3");
			book5.testSpring6();
			this.feedbackMessage="";
			this.feedbackMessage="利用注解切面成功 ";
		} catch (Exception e) {
			e.printStackTrace();
			this.feedbackMessage="";
			this.feedbackMessage="利用注解切面失败 ";
		}finally {
			
		}
		return SUCCESS;
	}
	public String testJDBCTemperate1() {
		try {
			//设置数据库信息
			//创建jdbcTemplate对象，设置数据源
			JdbcTemplate jdbcTemplate =new JdbcTemplate(DriverManagerDataSourceFactory.getInstance());
			//添加sql语句，调用jdbcTemplate里面的方法
			String sql="insert tbl_book(bookname,author,price,publicyear) values (?,?,?,?);";
			int i=jdbcTemplate.update(sql, this.name9,this.name10,this.name11,this.name12);
			System.out.println("添加成功 "+i);
			this.feedbackMessage="";
			this.feedbackMessage="添加成功 ";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败 ");
			this.feedbackMessage="";
			this.feedbackMessage="添加失败 ";
		}finally {
			
		}
		return SUCCESS;
	}
	
	public String testJDBCTemperate2() {
		try {
			JdbcTemplate jdbcTemplate =new JdbcTemplate(DriverManagerDataSourceFactory.getInstance());
			String sql="update tbl_book set price=? where bookname=?";
			int i=jdbcTemplate.update(sql, this.name11,this.name9);
			System.out.println("修改成功 "+i);
			this.feedbackMessage="";
			this.feedbackMessage="修改成功 ";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改失败 ");
			this.feedbackMessage="";
			this.feedbackMessage="修改失败 ";
		}finally {
			
		}
		return SUCCESS;
	}
	
	public String testJDBCTemperate3() {
		try {
			JdbcTemplate jdbcTemplate =new JdbcTemplate(DriverManagerDataSourceFactory.getInstance());
			String sql="delete from  tbl_book where bookname=?;";
			int i=jdbcTemplate.update(sql, this.name9);
			System.out.println(this.name9+"删除成功 "+i);
			this.feedbackMessage="";
			this.feedbackMessage=this.name9+"删除成功 ";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(this.name9+"删除失败 ");
			this.feedbackMessage="";
			this.feedbackMessage=this.name9+"删除失败 ";
		}finally {
			
		}
		return SUCCESS;
	}
	
	public String testJDBCTemperate4() {
		try {
			JdbcTemplate jdbcTemplate =new JdbcTemplate(DriverManagerDataSourceFactory.getInstance());
			String sql="SELECT price FROM tbl_book WHERE bookname = ?;";
			//this.name11=jdbcTemplate.queryForObject(sql, String.class,this.name9);
			sql="SELECT * FROM tbl_book WHERE bookname = ?;";
//			Book book=jdbcTemplate.queryForObject(sql, new RowMapper<Book>() {
//				@Override
//				public Book mapRow(ResultSet arg0, int arg1) throws SQLException {
//					Book book=new Book();
//					String bookname=arg0.getString("bookname");
//					String price=arg0.getString("price");
//					String author=arg0.getString("author");
//					String publicyear=arg0.getNString("publicyear");
//					book.setBookname(bookname);
//					book.setPrice(Double.parseDouble(price));
//					book.setAuthor(author);
//					book.setPublicyear(publicyear);
//					return book;
//				}
//		},this.name9);
			List<Book> list=jdbcTemplate.query(sql, new RowMapper<Book>() {
				@Override
				public Book mapRow(ResultSet arg0, int arg1) throws SQLException {
					Book book=new Book();
					String bookname=arg0.getString("bookname");
					String price=arg0.getString("price");
					String author=arg0.getString("author");
					String publicyear=arg0.getNString("publicyear");
					book.setBookname(bookname);
					book.setPrice(Double.parseDouble(price));
					book.setAuthor(author);
					book.setPublicyear(publicyear);
					return book;
				}
			},this.name9);
			System.out.println("查询成功 "+this.name11);
			this.feedbackMessage="";
			this.feedbackMessage=this.name9+"查询成功，结果一共有"+list.size()+"个\n";
			for(Book book1:list) {
				this.feedbackMessage=this.feedbackMessage+"价钱为 "+ book1.getPrice()+"，出版年份为"+book1.getPublicyear()+"\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(this.name9+"查询失败 ");
			this.feedbackMessage="";
			this.feedbackMessage=this.name9+"查询失败 ";
		}finally {
			
		}
		return SUCCESS;
	}
	
	public String comboPool() {
		SpringUserService springUserService=(SpringUserService)ApplicationContextFactory.getInstance().getBean("springUserService");
		Book book5=new Book();
		book5.setBookname(this.name9);
		book5.setAuthor(this.name10);
		book5.setPrice(Double.parseDouble(this.name11));
		book5.setPublicyear(this.name12);
		this.feedbackMessage="";
		this.feedbackMessage=this.name9+" "+springUserService.add(book5);
		return SUCCESS;
	}

	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}
	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}
	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}
	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}
	/**
	 * @return the name3
	 */
	public String getName3() {
		return name3;
	}
	/**
	 * @param name3 the name3 to set
	 */
	public void setName3(String name3) {
		this.name3 = name3;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @return the arr
	 */
	public String[] getArr() {
		return arr;
	}
	
	/**
	 * @return the list
	 */
	public List<Object> getList() {
		return list;
	}
	
	/**
	 * @return the property
	 */
	public Properties getProperty() {
		return property;
	}
	
	/**
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}
	/**
	 * @return the pbookCount
	 */
	public String getPbookCount() {
		return pbookCount;
	}
	/**
	 * @param pbookCount the pbookCount to set
	 */
	public void setPbookCount(String pbookCount) {
		this.pbookCount = pbookCount;
	}
	/**
	 * @return the book2
	 */
	public Book2 getBook2() {
		return book2;
	}
	/**
	 * @param book2 the book2 to set
	 */
	public void setBook2(Book2 book2) {
		this.book2 = book2;
	}

	/**
	 * @param name4 the name4 to set
	 */
	public void setName4(String name4) {
		this.name4 = name4;
	}
	/**
	 * @param name5 the name5 to set
	 */
	public void setName5(String name5) {
		this.name5 = name5;
	}
	/**
	 * @param name6 the name6 to set
	 */
	public void setName6(String name6) {
		this.name6 = name6;
	}
	/**
	 * @param name9 the name9 to set
	 */
	public void setName9(String name9) {
		this.name9 = name9;
	}
	/**
	 * @param name10 the name10 to set
	 */
	public void setName10(String name10) {
		this.name10 = name10;
	}
	/**
	 * @param name11 the name11 to set
	 */
	public void setName11(String name11) {
		this.name11 = name11;
	}
	/**
	 * @param name12 the name12 to set
	 */
	public void setName12(String name12) {
		this.name12 = name12;
	}
	/**
	 * @return the name9
	 */
	public String getName9() {
		return name9;
	}
	/**
	 * @return the name10
	 */
	public String getName10() {
		return name10;
	}
	/**
	 * @return the name11
	 */
	public String getName11() {
		return name11;
	}
	/**
	 * @return the name12
	 */
	public String getName12() {
		return name12;
	}
	/**
	 * @return the feedbackMessage
	 */
	public String getFeedbackMessage() {
		return feedbackMessage;
	}
}

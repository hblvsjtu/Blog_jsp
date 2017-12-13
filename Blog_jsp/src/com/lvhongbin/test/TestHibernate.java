/**
 * 
 */
package com.lvhongbin.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import com.lvhongbin.bean.Customer;
import com.lvhongbin.bean.LinkMan;
import com.lvhongbin.bean.Role;
import com.lvhongbin.bean.User;
import com.lvhongbin.util.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;


/**
 * @author hblvs
 *
 */
@SuppressWarnings("deprecation")
public class TestHibernate extends ActionSupport {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<User> list1=null;
	private List<User> list3=null;
	private List<Object[]>  list5=null;
	private List<User> list6=null;
	private List<Customer> listCondition=null;
	private List<Customer> listConditionFuzzy=null;
	private List<Customer> listOrder=null;
	private List<Customer> listPagination=null;
	private List<Object> listProjection=null;
	private List<Object[]> listInnerJoin=null;
	private List<Customer> listCriteriaCondition=null;
	private List<Customer> listCriteriaConditionFuzzy=null;
	private List<Customer> listCriteriaOrderAndPagination=null;
	private Object listAggregate=null;
	private Object listCriteriaStatistical=null;
	private User user =null;
	private User user1=null;
	private User user2=null;
	private User user3=null;
	private Role role1=null;
	private Role role2=null;
	private Customer customer1=null;
	private Customer customer2=null;
	private LinkMan linkMan1 = null;
	private LinkMan linkMan2 = null;
	private Customer customer4=null;
	private LinkMan linkMan4 = null;
	
	

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @return the list1
	 */
	public List<User> getList1() {
		return list1;
	}


	/**
	 * @return the list3
	 */
	public List<User> getList3() {
		return list3;
	}


	/**
	 * @return the list5
	 */
	public List<Object[]> getList5() {
		return list5;
	}


	/**
	 * @return the list6
	 */
	public List<User> getList6() {
		return list6;
	}

	/**
	 * @return the user1
	 */
	public User getUser1() {
		return user1;
	}


	/**
	 * @return the user2
	 */
	public User getUser2() {
		return user2;
	}


	/**
	 * @return the user3
	 */
	public User getUser3() {
		return user3;
	}


	/**
	 * @return the role1
	 */
	public Role getRole1() {
		return role1;
	}


	/**
	 * @return the role2
	 */
	public Role getRole2() {
		return role2;
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer1() {
		return customer1;
	}


	/**
	 * @return the customer2
	 */
	public Customer getCustomer2() {
		return customer2;
	}


	/**
	 * @return the linkMan1
	 */
	public LinkMan getLinkMan1() {
		return linkMan1;
	}


	/**
	 * @return the linkMan2
	 */
	public LinkMan getLinkMan2() {
		return linkMan2;
	}


	/**
	 * @return the customer4
	 */
	public Customer getCustomer4() {
		return customer4;
	}


	/**
	 * @return the linkMan4
	 */
	public LinkMan getLinkMan4() {
		return linkMan4;
	}


	/**
	 * @return the listCondition
	 */
	public List<Customer> getListCondition() {
		return listCondition;
	}



	/**
	 * @return the listConditionFuzzy
	 */
	public List<Customer> getListConditionFuzzy() {
		return listConditionFuzzy;
	}



	/**
	 * @return the listOrder
	 */
	public List<Customer> getListOrder() {
		return listOrder;
	}



	/**
	 * @return the listPagination
	 */
	public List<Customer> getListPagination() {
		return listPagination;
	}


	/**
	 * @return the listProjection
	 */
	public List<Object> getListProjection() {
		return listProjection;
	}



	/**
	 * @return the listAggregate
	 */
	public Object getListAggregate() {
		return listAggregate;
	}



	/**
	 * @return the listInnerJoin
	 */
	public List<Object[]> getListInnerJoin() {
		return listInnerJoin;
	}



	/**
	 * @return the listCriteriaCondition
	 */
	public List<Customer> getListCriteriaCondition() {
		return listCriteriaCondition;
	}




	/**
	 * @return the listCriteriaConditionFuzzy
	 */
	public List<Customer> getListCriteriaConditionFuzzy() {
		return listCriteriaConditionFuzzy;
	}


	/**
	 * @return the listCriteriaOrderAndPagination
	 */
	public List<Customer> getListCriteriaOrderAndPagination() {
		return listCriteriaOrderAndPagination;
	}



	/**
	 * @return the listCriteriaStatistical
	 */
	public Object getListCriteriaStatistical() {
		return listCriteriaStatistical;
	}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String Test() {

//		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
//			sessionFactory=HibernateUtil.getSessionFactory();
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			System.out.println("一对多级联保存");
			customer1= new Customer();
			customer1.setCustName("腾讯");
			customer1.setCustLevel("vip");
			customer1.setCustSource("网络");
			customer1.setCustPhone("54749110");
			customer1.setCustMobile("110");
			customer2= new Customer();
			customer2.setCustName("百度");
			customer2.setCustLevel("vip");
			customer2.setCustSource("网络");
			customer2.setCustPhone("54749110");
			customer2.setCustMobile("110");
			linkMan1 = new LinkMan();
			linkMan1.setLkm_name("Jenny");
			linkMan1.setLkm_gender("female");
			linkMan1.setLkm_phone("911");
			linkMan2 = new LinkMan();
			linkMan2.setLkm_name("Micle");
			linkMan2.setLkm_gender("male");
			linkMan2.setLkm_phone("120");
			customer1.getSetLinkMan().add(linkMan1);
			customer1.getSetLinkMan().add(linkMan2);
			//linkMan1.setCustomer(customer);
			//linkMan2.setCustomer(customer);
			session.save(customer1);
			session.save(customer2);
			//session.save(linkMan1);
			//session.save(linkMan2);
			
			System.out.println("一对多级联修改");
			linkMan4=session.get(LinkMan.class, 1);
			customer4=session.get(Customer.class, 2);
			if(null!=linkMan4 && null!=customer4 ) {
				customer4.getSetLinkMan().add(linkMan4);
				linkMan4.setCustomer(customer4);
			}
			System.out.println("多对多级联保存");
			user1=new User();
			user1.setName("李小龙");
			user1.setPassword("12345687");
			user1.setSex("male");
			user2=new User();
			user2.setName("霍元甲");
			user2.setPassword("12345687");
			user2.setSex("male");
			user3=new User();
			user3.setName("爱迪生");
			user3.setPassword("12345687");
			user3.setSex("male");
			role1 =new Role();
			role1.setRole_name("中国人");
			role1.setRole_memo("武术家");
			role2 =new Role();
			role2.setRole_name("美国人");
			role2.setRole_memo("发明家");
			user=new User();
			user.setName("lvhongbin");
			user.setPassword("12345687");
			user.setSex("male");
			user1.getSetRole().add(role1);
			user2.getSetRole().add(role1);
			user3.getSetRole().add(role2);
			session.save(user1);
			session.save(user2);
			session.save(user3);
			session.save(user);
			System.out.println("多对多级联修改-添加角色");
			//User user8 =session.get(User.class,200);
			//Role role8 =session.get(Role.class,77);
			//user8.getSetRole().add(role8);
			System.out.println("对象导航查询");
			if (null!=session.get(Customer.class,97)) {
				Customer customer8 = session.get(Customer.class,125) ;
				Set<LinkMan> linkMan8= customer8.getSetLinkMan();
				System.out.println("对象导航查询结果：");
				for(LinkMan linkMan8For:linkMan8) {
					System.out.println(linkMan8For.toString());
				}
			}else {
				System.out.println("id=125的客户不存在");
			}
			System.out.println("使用Query方法进行查询");
			Query<User> query=session.createQuery("from User");
			list1=query.list();
			for(User user2:list1) {
				System.out.println(user2);
			}
			System.out.println("使用Query方法进行条件查询");
			Query queryCondition=session.createQuery("from Customer othername where othername.custName=?");
			queryCondition.setParameter(0, "百度");
			listCondition=queryCondition.list();
			for(Customer Customer9:listCondition) {
				System.out.println("客户id："+Customer9.getCid()+"客户姓名："+Customer9.getCustName()+"\n客户手机号："+Customer9.getCustMobile());
			}
			System.out.println("使用Query方法进行模糊查询");
			Query queryConditionFuzzy=session.createQuery("from Customer othername where othername.custName like ?");
			queryConditionFuzzy.setParameter(0, "%腾%");
			listConditionFuzzy=queryConditionFuzzy.list();
			for(Customer Customer9:listConditionFuzzy) {
				System.out.println("客户id："+Customer9.getCid()+"客户姓名："+Customer9.getCustName()+"\n客户手机号："+Customer9.getCustMobile());
			}
			System.out.println("使用Query方法进行排序查询");
			Query queryOrder=session.createQuery("from Customer order by cid desc");
			listOrder=queryOrder.list();
			for(Customer Customer9:listOrder) {
				System.out.println("客户id："+Customer9.getCid()+"客户姓名："+Customer9.getCustName()+"\n客户手机号："+Customer9.getCustMobile());
			}
			System.out.println("使用Query方法进行分页查询-每页两个记录");
			Query queryPagination=session.createQuery("from Customer");
			queryPagination.setFirstResult(0);
			queryPagination.setMaxResults(2);
			listPagination=queryPagination.list();
			for(Customer Customer9:listPagination) {
				System.out.println("客户id："+Customer9.getCid()+"客户姓名："+Customer9.getCustName()+"\n客户手机号："+Customer9.getCustMobile());
			}
			System.out.println("使用Query方法进行投影查询--客户姓名");
			Query queryProjection=session.createQuery("select custName from Customer");
			listProjection=queryProjection.list();
			for(Object Customer9:listProjection) {
				System.out.println("客户姓名："+Customer9.toString());
			}
			System.out.println("使用Query方法进行聚合查询--表记录数");
			Query queryAggregate=session.createQuery("select count(*) from Customer");
			listAggregate=queryAggregate.uniqueResult();
			Long listAggregateLong=(Long) listAggregate;
			System.out.println("客户记录数 ："+listAggregateLong.intValue());
			System.out.println("使用Criteria方法进行全部查询");			
			Criteria criteriaAll =session.createCriteria(User.class);
			list3=criteriaAll.list();
			for(User user4:list3) {
				System.out.println(user4);
			}
			System.out.println("使用Query方法进行多页查询--内连接");
			Query queryInnerJoin=session.createQuery("from Customer c inner join c.setLinkMan");
			listInnerJoin=queryInnerJoin.list();
			for(Object[] Customer9:listInnerJoin) {
				System.out.println(Customer9.toString());
			}
			System.out.println("使用Query方法进行多页查询--迫切内连接");
			Query queryInnerJoin1=session.createQuery("from Customer c inner join c.setLinkMan");
			listInnerJoin=queryInnerJoin1.list();
			for(Object[] Customer9:listInnerJoin) {
				System.out.println(Customer9.toString());
			}
			System.out.println("使用Criteria方法进行条件查询--id>190");
			Criteria criteriaCondition=session.createCriteria(Customer.class);
			criteriaCondition.add(Restrictions.eq("custName", "百度"));
			criteriaCondition.add(Restrictions.ge("cid", 190));
			if (null!=criteriaCondition.list()) {
				listCriteriaCondition=criteriaCondition.list();
				for(Customer criteriaCustomer:listCriteriaCondition) {
					System.out.println("客户id："+criteriaCustomer.getCid()+"客户姓名："+criteriaCustomer.getCustName()+"\n客户手机号："+criteriaCustomer.getCustMobile());
				}
			}else {
				System.out.println("使用Criteria方法进行条件查询,记录数为0");
			}
			System.out.println("使用Criteria方法进行模糊查询");
			Criteria criteriaConditionFuzzy=session.createCriteria(Customer.class);
			criteriaConditionFuzzy.add(Restrictions.like("custName", "%腾%"));
			if (null!=criteriaConditionFuzzy.list()) {
				listCriteriaConditionFuzzy=criteriaConditionFuzzy.list();
				for(Customer criteriaCustomer:listCriteriaConditionFuzzy) {
					System.out.println("客户id："+criteriaCustomer.getCid()+"客户姓名："+criteriaCustomer.getCustName()+"\n客户手机号："+criteriaCustomer.getCustMobile());
				}
			}else {
				System.out.println("使用Criteria方法进行模糊查询,记录数为0");
			}
			System.out.println("使用Criteria方法进行排列和分页查询");
			Criteria criteriaOrderAndPagination=session.createCriteria(Customer.class);
			criteriaOrderAndPagination.addOrder(Order.desc("cid"));
			criteriaOrderAndPagination.setFirstResult(0);
			criteriaOrderAndPagination.setMaxResults(2);
			if (null!=criteriaOrderAndPagination.list()) {
				listCriteriaOrderAndPagination=criteriaOrderAndPagination.list();
				for(Customer criteriaCustomer:listCriteriaOrderAndPagination) {
					System.out.println("客户id："+criteriaCustomer.getCid()+"客户姓名："+criteriaCustomer.getCustName()+"\n客户手机号："+criteriaCustomer.getCustMobile());
				}
			}else {
				System.out.println("使用Criteria方法进行模糊查询,记录数为0");
			}
			System.out.println("使用Criteria方法进行统计和离线查询");
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
			Criteria criteriaStatistical=detachedCriteria.getExecutableCriteria(session);
			criteriaStatistical.setProjection(Projections.rowCount());
			listCriteriaStatistical=criteriaStatistical.uniqueResult();
			if (null!=listCriteriaStatistical) {
				Long listCriteriaStatisticalLong=(Long) listCriteriaStatistical;
				System.out.println("使用Criteria方法进行模糊查询,记录数为"+listCriteriaStatisticalLong.intValue());
			}else {
				System.out.println("使用Criteria方法进行模糊查询,记录数为0");
			}
			
			System.out.println("使用SQLQuery方法进行查询1");
			SQLQuery<Object[]> sqlQuery =session.createSQLQuery("SELECT * from tbl_user1");
			list5=sqlQuery.list();
			if(null!=list5) {
				for(Object[] Objects:list5) {
					System.out.println(Arrays.toString(Objects));
				}
			}else {
				System.out.println("使用SQLQuery方法进行查询2,结果为空");
			}
			System.out.println("使用SQLQuery方法进行查询2");
			SQLQuery sqlQuery2 =session.createSQLQuery("SELECT * from tbl_user1");
			if(null!=sqlQuery2) {
				sqlQuery2.addEntity(User.class);
				list6=sqlQuery2.list();
				for(User user7:list6) {
					System.out.println(user7);	
				}
			}else {
				System.out.println("使用SQLQuery方法进行查询2,结果为空");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			//session.close();
			//sessionFactory.close();
		}
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String delete() {

		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			System.out.println("一对多级联删除");
			Query<Customer> query1=session.createQuery("from Customer");
			List<Customer> list7 =query1.list();
			if(list7.size()>2) {
				for(int i=0;i<list7.size()-2;i++) {	
					session.delete(list7.get(i));
				}
			}
			System.out.println("多对多级联删除");
			Query<User> query2=session.createQuery("from User");
			List<User> list8 =query2.list();
			if(list8.size()>4) {
				for(int i=0;i<list8.size()-4;i++) {
					session.delete(list8.get(i));
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			
		}
		return Test();
	}
//			
			
	

}

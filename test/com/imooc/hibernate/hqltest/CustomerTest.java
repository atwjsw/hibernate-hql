package com.imooc.hibernate.hqltest;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.model.Commodity;
import com.imooc.model.Customer;
import com.imooc.util.HibernateUtil;

public class CustomerTest {
	private Session session = null;
	
	@Test
	public void testOrderby(){
		
	}
	
	@Test
	public void testWhere4(){
		//String hql = "from Customer c where c.name = '张三'";
		String hql = "from Customer c where c.age > 20";
		Query query = session.createQuery(hql);
		Customer c = (Customer) query.uniqueResult();		
		
		System.out.println(c.getName() + "   " + c.getAddress());
				
	}
	
	@Test
	public void testWhere3(){
		
		//String hql = "from Customer c where c.name like '张_'";
		String hql = "from Customer c where c.address like '%北京%'";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		
		for (Customer c: list) {
			System.out.println(c.getName() + "   " + c.getAddress());
		}
		
	}
	
	@Test
	public void testWhere2(){
		
	}
	
	@Test
	public void testWhere1(){
		
		String hql = "from Customer c where c.age between 20 and 35";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		
		for (Customer c: list) {
			System.out.println(c.getName() + "   " + c.getAge());
		}
	
	}
	
	@Test
	public void testDistinct(){
		
		String hql = "select distinct c.sex from Customer c";
		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		
		for (Object o: list) {
			System.out.println(o);
		}
			
	}
	
	@Test
	public void testSelectClauseMap(){
	
	}
	
	@Test
	public void testSelectClauseList(){
		
	}
	
	@Test
	public void testSelectClauseObjectArray(){
		
	}
	
	@Test
	public void testFromClause(){
		
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();
		
		for (Customer customer: customers) {
			System.out.println(customer);
		}
	
	}

	@Before
	public void setUp() throws Exception {
		session = HibernateUtil.getSession();
	}

	@After
	public void tearDown() throws Exception {
		HibernateUtil.closeSession(session);
	}

}

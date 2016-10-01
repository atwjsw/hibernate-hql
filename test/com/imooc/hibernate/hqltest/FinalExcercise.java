package com.imooc.hibernate.hqltest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.util.HibernateUtil;
import com.imooc.model.Commodity;
import com.imooc.model.Order;

/*
 * 两个课后案例
 */
public class FinalExcercise {
	
	private Session session = null;
	
	@Test
	public void testExcercise1() {
		String hql = "select new Commodity(c.name, c.price, c.seller) from Commodity c"
				+ " where c.price>=10 and c.category like '%书%'"
				+ " order by c.seller.name asc, c.price desc, c.name asc";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println(c.getSeller().getName() + "   " + c.getSeller().getBusiness() + "   " + c.getPrice() + "   " + c.getName());
		}		
	}
	
	@Test
	public void testExcercise2() {
		//o.tradeDate between '2015-05-01' and '2015-06-01' and 
		//String hql = " from Order o where o.orderItems is not empty ";
		String hql = "select new list(o.customer.name, o.tradeDate, o.status, o.amount) from Order o"
				+ " where o.tradeDate between '2015-05-01' and '2015-05-30' and o.status in ('已发货','已付款') and o.amount>500"
				+ " order by o.status asc, o.tradeDate desc, o.amount desc";
		Query query = session.createQuery(hql);
		List<List> orders = query.list();
		
		for (List l: orders) {
			System.out.println(l.get(0) + "   " + l.get(1) + "   " + l.get(2) + l.get(3));
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

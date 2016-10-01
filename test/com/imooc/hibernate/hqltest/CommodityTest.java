package com.imooc.hibernate.hqltest;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.model.Commodity;
import com.imooc.model.Seller;
import com.imooc.util.HibernateUtil;

public class CommodityTest {
	private Session session = null;
	
	@Test
	public void testOrderby(){
		
		//String hql = " from Commodity c order by c.price asc";
		String hql = " from Commodity c order by c.seller asc, c.price desc";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println("商品名称: " + c.getName() + "   商家：" + c.getSeller().getName() + "   价格：" + c.getPrice());			
		}			
	}
	
	@Test
	public void testWhere4(){
		
		String hql = " from Commodity c where c.price*5>3000";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println("商品名称: " + c.getName() + "   品类：" + c.getCategory() + "   价格*5：" + c.getPrice()*5);			
		}		
	
	}
	
	@Test
	public void testWhere3(){
		
		String hql = " from Commodity c where c.price between 100 and 500 or c.category like '%电脑%'";
		//String hql = " from Commodity c where c.price between 100 and 500 and c.category like '%电脑%'";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println("商品名称: " + c.getName() + "   品类：" + c.getCategory() + "   价格：" + c.getPrice());			
		}		
		
		
	}
	
	@Test
	public void testWhere2(){
		
		String hql = " from Commodity c where c.description is not null";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println("商品名称: " + c.getName() + "   简介：" + c.getDescription());			
		}		
	}
	
	@Test
	public void testWhere1(){
		
		String hql = " from Commodity c where c.price > 400";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println("商品名称: " + c.getName() + "   价格：" + c.getPrice());
			
		}
		
	
	}
	
	@Test
	public void testFromClause(){
		
		String hql = "from Commodity";
		Query query = session.createQuery(hql);
		List<Commodity> commodities = query.list();
		
		for (Commodity c: commodities) {
			System.out.println("商品名称: " + c.getName());
			//由于默认是懒加载，如果不去查阅Seller，是不会发送商家查询的SQL的。			
			System.out.println("商家名称: " + c.getSeller().getName());
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

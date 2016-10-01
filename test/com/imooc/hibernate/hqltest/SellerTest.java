package com.imooc.hibernate.hqltest;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.imooc.model.Seller;
import com.imooc.util.HibernateUtil;

public class SellerTest {
	private Session session = null;
	
	@Test
	public void testSelectClauseSelf(){
		
		String hql = " select new Seller(s.name as name, s.tel as tel, s.address as address) from Seller s";
		
		Query query = session.createQuery(hql);
		List<Seller> sellers = query.list();

		for (Seller s: sellers) {
			System.out.println(s);
		}

	}
	
	@Test
	public void testSelectClauseMap(){
		
		String hql = " select new map(s.name as name, s.tel as tel, s.address as address, s.star as star) from Seller s";
		
		Query query = session.createQuery(hql);
		List<Map> list = query.list();
		for (Map m: list ) {
			//System.out.println(m.get("0") + "  " + m.get("1") + "  " + m.get("2") + "  " + m.get("3"));
			System.out.println(m.get("name") + "  " + m.get("tel") + "  " + m.get("address") + "  " + m.get("star"));
		}

	}
	
	@Test
	public void testSelectClauseList(){
		
		String hql = " select new list(s.name, s.tel, s.address, s.star) from Seller s";
		
		Query query = session.createQuery(hql);
		List<List> list = query.list();
		for (List l: list ) {
			System.out.println(l.get(0) + "  " + l.get(1) + "  " + l.get(2) + "  " + l.get(3));
		}

	}
	
	/*
	 * 当查询返回只需要特定字段时，可以返回Object[]
	 * 1.name 2.tel 3.address 4.star
	 */
	@Test
	public void testSelectClauseObjectArray(){
		
		String hql = " select s.name, s.tel, s.address, s.star from Seller s";
		
		Query query = session.createQuery(hql);
		List<Object[]> objs = query.list();
		for (Object[] objArr: objs ) {
			System.out.println(objArr[0] + "  " + objArr[1] + "  " + objArr[2] + "  " + objArr[3]);
		}
	}
	
	@Test
	public void testFromClause(){
		
		//String hql = "from Seller s";
		//String hql = "from com.imooc.model.Seller s";
		String hql ="from Seller as seller";
		Query query = session.createQuery(hql);
		List<Seller> sellers = query.list();
		
		for (Seller s: sellers) {
			System.out.println("商家名称：" + s.getName());
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

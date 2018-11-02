package testDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import misc.SpringJavaConfiguration;
import model.bean.ImportBean;
import model.dao.impl.ImportDAOImpl;
import model.dao.impl.ImportDetailDAOImpl;
import model.dao.impl.ProductDAOImpl;

public class TestImport {

	SessionFactory factory;
	Session session;
	AnnotationConfigApplicationContext context;

	@Before
	public void init() {
		context =new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		factory = (SessionFactory)context.getBean("sessionFactory");
		factory.getCurrentSession().beginTransaction();

		System.out.println("交易開始");
	}

	@After
	public void destroy() {
		try {
			factory.getCurrentSession().getTransaction().commit();
			System.out.println("交易結束");
			factory.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testProductDao() {
		ProductDAOImpl dao = context.getBean(ProductDAOImpl.class);
		System.out.println(dao.selectById(1));
	}
	
	@Test
	public void testDetailDao() {
		ImportDetailDAOImpl dao = context.getBean(ImportDetailDAOImpl.class);
		System.out.println(dao.selectAllByID(1));
		
//		System.out.println(dao.selectAll());
	}
	@Test
	public void testBrandDao() {
		ImportDAOImpl dao = context.getBean(ImportDAOImpl.class);
//		System.out.println(dao.selectByADOD("2018/05/04", "2018/05/06"));
//		System.out.println(dao.selectByADODS("2005/5/22", "2011/5/28", "on"));
//		System.out.println(dao.selectByADS("2005/07/20", "on"));
//		System.out.println(dao.selectAll());		
//		System.out.println(dao.selectByArrivedate("2018/06/21") + "arrivedate=======");
//		System.out.println(dao.selectByStatus("on"));
//		System.out.println(dao.selectByOrderdate("2018/01/20"));
		System.out.println(dao.updateStatus("on", 1));;
	
//	    System.out.println(dao.updateStatus("on"));
		
		
		
		
//		System.out.println(dao.selectById(1));

	}

	
}

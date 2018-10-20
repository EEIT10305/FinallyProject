package testDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import misc.SpringJavaConfiguration;
import model.CategoryBean;
import model.dao.CategoryDAO;

public class TestDAO {

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
	public void testCategoryDao() {
		CategoryBean bean = new CategoryBean(1, "CPU", "cpu");
		CategoryDAO cd = context.getBean(CategoryDAO.class);
		cd.insert(bean);
		System.out.println(cd.selectAll());
		System.out.println(cd.selectById(1));
//		System.out.println(cd.update(bean));
	}
	
	

	
}

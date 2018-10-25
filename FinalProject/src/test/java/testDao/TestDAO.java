package testDao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import misc.SpringJavaConfiguration;
import misc.SystemUtils2018;
import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.ProductBean;
import model.dao.BrandDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;

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
//		cd.insert(bean);
		System.out.println(cd.selectAll());
		System.out.println(cd.selectById(1));
//		System.out.println(cd.update(bean));
	}
	@Test
	public void testBrandDao() {
		BrandBean bean = new BrandBean(1,"Asus" );
		BrandDAO dao = context.getBean(BrandDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testProductDao() {
		try {
			ProductBean bean = 
					new ProductBean(1, 1, 1, "hello2", 200, SystemUtils2018.fileToBlob("C:\\temp\\normal.png"), "ok");
			ProductDAO dao = context.getBean(ProductDAO.class);
//			dao.insert(bean);
//			System.out.println(dao.selectAll());
//			System.out.println(dao.selectById(1).getCategoryBean().getCategory());
			System.out.println(dao.update(bean));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	

	
}

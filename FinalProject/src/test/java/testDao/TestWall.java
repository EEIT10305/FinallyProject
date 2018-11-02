package testDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import misc.SpringJavaConfiguration;
import misc.SystemUtils2018;
import model.bean.AllStockBean;
import model.bean.BranchBean;
import model.bean.BranchStockBean;
import model.bean.BrandBean;
import model.bean.CabinetBean;
import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.bean.MbBean;
import model.bean.MemberBean;
import model.bean.MessageBean;
import model.bean.OrderDetailBean;
import model.bean.OrderListBean;
import model.bean.PinginBean;
import model.bean.PinginDetailBean;
import model.bean.PowerSupplierBean;
import model.bean.ProductBean;
import model.bean.RamBean;
import model.bean.StaffBean;
import model.bean.StorageBean;
import model.bean.TransferBean;
import model.bean.VgaBean;
import model.bean.WallBean;
import model.bean.WishBean;
import model.dao.AllStockDAO;
import model.dao.BranchDAO;
import model.dao.BranchStockDAO;
import model.dao.BrandDAO;
import model.dao.CabinetDAO;
import model.dao.CartDAO;
import model.dao.CartDetailDAO;
import model.dao.CategoryDAO;
import model.dao.CpuDAO;
import model.dao.ImportDAO;
import model.dao.ImportDetailDAO;
import model.dao.MbDAO;
import model.dao.MemberDAO;
import model.dao.MessageDAO;
import model.dao.OrderDetailDAO;
import model.dao.OrderListDAO;
import model.dao.PinginDAO;
import model.dao.PinginDetailDAO;
import model.dao.PowerSupplierDAO;
import model.dao.ProductDAO;
import model.dao.RamDAO;
import model.dao.StaffDAO;
import model.dao.StorageDAO;
import model.dao.TransferDAO;
import model.dao.VgaDAO;
import model.dao.WallDAO;
import model.dao.WishDAO;

public class TestWall {

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
	public void testWallDao() {
		
//		WallBean bean1 = new WallBean(null,"banner_15397442985bc6a22a049f5.jpg",0 ,"on");
//		WallBean bean2 = new WallBean(null,"banner_15374341845ba36248a005d.jpg",0 ,"on");
//		WallBean bean3 = new WallBean(null,"banner_15390539295bbc196934c2b.jpg",0 ,"on");
//		WallBean bean6 = new WallBean(null,"banner_15390539295bbc196934c2b.jpg",0 ,"off");
		WallDAO dao = context.getBean(WallDAO.class);
//		System.out.println(dao.updateBySrc(2, "image/banner_15390539295bbc196934c2b.jpg"));
		
//		dao.insert(bean1);
//		dao.insert(bean2);
//		dao.insert(bean3);
//		dao.insert(bean6);
//		System.out.println(dao.selectNeedPhoto());
//		WallBean bean4 = new WallBean(2,"banner_15374341845ba36248a005d.jpg",2 ,"on");
//		WallBean bean5 = new WallBean(3,"banner_15390539295bbc196934c2b.jpg",1 ,"on");
//		dao.update(bean4);
//		dao.update(bean5);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
	}
	

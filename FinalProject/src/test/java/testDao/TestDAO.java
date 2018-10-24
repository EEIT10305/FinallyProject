package testDao;

import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import misc.SpringJavaConfiguration;
import misc.SystemUtils2018;
import model.AllStockBean;
import model.BranchBean;
import model.BranchStockBean;
import model.BrandBean;
import model.CabinetBean;
import model.CartBean;
import model.CartDetailBean;
import model.CategoryBean;
import model.CpuBean;
import model.ImportBean;
import model.ImportDetailBean;
import model.MbBean;
import model.MemberBean;
import model.MessageBean;
import model.OrderDetailBean;
import model.OrderListBean;
import model.PinginBean;
import model.PinginDetailBean;
import model.PowerSupplierBean;
import model.ProductBean;
import model.RamBean;
import model.StaffBean;
import model.StorageBean;
import model.TransferBean;
import model.VgaBean;
import model.WishBean;
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
import model.dao.WishDAO;

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
		CategoryDAO dao = context.getBean(CategoryDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
	
	
	@Test
	public void testBrandDao() {
		BrandBean bean = new BrandBean(1,"Asus" );
		BrandDAO dao = context.getBean(BrandDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testProductDao() {
		try {
			ProductBean bean = 
					new ProductBean(1, 1, 1, "hello2", 200, SystemUtils2018.fileToBlob("C:\\temp\\normal.png"), "ok");
			ProductDAO dao = context.getBean(ProductDAO.class);
			dao.insert(bean);
//			System.out.println(dao.selectAll());
//			System.out.println(dao.selectById(1).getCategoryBean().getCategory());
//			System.out.println(dao.update(bean));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testMemberDao() {
		MemberBean bean = new MemberBean(1, "CPU", "cpu888", "cpu","cpu","cpu","cpu","cpu");
		MemberDAO dao = context.getBean(MemberDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));
	}

	@Test
	public void testOrderListDao() {
		OrderListBean bean = new OrderListBean(1, "1993-05-04", 1 ,300,"shipping");
		OrderListDAO dao = context.getBean(OrderListDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testOrderDetailDao() {
		OrderDetailBean bean = new OrderDetailBean(1, 1, 2,"brand2","category2","model2",12,12);
		OrderDetailDAO dao = context.getBean(OrderDetailDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testCartDao() {
		CartBean bean = new CartBean(1, 1, "1993-05-042","ok2");
		CartDAO dao = context.getBean(CartDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
		System.out.println(dao.delete(bean));
	}
	
	@Test
	public void testCartDetailDao() {
		CartDetailBean bean = new CartDetailBean(1, 1, 1, 2);
		CartDetailDAO dao = context.getBean(CartDetailDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
		System.out.println(dao.delete(bean));
	}
	
	@Test
	public void testWishDao() {
		WishBean bean = new WishBean(1, 1, 1, 2);
		WishDAO dao = context.getBean(WishDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
		System.out.println(dao.delete(bean));
	}
	@Test
	public void testVgaDao() {
		VgaBean bean = new VgaBean(1, 1, "brand1", 1,"model1",12,"ok1",12);
		VgaDAO dao = context.getBean(VgaDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testCpuDao() {
		CpuBean bean = new CpuBean(1, 1, "brand1", 1,"model1",2,"ok11","10501",12);
		CpuDAO dao = context.getBean(CpuDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testCabinetDao() {
		CabinetBean bean = new CabinetBean(1, 1, "brand12", 1,"model21",2,"ok",1);
		CabinetDAO dao = context.getBean(CabinetDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testRamDao() {
		RamBean bean = new RamBean(1, 1, "brand", 1,"model",1,"okk","ddr8",2);
		RamDAO dao = context.getBean(RamDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testMbDao() {
		MbBean bean = new MbBean(1, 1, "brand2", 1,"model2",1,"ok2","10502","ddr4",2,"size2");
		MbDAO dao = context.getBean(MbDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testStorageDao() {
		StorageBean bean = new StorageBean(1, 1, "brand2", 1,"model2",10,"ok2",10);
		StorageDAO dao = context.getBean(StorageDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testPowerSupplierDao() {
		PowerSupplierBean bean = new PowerSupplierBean(1, 1, "brand2", 1,"model2",100,"ok2",1);
		PowerSupplierDAO dao = context.getBean(PowerSupplierDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testPinginDao() {
		PinginBean bean;
		try {
			bean = new PinginBean(1, 1, "game2", 1002,"ok2",SystemUtils2018.fileToBlob("C://temp//normal.png"));
			PinginDAO dao = context.getBean(PinginDAO.class);
//			dao.insert(bean);
//			System.out.println(dao.selectAll());
//			System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPinginDetailDao() {
		PinginDetailBean bean = new PinginDetailBean(1, 1, "game2", "brand2","cpu2","model2",10);
		PinginDetailDAO dao = context.getBean(PinginDetailDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testImportDao() {
		ImportBean bean = new ImportBean(1, "11-05", "11-15","ok");
		ImportDAO dao = context.getBean(ImportDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testImportDetailDao() {
		ImportDetailBean bean = new ImportDetailBean(1,1,1,12);
		ImportDetailDAO dao = context.getBean(ImportDetailDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testBranchDao() {
		BranchBean bean = new BranchBean(2,"name2","taipei2","220988");
		BranchDAO dao = context.getBean(BranchDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testBranchStockDao() {
		BranchStockBean bean = new BranchStockBean(1,1,1,12,"ok5");
		BranchStockDAO dao = context.getBean(BranchStockDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testTransferDao() {
		TransferBean bean = new TransferBean(1,"10-18",1,5,1,2);
		TransferDAO dao = context.getBean(TransferDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testMessageDao() {
		MessageBean bean = new MessageBean(1,1,2,"10-18","hello555");
		MessageDAO dao = context.getBean(MessageDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	@Test
	public void testAllStockDao() {
		AllStockBean bean = new AllStockBean(1,12,"brand2",12,"model2",12,12,"ok2");
		AllStockDAO dao = context.getBean(AllStockDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testStaffDao() {
		StaffBean bean = new StaffBean(1, "CPU", "cpu", "cpu","cpu","cpu","cpu");
		StaffDAO dao = context.getBean(StaffDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		System.out.println(dao.update(bean));
	}
}

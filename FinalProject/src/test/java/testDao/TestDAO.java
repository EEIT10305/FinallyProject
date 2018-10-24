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
		CategoryBean bean = new CategoryBean(null, "CPU", "cpu");
		CategoryDAO dao = context.getBean(CategoryDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
     //	System.out.println(dao.update(bean));
	}
	
	
	@Test
	public void testBrandDao() {
		BrandBean bean = new BrandBean(null,"Acer" );
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
					new ProductBean(null, 1, 1, "hello3", 200, SystemUtils2018.fileToBlob("C:\\temp\\normal.png"), "ok");
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
		MemberBean bean = new MemberBean(1, "Ram", "ram666", "ram","ram","ram","ram","ram");
		MemberDAO dao = context.getBean(MemberDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}

	@Test
	public void testOrderListDao() {
		OrderListBean bean = new OrderListBean(null, "1990-05-04", 2 ,600,"shipping");
		OrderListDAO dao = context.getBean(OrderListDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testOrderDetailDao() {
		OrderDetailBean bean = new OrderDetailBean(null, 1, 2,"brand1","category1","model1",12,12);
		OrderDetailDAO dao = context.getBean(OrderDetailDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testCartDao() {
		CartBean bean = new CartBean(null,"1990-05-04",2,"ok1");
		CartDAO dao = context.getBean(CartDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
//		CartBean bean2 = (dao.selectById(1));
//		System.out.println(dao.delete(bean2));
	}
	
	@Test
	public void testCartDetailDao() {
		CartDetailBean bean = new CartDetailBean(null, 2, 1, 1);
		CartDetailDAO dao = context.getBean(CartDetailDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
//		System.out.println(dao.delete(bean));
	}
	
	@Test
	public void testWishDao() {
		WishBean bean = new WishBean(null, 1, 1, 1);
		WishDAO dao = context.getBean(WishDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	//	System.out.println(dao.delete(bean));
	}
	@Test
	public void testVgaDao() {
		VgaBean bean = new VgaBean(null,"brand1", 1,"model1",12,2,12,"ok1");
		VgaDAO dao = context.getBean(VgaDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testCpuDao() {
		CpuBean bean = new CpuBean(null, "brand1", 1,"10501","model1",3, 1,12,"ok11");
		CpuDAO dao = context.getBean(CpuDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testCabinetDao() {
		CabinetBean bean = new CabinetBean(null,  "brand12", 2,"model21",2,2,2,"ok");
		CabinetDAO dao = context.getBean(CabinetDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testRamDao() {
		RamBean bean = new RamBean(1,"brand", 1,"ddr8","model",1,2,2,"okk");
		RamDAO dao = context.getBean(RamDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testMbDao() {
		MbBean bean = new MbBean(1,  "brand2", 1,"ddr4","10502","model2",1,2,2,"size2","ok2");
		MbDAO dao = context.getBean(MbDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testStorageDao() {
		StorageBean bean = new StorageBean(1,"brand2", 1,"model2",10, 2,10,"ok2");
		StorageDAO dao = context.getBean(StorageDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testPowerSupplierDao() {
		PowerSupplierBean bean = new PowerSupplierBean(1,"brand2", 1,"model2",100,2,1,"ok2");
		PowerSupplierDAO dao = context.getBean(PowerSupplierDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testPinginDao() {
		PinginBean bean;
		try {
			bean = new PinginBean(3,"game2",SystemUtils2018.fileToBlob("C://temp//normal.png"), 1002,2,"ok2");
			PinginDAO dao = context.getBean(PinginDAO.class);
			dao.insert(bean);
//			System.out.println(dao.selectAll());
//			System.out.println(dao.selectById(1));
//			System.out.println(dao.update(bean));		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPinginDetailDao() {
		PinginDetailBean bean = new PinginDetailBean(1, "brand2","cpu2" ,"model2","game2" ,1,10);
		PinginDetailDAO dao = context.getBean(PinginDetailDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(2));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testImportDao() {
		ImportBean bean = new ImportBean(null,"11-15","11-05","ok");
		ImportDAO dao = context.getBean(ImportDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testImportDetailDao() {
		ImportDetailBean bean = new ImportDetailBean(null,12,1,1);
		ImportDetailDAO dao = context.getBean(ImportDetailDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testBranchDao() {
		BranchBean bean = new BranchBean(null,"taipei2","name2","220988");
		BranchDAO dao = context.getBean(BranchDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testBranchStockDao() {
		BranchStockBean bean = new BranchStockBean(null,12,1,2,"ok5");
		BranchStockDAO dao = context.getBean(BranchStockDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testTransferDao() {
		TransferBean bean = new TransferBean(null,5,2,1,"10-19",2);
		TransferDAO dao = context.getBean(TransferDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testMessageDao() {
		MessageBean bean = new MessageBean(1,"10-18",1,2,"hello555");
		MessageDAO dao = context.getBean(MessageDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testAllStockDao() {
		AllStockBean bean = new AllStockBean(1,"brand2",2,"model2",12,"ok2",1,12);
		AllStockDAO dao = context.getBean(AllStockDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	
	@Test
	public void testStaffDao() {
		StaffBean bean = new StaffBean(1, "Taiwan", "ABC@III.com", "AAA","BBB","XX","09222");
		StaffDAO dao = context.getBean(StaffDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
}

package testDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
import model.service.CartDAO;

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
	public void testCartDetailDelete() {
		CartDetailDAO dao = context.getBean(CartDetailDAO.class);
		List<CartDetailBean> aa = (List<CartDetailBean>)dao.selectbycartId(18);
		System.out.println(aa);
		Boolean selects = dao.deletebycartId(18);
		System.out.println(selects);
	}
	
	@Test
	public void testCartDelete() {
		CartDAO dao = context.getBean(CartDAO.class);
		List<CartBean> aa =  (List<CartBean>) dao.selectById(9);
		System.out.println(aa);
		Boolean selects = dao.deletebyCartId(9);
		System.out.println(selects);
	}
	
	@Test
	public void testCategoryDao() {
		CategoryBean bean = new CategoryBean(null, "Ram", "Ram");
		CategoryDAO dao = context.getBean(CategoryDAO.class);
		
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//123	System.out.println(dao.selectById(1));
		//	System.out.println(dao.update(bean));
		
	}
	
	@Test
	public void testWallDao() {
		WallBean bean1 = new WallBean(null,"image/banner_15397442985bc6a22a049f5.jpg",0 ,"on");
		WallBean bean2 = new WallBean(null,"image/banner_15374341845ba36248a005d.jpg",1 ,"on");
		WallBean bean3 = new WallBean(null,"image/banner_15390539295bbc196934c2b.jpg",2 ,"on");
		WallBean bean6 = new WallBean(null,"image/banner_15390539295bbc196934c2b.jpg",-1 ,"off");
		WallDAO dao = context.getBean(WallDAO.class);
		dao.insert(bean1);
		dao.insert(bean2);
		dao.insert(bean3);
		dao.insert(bean6);
		System.out.println(dao.selectNeedPhoto());
//		WallBean bean4 = new WallBean(2,"banner_15374341845ba36248a005d.jpg",2 ,"on");
//		WallBean bean5 = new WallBean(3,"banner_15390539295bbc196934c2b.jpg",1 ,"on");
//		dao.update(bean4);
//		dao.update(bean5);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
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
					new ProductBean(null, 1, 1,0, "hello3", 200, SystemUtils2018.fileToBlob("C:\\temp\\normal.png"), "ok");
			ProductDAO dao = context.getBean(ProductDAO.class);
//			dao.insert(bean);
//			System.out.println(dao.selectAll());
//			System.out.println(dao.selectById(1).getCategoryBean().getCategory());
//			System.out.println(dao.update(bean));
			List<ProductBean> list =dao.selectByCategory(1);
			System.out.println(list.get(1).getProid());
			System.out.println(list.get(1).getBrandid());
			System.out.println(list.get(1).getCategoryid());
			System.out.println(list.get(1).getModel());
			System.out.println(list.get(1).getPrice());
			System.out.println(list.get(1).getStatu());
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
		OrderListBean bean = new OrderListBean(null,"Taipei","已到達","1990-05-04", 2 ,"shipping",600,"未付款");
		OrderListDAO dao = context.getBean(OrderListDAO.class);
		dao.insert(bean);
		System.out.println(dao.selectAll());
		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));
	}
	
	@Test
	public void testOrderDetailDao() {
//		OrderDetailBean bean = new OrderDetailBean(null, 1, 2,"brand1","category1","model1",12,12);
		OrderDetailDAO dao = context.getBean(OrderDetailDAO.class);
//		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
		
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
		PinginDetailBean bean = new PinginDetailBean(1, "brand2","cpu2" ,"model2","game2" ,1,10,50);
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
		TransferBean bean = new TransferBean(null,5,2,1,"10-19",2,1);
		TransferDAO dao = context.getBean(TransferDAO.class);
		dao.insert(bean);
//		System.out.println(dao.selectAll());
//		System.out.println(dao.selectById(1));
//		System.out.println(dao.update(bean));		
	}
	@Test
	public void testMessageDao() {
		MessageBean bean = new MessageBean(null, 3, 5, "2018/11/08 11:05:28", "測試的內容\\n耶耶耶\n澳烏烏烏", "測試用的不要問", "notyet");
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

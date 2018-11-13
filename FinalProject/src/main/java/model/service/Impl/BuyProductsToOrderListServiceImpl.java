package model.service.Impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import allPay.payment.integration.AllInOne;
import allPay.payment.integration.domain.AioCheckOutDevide;
import model.bean.BranchStockBean;
import model.bean.CartDetailBean;
import model.bean.OrderDetailBean;
import model.bean.OrderListBean;
import model.dao.BranchStockDAO;
import model.dao.CartDetailDAO;
import model.dao.OrderDetailDAO;
import model.dao.OrderListDAO;
import model.service.BuyProductsToOrderListService;
import model.service.CartDAO;
@Service
@Transactional
public class BuyProductsToOrderListServiceImpl implements BuyProductsToOrderListService {
	
	@Autowired
	private OrderListDAO orderListDAO;
	@Autowired
	private CartDetailDAO cartDetailDAO;
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	@Autowired
	private BranchStockDAO branchStockDAO;
	@Autowired
	private CartDAO cartDAO;
	
//	public static AllInOne all;

	@Override
	public boolean CheckProductsToPayInService() {
		OrderListBean orderListBean =new OrderListBean();
		orderListDAO.insert(orderListBean);
		return true;
	}
	@Override
	public List<CartDetailBean> ShowCartDetailInService(Integer Cartid) {
		 
		return cartDetailDAO.selectAllByCartId(Cartid);
	}
	@Override
	public OrderListBean CheckOrderListByShopInService(String Name,String Address,Integer Price) {
		return orderListDAO.insert(new OrderListBean(null,Address,"處理中",
				 new SimpleDateFormat("yyyy/MM/dd").format(new Date()),
				 orderListDAO.selectMemberIdByEmail(Name).getMemberid(),
				 "門市取貨",Price,"1"));
	}
	@Override
	public OrderListBean CheckOrderListByHomeInService(String Name,String Address,Integer Price) {
		
		return orderListDAO.insert(new OrderListBean(null,Address,"處理中",
				 new SimpleDateFormat("yyyy/MM/dd").format(new Date()),
				 orderListDAO.selectMemberIdByEmail(Name).getMemberid(),
				 "宅配",Price,"1"));
	}
	@Override
	public String PayToOPayInService(String OrderID,String Price) {
		AllInOne all =  new AllInOne(""); 
		AioCheckOutDevide obj = new AioCheckOutDevide();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String price123 = Price;
		Date today = new Date();
		String now = sdf.format(today);
		obj.setMerchantTradeNo("Official2018"+OrderID);			//產生自己的訂單邏輯  每次訂單編號必須不一樣否則網頁會說重複不給執行 !!!訂單編號必定要是大小寫英文加上數字
		obj.setMerchantTradeDate(now);
		obj.setTotalAmount(price123);
		obj.setTradeDesc("test Description");
		obj.setItemName("3C產品");
	//	obj.setItemName("3c產品");
		obj.setReturnURL("http://localhost:8081/FinalProject/FirstPage.html");		//ex返回的網頁
		obj.setClientBackURL("http://localhost:8081/FinalProject/FirstPage.html");
//		obj.setNeedExtraPaidInfo("N");
//		obj.setHoldTradeAMT("0");
//		obj.setUseRedeem("N");
//		obj.setRedeem("N");
		String form = all.aioCheckOut(obj, null);
		
		return form;
	}
	
	@Override
	public Integer CheckOrderDetailInService(Integer OrderID,Integer CartID) {
		List<CartDetailBean> CDB=cartDetailDAO.selectAllByCartId(CartID);
		Integer count =0;
		for(int x =0;x<CDB.size();x++) {
			
			orderDetailDAO.insert(new OrderDetailBean(null,OrderID,CDB.get(x).getProid(),
								  CDB.get(x).getProductBean().getBrandBean().getBrand(),
								  CDB.get(x).getProductBean().getCategoryBean().getCategory(),
								  CDB.get(x).getProductBean().getModel(),
								  CDB.get(x).getAmount(),
								  CDB.get(x).getProductBean().getPrice()));
			count++;
		}
		Integer Amount=0;
		List<OrderDetailBean> ODB=orderDetailDAO.selectByOrderId(OrderID);
		for(int y=0;y<ODB.size();y++) {
			BranchStockBean BSB=branchStockDAO.selectbranchStock(ODB.get(y).getProid());
			Amount=BSB.getAmount()-ODB.get(y).getAmount();
			if(Amount>0) {
				branchStockDAO.updateBranchStock(Amount,BSB.getStatu(),BSB.getProid());	
				//cartDetailDAO.deletebycartId(CartID);  		//先不要刪掉
				cartDAO.updatestatus(CartID);
				
			}else {
			Amount=0;
			branchStockDAO.updateBranchStock(Amount,BSB.getStatu(),BSB.getProid());
			}
			}
		
		return count;
	}

}

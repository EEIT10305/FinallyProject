package model.service.Impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.CartDetailBean;
import model.bean.OrderDetailBean;
import model.bean.OrderListBean;
import model.dao.CartDetailDAO;
import model.dao.OrderDetailDAO;
import model.dao.OrderListDAO;
import model.service.BuyProductsToOrderListService;
@Service
@Transactional
public class BuyProductsToOrderListServiceImpl implements BuyProductsToOrderListService {
	
	@Autowired
	private OrderListDAO orderListDAO;
	@Autowired
	private CartDetailDAO cartDetailDAO;
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
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
	public Integer CheckOrderDetailInService(Integer OrderID,Integer CartID) {
		List<CartDetailBean> CDB=cartDetailDAO.selectAllByCartId(CartID);
		Integer count =0;
		for(int x =0;x<CDB.size();x++) {
			
			orderDetailDAO.insert(new OrderDetailBean(null,OrderID,CDB.get(x).getProid(),
								  CDB.get(x).getProductBean().getBrandBean().getBrand(),
								  CDB.get(x).getProductBean().getCategoryBean().getCategory(),
								  CDB.get(x).getProductBean().getModel(),
								  1,
								  CDB.get(x).getProductBean().getPrice()));
			count++;
		}
		return count;
	}

}

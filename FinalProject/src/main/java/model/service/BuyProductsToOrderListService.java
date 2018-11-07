package model.service;

import java.util.List;

import model.bean.CartDetailBean;
import model.bean.OrderListBean;

public interface BuyProductsToOrderListService {

	boolean CheckProductsToPayInService();

	OrderListBean CheckOrderListByHomeInService(String Name, String Address, Integer Price);

	OrderListBean CheckOrderListByShopInService(String Name, String Address, Integer Price);

	Integer CheckOrderDetailInService(Integer OrderID, Integer CartID);

	List<CartDetailBean> ShowCartDetailInService(Integer Cartid);

}

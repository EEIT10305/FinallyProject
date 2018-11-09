package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.OrderListBean;
import model.service.BuyProductsToOrderListService;

@Controller
public class BuyProductsToOrderListController {
	@Autowired
	private BuyProductsToOrderListService BPTOLS;
	
	@RequestMapping(path="CheckProductsToPay",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String CheckProductsToPayInController() {
		return new Gson().toJson(BPTOLS.CheckProductsToPayInService());
	}
	@RequestMapping(path="CheckOrderListByHome",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String CheckOrderListByHomeInController(String Name,String Address,Integer Price) {
		
		return new Gson().toJson(BPTOLS.CheckOrderListByHomeInService(Name,Address,Price));	
	}
	@RequestMapping(path="CheckOrderListByShop",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String CheckOrderListByShopInController(String Name,String Address,Integer Price) {
		
		return new Gson().toJson(BPTOLS.CheckOrderListByShopInService(Name,Address,Price));	
	}
	@RequestMapping(path="CheckOrderDetail",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String CheckOrderDetailInController(Integer OrderID,Integer CartID) {
		return new Gson().toJson(BPTOLS.CheckOrderDetailInService(OrderID,CartID));
	}
	@RequestMapping(path="ShowCartDetail",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String ShowCartDetailInController(Integer Cartid) {
		return new Gson().toJson(BPTOLS.ShowCartDetailInService(Cartid));
	}
	@RequestMapping(path="PayToOPay",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String PayToOPayInController(String OrderID,String Price) {			//歐付寶在這裡
		
		return BPTOLS.PayToOPayInService(OrderID,Price);
	}

}

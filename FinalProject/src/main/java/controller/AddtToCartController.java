package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.service.CartDetailService;
import model.service.CartService;
import model.service.ShowAllProductService;

@Controller
public class AddtToCartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private CartDetailService cartDetailService;
	@Autowired
	private ShowAllProductService showAll;

	@RequestMapping(path = "ShowtoAllProduct", produces = "text/html;charset=UTF-8")
	@ResponseBody			
	public String showAllProduct() {
		System.out.println("(ShowtoAllProduct)我進來做事了!");
		return new Gson().toJson(showAll.selectAll());
	}

	@RequestMapping(path = "AddtToCartController", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addtToCartController(String model,Integer CartId) {
		System.out.println("(AddtToCartController)我進來做事了!");
//		boolean isdup = cartService.checkMember(2);
		// cartService.checkMember(memberid);
		if (CartId == null) {
//			cartService.insert(model);
			return "請重新登入";
		} else {
			
			//cartService.insertmodelfromProduct(model);

			
			cartService.insert(model, CartId);
			}
//			else {
//				
//			}
			
//			CartBean cartbean = cartService.selectByMemberId(2);
//			cartbean = cartService.selectByMemberId(memberid);
			
//			System.out.println("cartbean" + cartbean);
//			System.out.println("cartId" + cartbean.getCartid());
			
//			CartDetailBean cartDetailBean = new CartDetailBean();
//			cartDetailBean.setCartid(CartId);
		
//			cartService.insert(model);
//			cartDetailBean.setCartid(cartId);
			
        	return "insert success(更新cart detail)";
		//	return new Gson().toJson(cartDetailService.selectById(model,CartId));
		//	return new Gson().toJson(cartDetailService.selectCartId(CartId));
		}
	

	@RequestMapping(path = "ShowToCart", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showCart() {
		System.out.println("(ShowtoCart)我進來做事了!");
		// cartService.getMemberId();
		// return new Gson().toJson(cartDetailService.selectAll());
		// CartBean result = cartService.insert(bean);
//		cartService.getMemberId();
		// int id = cartService.getMemberId();
		//List<CartDetailBean> result = cartDetailService.selectbycartId(27);
		return new Gson().toJson(cartDetailService.selectbycartId(3));
		//return new Gson().toJson(cartDetailService.selectAll());
		// return new Gson().toJson(cartDetailService.selectById(id));

	}

	@RequestMapping(path = "updatCartAmount", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatCartAmount(CartDetailBean bean) {
		System.out.println("(updatCartAmount)我進來做事了!");
		bean.getAmount();
		cartDetailService.update(bean);
		return "update success";
	}
	
	
	@RequestMapping(path = "CheckAmount", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updatCartAmount(String Model) {
		Integer Number =cartService.CheckAmount(Model);
		if(Number>0){
			return "成功加入購物車";
		}
		else {
			return "商品現在缺貨，到貨會馬上通知您";
		}
		
		
	}


}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.CartDetailBean;
import model.service.CartDetailService;
import model.service.CartService;
import model.service.ShowAllProductService;

@Controller
public class AddtToCartController {
	
	@Autowired
	private CartService  cartService;
	@Autowired
	private CartDetailService cartDetailService;
	@Autowired
	private ShowAllProductService showAll;
	
	@RequestMapping(path="AddtToCartController",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String method(CartDetailBean bean) {
//		System.out.println("我進來做事了!");
		//cartService.getMemberId();
//	 return new Gson().toJson(cartDetailService.selectAll());
		List<CartDetailBean> result = (List<CartDetailBean>) cartDetailService.insert(bean);
	 return new Gson().toJson(showAll.selectAll());
		
	}
	
	

}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import allPay.payment.integration.domain.AioCheckOutOneTime;
import model.bean.CartDetailBean;
import model.bean.MemberBean;
import model.service.CartDetailService;
import model.service.CartService;
import model.service.ShowAllProductService;
import model.service.login.LoginService;

@Controller
public class ShowCarDetailController {
	@Autowired
	private CartService  cartService;
	@Autowired
	private CartDetailService cartDetailService;
	@Autowired
	private ShowAllProductService showAll;
	@Autowired
	private LoginService  loginService;
	
	
	@RequestMapping(path="ShowCarDetailController",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String method(CartDetailBean bean) {
		//List<CartDetailBean> result = cartDetailService.selectAll();
		List<CartDetailBean> result = cartDetailService.selectbycartId(27);
		
		return null;
		
	}
	
	@RequestMapping(path="GetMemberData",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String GetMemberData(String email) {
		//System.out.println();
		System.out.println(email);
		MemberBean  memberBean = loginService.checkEmail(email);
		return new Gson().toJson(memberBean);
		
	}
}

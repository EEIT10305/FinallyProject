package controller.queryorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.OrderDetailBean;
import model.bean.OrderListBean;
import model.service.OrderDetailService;
import model.service.OrderListService;
import model.service.login.LoginService;

@Controller
public class OrderQueryController {
	
	@Autowired
	OrderListService orderListService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
/*========================處理"會員"查詢自己的訂單======================*/	
	@RequestMapping(path = "processMemberQueryorderlist", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String processMemberQueryOrder(String email) {
		//接收資料
		System.out.println("進入會員查詢訂單的controller");
		System.out.println("接收前端資料mail=>"+email);
		System.out.println("根據前端傳回的email查不查得到會員id=>"+loginService.checkEmail(email).getMemberid());
		
		List<OrderListBean> membeOrderList = orderListService.selectMemberAllOrderListByMemberId(loginService.checkEmail(email).getMemberid());
		System.out.println("是否有撈到會員的訂單資料"+membeOrderList);
		
		System.out.println("查詢到的List資料 轉json的格式長什麼樣子???");
		System.out.println(new Gson().toJson(membeOrderList));
		return new Gson().toJson(membeOrderList);
	}
/*========================處理"會員"點選查詢自己訂單的細項======================*/	
	@RequestMapping(path = "processMemberClickOrderDetail", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String processMemberClickOrderDetail(Integer orderId) {
		System.out.println("這裡是處理===會員===查看訂單明細的controller");
		System.out.println("前端傳回的訂單編號:"+orderId);
		int i = 0;
		 List<OrderDetailBean> queryOrderDetailList = orderDetailService.selectAllByOrderId(orderId);
		for(OrderDetailBean temp:queryOrderDetailList) {
			System.out.println("查詢到的會員訂單第"+i+"筆=>"+temp);
			i++;
		}
		System.out.println("查詢到的List資料 轉json的格式長什麼樣子???");
		System.out.println(new Gson().toJson(queryOrderDetailList));
		return new Gson().toJson(queryOrderDetailList);
	}
	
	
/*========================處理"GM"查詢所有會員的訂單======================*/	
	@RequestMapping(path = "processGMQueryorderlist", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String gmProcessMemberOrderListQuery(String dateStart, String dateEnd, String statu) {
		System.out.println("進入===管理員===查詢訂單的controller");
		System.out.println("接收前端的資料dateStart=>"+dateStart+"接收前端的資料dateEnd=>"+dateEnd+"接收前端的資料statu=>"+statu);
		int i = 0;
		try {
			List<OrderListBean> gmQueryOrderList = orderListService.selectAllMemberOrderListByDateStatu(dateStart, dateEnd, statu);
			for(OrderListBean orderbean:gmQueryOrderList) {
				i++;
				String name = loginService.selectById(orderbean.getMemberid()).getmembername();
				System.out.println("查詢到的會員訂單第"+i+"筆=>"+orderbean);
			}
			System.out.println("查詢到的List資料 轉json的格式長什麼樣子???");
			System.out.println(new Gson().toJson(gmQueryOrderList));
			return new Gson().toJson(gmQueryOrderList);
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
	}
	
/*========================處理"GM"點選查看細項======================*/	
	@RequestMapping(path = "processGMClickOrderDetail", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String processGMClickOrderDetail(Integer orderId) {
		System.out.println("這裡是處理GM查看訂單明細的controller");
		System.out.println("前端傳回的訂單編號:"+orderId);
		int i = 0;
		 List<OrderDetailBean> queryOrderDetailList = orderDetailService.selectAllByOrderId(orderId);
		for(OrderDetailBean temp:queryOrderDetailList) {
			System.out.println("查詢到的會員訂單第"+i+"筆=>"+temp);
			i++;
		}
		System.out.println("查詢到的List資料 轉json的格式長什麼樣子???");
		System.out.println(new Gson().toJson(queryOrderDetailList));
		return new Gson().toJson(queryOrderDetailList);
	}
	
}

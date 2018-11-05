package controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.HotService;

@Controller
public class HotController {
	@Autowired
	private HotService hotService;
	
	@RequestMapping(path="HotController",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method() {
		return new Gson().toJson(hotService.getNeedProduct());	
	}
	@RequestMapping(path="HotController2",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method2() {
		return new Gson().toJson(hotService.getNeedProduct2());	
	}
	@RequestMapping(path="ChangeHotController",produces="text/html;charset=utf-8")
	@ResponseBody
	public void method3(String str,String change,String amount) {
		System.out.println("hotService.changeProductSeq:" + hotService.changeProductSeq(str, change, amount));
	}

	@RequestMapping(path="GetUpProduct",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method3() {
		System.out.println("hotService.getUpProduct():" + hotService.getUpProduct());
		return new Gson().toJson(hotService.getUpProduct());	
	}
	
	@RequestMapping(path="AddProduct",produces="text/html;charset=utf-8")
	@ResponseBody
	public void method4(String addid) {
		System.out.println("hotService.addUpProductOne():" + hotService.addUpProductOne(addid));	
	}
	
	@RequestMapping(path="RemoveProduct",produces="text/html;charset=utf-8")
	@ResponseBody
	public void method5(String removepro) {
		System.out.println("hotService.addUpProductOne():" + hotService.removeProductOne(removepro));	
	}
}

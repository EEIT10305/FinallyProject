package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.login.LoginService;

@Controller
public class BingYiTest_GmQueryMemberManageController {
	@Autowired
	LoginService loginService; 
	
	@RequestMapping(path = "processGMQueryMemberManage", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String processGMQueryMemberManage() {
		System.out.println("這裡是GM要管理會員的controller");
		loginService.selectAll();
		System.out.println("查詢到的會員資料轉乘json:::::::");
		System.out.println(new Gson().toJson(loginService.selectAll()));
		return new Gson().toJson(loginService.selectAll());
	}
	
	
	
	
	
	
	
	
	
	
	
}

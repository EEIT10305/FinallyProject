package controller.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.MemberBean;
import model.service.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
@RequestMapping(path="processlogin",produces="text/html;charset=utf-8")
@ResponseBody
public String processLogin(String email, String password) {
	System.out.println("email有沒有抓到"+email);
	System.out.println("password有沒有抓到"+password);
	// 接收資料
	// 裝錯誤訊息
	Map<String, String> errors = new HashMap<String, String>();
	
	// 驗證資料

	if (email == null || email.length() == 0) {//判斷email是否為空
//		errors.put("username", "email不能為空");
		return "您的email不能空白"; 
		
	}
	if (password == null || password.length() == 0) {//判斷password是否為空
//		errors.put("password", "密碼不能為空");
		return "您的email不能空白"; 
	}
	if (errors != null && !errors.isEmpty()) {//判斷裝錯誤訊息的map物件 不是空的就代表有錯誤 導回指定頁面
		return "您的email以及密碼不能空白"; 
	}
	
	//呼叫model_service
	 MemberBean bean = loginService.checkEmailPwd(email, password);
	// 根據model執行結果，導向view
		if (bean == null) {
			errors.put("password", "Login failed, please try again by MVC.");
			return "找不到您的資料!請註冊";
			//return "login.errors";//forward 用InternalResourceView
		} else {
			return bean.getEmail().split("@")[0];
			//return "login.success"; //sendRedirect 用 RedirectView
		}
}
}

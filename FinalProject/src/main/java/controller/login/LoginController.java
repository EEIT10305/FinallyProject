package controller.login;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.MemberBean;
import model.service.login.LoginService;
import model.service.register.impl.RegisterServiceImpl;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RegisterServiceImpl registerService;
@RequestMapping(path="processlogin",produces="text/html;charset=utf-8")
@ResponseBody
public String processLogin(String email, String password) {
	// 接收資料
	System.out.println("email:");
	System.out.println(email);
	System.out.println("password");
	System.out.println(password);
	
	// 驗證資料
	if (email == null || email.length() == 0 || email.equals("")) {//判斷email是否為空
		return "email"; 
	}
	
	if (password == null || password.length() == 0 || password.equals("")) {//判斷password是否為空
		return "password"; 
	}
	
	//呼叫model_service
	
	 MemberBean bean = loginService.checkEmailPwd(email, password);
	// 根據model執行結果，導向view
		if (bean == null) {//找不到會員資料~請註冊
			return "notFoundData";
			//return "login.errors";//forward 用InternalResourceView
		} else {//找到會員資料 將會員email傳回前端
//			Cookie cookieToBrower = new Cookie("email",bean.getEmail());
//			cookieToBrower.setMaxAge(30*24*60*60);
//			return bean.getEmail().split("@")[0];
			return bean.getEmail();
			//return "login.success"; //sendRedirect 用 RedirectView
		}
}
//------------facebook----------------------------
@RequestMapping(value = "/processFacebookLogin")
@ResponseBody
public String getUserInfo(String userInfo) {
//接收資料
	System.out.println("臉書登入!有沒有進來做事情啊");
	System.out.println(userInfo);//{"name":"陳秉毅","first_name":"秉毅","last_name":"陳","email":"gn01046294@hotmail.com","id":"2039588499396795"}
//資料轉換
	JSONObject j = new JSONObject(userInfo);
	System.out.println("email抓不抓得到"+j.get("email"));//gn01046294@hotmail.com
//驗證資料
	String userFBLonin = (String) j.get("email");
	System.out.println("臉書的email轉成stringQQ : " +userFBLonin);
	if(loginService.checkEmailPwd(userFBLonin, "guestLoginByFacebook")!=null) {
		System.out.println("有沒有近來判斷這個fb已經註冊了");
		return new Gson().toJson(userFBLonin);
		
	}else {
	MemberBean bean = new MemberBean();
	bean.setEmail(j.get("email").toString());
	bean.setName(j.get("name").toString());
	bean.setPassword("facebook");
	bean.setPermission("normal");
	bean.setAddress("facebook");
	bean.setPhone("facebook");
	bean.setGender("facebook");
	
	registerService.saveMember(bean);	
	System.out.println("有沒有新增一個fb的bean_" + bean);
	return userFBLonin;
}
}
//-----------------google----------------------
@RequestMapping(path="processGoogleLogin",produces="text/html;charset=utf-8")
@ResponseBody
public String getGoogleInfo(String email, String name) {
	System.out.println(email);
	System.out.println(name);
	MemberBean bean = new MemberBean();
	bean.setEmail(email);
	bean.setName(name);
	bean.setPassword("google");
	bean.setPermission("normal");
	bean.setAddress("google");
	bean.setPhone("google");
	bean.setGender("google");
	
	System.out.println(bean);
	registerService.saveMember(bean);
	return email;
}



}

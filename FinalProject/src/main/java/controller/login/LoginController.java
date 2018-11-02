package controller.login;

import javax.servlet.http.Cookie;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
@RequestMapping(path="processlogin",produces="text/html;charset=utf-8", method=RequestMethod.POST)
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
		}else if (bean.getPermission()=="gm"&&bean.getPermission().equals("gm")) {
			System.out.println("是否能抓到權限是gm呢?? : "+bean.getPermission());
			return bean.getPermission();
		}
		else {//找到會員資料 將會員email傳回前端
			//將會員email存入cookie
			System.out.println("網站會員正常登入");

			return bean.getEmail();
		}
}


@RequestMapping(path="processFirstUser",produces="text/html;charset=utf-8", method=RequestMethod.POST)
@ResponseBody
public String isUserOurs(String email) {
	System.out.println("網頁一進入的時候有沒有跑到這隻servlet");
	System.out.println(email);
	
	MemberBean bean = loginService.checkEmail(email);
	if(bean==null) {
		return "notFoundMemberInfo";
	}else if (bean.getPermission()=="facebook"||"facebook".equals(bean.getPermission())) {
		return "facebook";
	}else if (bean.getPermission()=="google"||"google".equals(bean.getPermission())) {
		return "google";
	}else {
	return "userIsOurMember";
	}
}

//------------判斷是否是管理員登入----------------------
 
//------------facebook----------------------------

@RequestMapping(value = "/processFacebookLogin", method=RequestMethod.POST)
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
	if(loginService.checkEmailPwd(userFBLonin, "facebook")!=null) {
		System.out.println("判斷此facebook已經註冊過");
//		return new Gson().toJson(userFBLonin);
		return "userFBLonin"; 
	}else {
		System.out.println("此facebook尚未!!!還沒!!!註冊過");
	MemberBean bean = new MemberBean();
	bean.setEmail(j.get("email").toString());
	bean.setName(j.get("name").toString());
	bean.setPassword("facebook");
	bean.setPermission("facebook");
	bean.setAddress("facebook");
	bean.setPhone("facebook");
	bean.setGender("facebook");
	registerService.saveMember(bean);	
	System.out.println("有沒有新增一個fb的bean_" + bean);
	return userFBLonin;
}
}
//-----------------google----------------------

@RequestMapping(path="processGoogleLogin",produces="text/html;charset=utf-8", method=RequestMethod.POST)
@ResponseBody
public String getGoogleInfo(String email, String name) {
	System.out.println(email);
	System.out.println(name);
	if(loginService.checkEmailPwd(email, "google")!=null) {
		System.out.println("有沒有近來判斷這個google已經註冊了");
		return email;
		
	}else {
	
	MemberBean bean = new MemberBean();
	bean.setEmail(email);
	bean.setName(name);
	bean.setPassword("google");
	bean.setPermission("google");
	bean.setAddress("google");
	bean.setPhone("google");
	bean.setGender("google");
	
	System.out.println(bean);
	registerService.saveMember(bean);

	return email;
	}
	}



}

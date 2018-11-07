package controller.register;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.MemberBean;
import model.service.register.RegisterService;

@Controller
public class RegisterController {

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(path="processregister",produces="text/html;charset=utf-8")// 接收資料
	@ResponseBody
	public String processUserRegister(String name, String email, String password, String permission, String address, String phone, String gender){
		//接收資料
//		System.out.println(name);
//		
//		System.out.println(email);
//		System.out.println("經過格式轉換後的:"+replaceSpecialCharater(email));
//		
//		System.out.println(password);
//		System.out.println("經過格式轉換後的:"+replaceSpecialCharater(password));
//		
//		System.out.println(permission);
//		System.out.println(address);
//		System.out.println(phone);
//		System.out.println(gender);
		
		MemberBean memberBean = new MemberBean();
		if(name==null||name.length()==0||name.equals("")) {
			return "name";
		}else {
			memberBean.setName(replaceSpecialCharater(name));
		}
		
		if(email==null||email.length()==0||email.equals("")) {
			return "email";
		}else {
			memberBean.setEmail(replaceSpecialCharater(email));
		}
		
		if(password==null||password.length()==0||password.equals("")) {
			return "password";
		}else if(password != null && password.length() != 0 && !password.equals("")) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);
			if(matcher.matches()) {
				memberBean.setPassword(replaceSpecialCharater(password));
			}else {
				return "password";
			}
		}
		
		memberBean.setPermission(permission);
		
		if(address==null||address.length()==0||address.equals("")) {
			return "address";
		}else {
			memberBean.setAddress(replaceSpecialCharater(address));
		}
		if(phone==null||phone.length()==0||phone.equals("")) {
			return "phone";
		}else {
			memberBean.setPhone(replaceSpecialCharater(phone));
		}
		if(gender==null||gender.length()==0||gender.equals("")) {
			return "gender";
		}else {
			memberBean.setGender(gender);
		}
		
		System.out.println(memberBean);
		//驗證資料
		//根據model執行結果，導向view
		if(registerService.userExists(email)!=null) {
			return "emailused";
		}else {
			registerService.saveMember(memberBean);
			return email;
		}
		
	}
	
	private String replaceSpecialCharater(String value) {
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		return value;
	}
}

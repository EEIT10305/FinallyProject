package controller.register;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.MemberBean;
import model.service.register.impl.RegisterServiceImpl;

@Controller
public class RegisterController {

	@Autowired
	private RegisterServiceImpl registerService;
	
	@RequestMapping(path="processregister",produces="text/html;charset=utf-8")// 接收資料
	@ResponseBody
	public String processUserRegister(String name, String email, String password, String permission, String address, String phone, String gender){
		MemberBean  mb =null; 
		System.out.println(666666);
		mb.setName(name);
		mb.setEmail(email);
		mb.setPassword(password);
		mb.setPermission(permission);
		mb.setAddress(address);
		mb.setPhone(phone);
		mb.setGender(gender);
		
		System.out.println(mb);
		Map<String, String> errors = new HashMap<String, String>();//裝錯誤訊息
//		model.addAttribute("errorMesgs", errors);
		
		// 驗證資料
		MemberBean userInputEmail = registerService.userExists(mb.getEmail());
		//根據model執行結果，導向view
		if(userInputEmail!=null) {
			errors.put("emailError", "抱歉!此email已有人註冊!!");
			return "同一頁面,錯誤訊息";
		}else {
			registerService.saveMember(mb);
			return "歡迎頁面";
		}
	}
}

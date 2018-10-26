package controller.register;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.MemberBean;
import model.service.register.impl.RegisterServiceImpl;

@Controller
@SessionAttributes(names = { "user" })
public class RegisterController {

	@Autowired
	private RegisterServiceImpl registerService;
	
	@RequestMapping("processregister")// 接收資料
	public String processUserRegister(String email, MemberBean mb, Model model){
		Map<String, String> errors = new HashMap<String, String>();//裝錯誤訊息
		model.addAttribute("errorMesgs", errors);
		
		// 驗證資料
		MemberBean userInputEmail = registerService.userExists(email);
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

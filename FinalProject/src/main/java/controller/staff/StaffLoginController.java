package controller.staff;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.StaffBean;
import model.service.staff.StaffService;

@Controller
@SessionAttributes(names= {"staffBean"})
public class StaffLoginController {

	@Autowired
	StaffService staffService;
	
	
	
	@RequestMapping("staffLoginController")
	public String processStaffLogin(String LoginEmail, String LoginPassword, Model model, HttpSession session) {
//接收資料
		System.out.println("前端傳回的資料有沒有接到");
		System.out.println(LoginEmail);
		System.out.println(LoginPassword);
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		model.addAttribute("errors", errors);
		
		if(LoginEmail==null||LoginEmail.length()==0) {
			errors.put("userIdError", "InputUserIdError");
		}
		if(LoginPassword==null||LoginPassword.length()==0) {
			errors.put("passwordError", "InputPasswordError");
		}
		if(errors !=null &&!errors.isEmpty()) {
			return "/Login.jsp";
		}
		
//呼叫model
		StaffBean staffBean = staffService.checkByUseridPwd(LoginEmail, LoginPassword);
		System.out.println("接收到的資料有無查詢到資料?"+staffBean);
		if(staffBean==null) {
			errors.put("loginError", "Login failed, please try again");
//根據model執行結果導向view
			return "/Login.jsp";
		}else {
			model.addAttribute("staffBean", staffBean);
			session.setAttribute("test", staffBean.getName());
//根據model執行結果導向view
			return "/Backstage_index.jsp";
		}

		
		
	}
	
	
	
	
	
	
	
	
}

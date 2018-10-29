package controller.login;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.MemberBean;
import model.service.register.impl.RegisterServiceImpl;

@Controller
public class TestFBLogin {

	@Autowired
	private RegisterServiceImpl registerService;
	
	@RequestMapping(value = "/TestFBLogin")
	@ResponseBody
	public String getUserInfo(String userInfo) {
		System.out.println(userInfo);

		JSONObject j = new JSONObject(userInfo);
		System.out.println("email抓不抓得到"+j.get("email"));
		MemberBean mb = new MemberBean();
		mb.setEmail(j.get("email").toString());
		registerService.saveMember(mb);		
		return userInfo;
	}
	
	
	
	
	
}

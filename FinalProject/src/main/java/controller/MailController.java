package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(path="MailController",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method(String who) {
		System.out.println("登入的仁兄:" + who);
		System.out.println("mailService.getMailForMe(who):" + mailService.getMailForMe(who));
		return new Gson().toJson(mailService.getMailForMe(who));	
	}
	@RequestMapping(path="ReadMail",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method2(String id) {
		return new Gson().toJson(mailService.readMail(id));	
	}
	@RequestMapping(path="MailAllController",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method3(String who) {
		return new Gson().toJson(mailService.readMailAll(who));	
	}
	
}

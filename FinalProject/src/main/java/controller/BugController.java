package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.BugService;
import model.service.Impl.BugServiceImpl;

@Controller
public class BugController {
	@Autowired
	private BugService bugService = new BugServiceImpl();
	
	@RequestMapping(path="ShowAllProduct",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method() {
		return new Gson().toJson(bugService.getAllModel());	
	}
	@RequestMapping(path="BugWebsite",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method2(String orgin ,String page) {
		System.out.println(bugService.getAllWebProduct(orgin ,page));
		return new Gson().toJson(bugService.getAllWebProduct(orgin ,page));
	}
	

}

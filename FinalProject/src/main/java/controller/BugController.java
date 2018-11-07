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
	
	@RequestMapping(path="ShowProductByCategory",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method(String category) {
		return new Gson().toJson(bugService.getSubTablePro(category));	
	}
	@RequestMapping(path="BugWebsiteCategory",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method2(String origin) {
		return new Gson().toJson(bugService.getWebProCategory(origin));
	}
	
	@RequestMapping(path="BugWebsite",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method3(String orgin ,String page) {
		System.out.println(orgin + "," + page);
		System.out.println(bugService.getAllWebProduct(orgin ,page));
		return new Gson().toJson(bugService.getAllWebProduct(orgin ,page));
	}
	
	

}

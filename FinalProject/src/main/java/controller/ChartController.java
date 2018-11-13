package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.BugService;
import model.service.ChartService;
import model.service.Impl.BugServiceImpl;

@Controller
public class ChartController {
	@Autowired
	private ChartService chartService ;
	
	@RequestMapping(path="ChartSelect",produces="text/html;charset=utf-8")
	@ResponseBody
	public String method(String start,String end) {
		System.out.println("meow");
		System.out.println(chartService.getSoldPro(start,end));
		return new Gson().toJson(chartService.getSoldPro(start,end));	
	}

}

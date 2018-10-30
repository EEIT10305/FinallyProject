package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.HotService;

@Controller
public class HotController {
	@Autowired
	private HotService hotService;
	
	@RequestMapping("HotController")
	@ResponseBody
	public String method() {
		return new Gson().toJson(hotService.getNeedProduct());	
	}
	@RequestMapping("HotController2")
	@ResponseBody
	public String method2() {
		return new Gson().toJson(hotService.getNeedProduct2());	
	}

}

package controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.SelectProductForCustomizedService;

@Controller
public class SelectProductForCustomizedController {
	@Autowired
	private SelectProductForCustomizedService SPFCS;
	
	@RequestMapping(path="SelectProductForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String method() {
//		JSONArray ja = new JSONArray(SPFCS.selectCpu()); SpringMVC無法用舊方法傳JSON
		return new Gson().toJson(SPFCS.selectCpu());
	}
	
}

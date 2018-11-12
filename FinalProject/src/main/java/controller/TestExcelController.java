package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.TestExcelService;
@Controller
public class TestExcelController {
	
	@Autowired
	private TestExcelService testExcelService;
	
	
	@RequestMapping(path="ShowExcel",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String ShowExcelInController(String yyyy,String MM,String dd,Integer d) {
		return new Gson().toJson(testExcelService.ShowExcelInService(yyyy,MM,dd,d));
	}
}


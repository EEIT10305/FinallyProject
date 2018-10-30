package controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.WallService;

@Controller
public class WallController {
	@Autowired
	private WallService wallService;
	
	@RequestMapping("WallController")
	@ResponseBody
	public String method() {
		return new Gson().toJson(wallService.getNeedPhoto());	
	}
	
	@RequestMapping("WallController2")
	@ResponseBody
	public String method2() {
		return new Gson().toJson(wallService.getNeedPhoto2());	
	}
	
	
	@RequestMapping("ChangePicController")
	@ResponseBody
	public void method3(String str,String change,String amount) {
		System.out.println("wallService.changePhotoSeq(str):" + wallService.changePhotoSeq(str,change,amount));
	}
	
	@RequestMapping("AddPhoto")
	@ResponseBody
	public void method4(String upload_file) {
		wallService.writeFileToProj(upload_file);
		wallService.insertPhotoSeq(upload_file);
	}
	
	@RequestMapping("RemovePhoto")
	@ResponseBody
	public void method5(String removesrc) {
		wallService.changePhotoSeq(removesrc);
	}

}

package controller.updatememberinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.MemberBean;
import model.service.updatememberinfo.UpdateMemberInfoService;

@Controller
public class UpdateMemberInfoController {
	
	@Autowired
	UpdateMemberInfoService updateService;
	
	@RequestMapping(path="processupdate",produces="text/html;charset=utf-8", method=RequestMethod.POST)
	@ResponseBody
	public String processUpdateMemberInfo(String email) {
		System.out.println("有沒有進來做事?????");
		System.out.println(email);
		
		MemberBean bean = updateService.selectMemberInfo("111@111");
	
		return new Gson().toJson(bean);
		
	}
	
	
	
	
	
	
	
	
	
	

}

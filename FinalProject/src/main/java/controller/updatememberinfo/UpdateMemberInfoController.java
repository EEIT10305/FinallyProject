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

	@RequestMapping(path = "showMemberInfo", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String processUpdateMemberInfo(String email) {
		System.out.println("這裡是會員點選修改會員資料 要秀出資訊的controller");
		System.out.println(email);

		MemberBean bean = updateService.selectMemberInfo(email);

		System.out.println("根據前端傳回的email查詢的會員資料");
		System.out.println(bean);
		System.out.println("查到資料後轉成json格式");
		System.out.println(new Gson().toJson(bean));

		return new Gson().toJson(bean);

	}

	@RequestMapping(path = "checkprocessupdate", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String UpdateMemberInfo(String email, String name, String gender, String phone, String address) {
		System.out.println("進入會員修改輸入資料的controller");
		MemberBean queryMemberInfo = updateService.selectMemberInfo(email);
		System.out.println(email);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(phone);
		System.out.println(address);
		if(name==null||name.length()==0||name.equals("")) {
			name = queryMemberInfo.getmembername();
		}
		if(phone==null||phone.length()==0||phone.equals("")) {
			phone = queryMemberInfo.getPhone();
		}
		if(address==null||address.length()==0||address.equals("")) {
			address = queryMemberInfo.getmemberaddress();
		}

		queryMemberInfo.setmembername(name);
		queryMemberInfo.setPhone(phone);
		queryMemberInfo.setmemberaddress(address);
		queryMemberInfo.setGender(gender);

		System.out.println(queryMemberInfo);
		if (updateService.updateMemberInfo(queryMemberInfo)) {
			return "updatesuccess";
		} else {
			return "updatefail";
		}
	}

}

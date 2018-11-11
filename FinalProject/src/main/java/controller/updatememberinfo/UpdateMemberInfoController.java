package controller.updatememberinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.MemberBean;
import model.service.login.LoginService;
import model.service.updatememberinfo.UpdateMemberInfoService;

@Controller
public class UpdateMemberInfoController {

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;
	
	@Autowired
	UpdateMemberInfoService updateService;
	
	@Autowired
	private LoginService loginService;
/*=============================================秀出該會員的資料=============================================*/
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

/*=============================================處理修改會員資料=============================================*/
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

/*=============================================修改會員密碼=============================================*/
	@RequestMapping(path = "processMemberUpdatePassword", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String processUpdateMemberPassword(String email, String oldPassword, String newPassword, String checkPassword) {
		//接收資料
		System.out.println("進入會員修改密碼的controller");
		System.out.println("接收前端傳來的資料::::");
		System.out.println("email=>"+email+";;;oldPassword=>"+oldPassword+";;;newPassword=>"+newPassword+";;;checkPassword=>"+checkPassword);
		//資料驗證
		MemberBean oldMemberData = loginService.checkEmailPwd(email, oldPassword);
		if(oldPassword==null||oldPassword.length()==0||oldPassword.equals("")) {
			System.out.println("舊密碼輸入為空");
			return "oldPasswordError";
		}else {
		if(oldMemberData==null) {
			System.out.println("舊密碼輸入錯誤 查無會員資料");
			return "oldPasswordInputError";
		  }
		}
		
		if(newPassword==null||newPassword.length()==0||newPassword.equals("")) {
			System.out.println("判斷新密碼輸入為空");
			return "newPasswordInputNull";
		}else {
			System.out.println("判斷新密碼輸入不是空的哦");
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(newPassword);
			if(!matcher.matches()) {
				System.out.println("判斷 新的密碼 和規定的格式不符合");
				return "newPasswordInputTypeError";
			}
		}
		if(newPassword==oldPassword||newPassword.equals(oldPassword)) {
			System.out.println("判斷 新的密碼 和舊密碼 一樣 !!");
			return "newEqualOld";
		}
		
		if(checkPassword==null||checkPassword.length()==0||checkPassword.equals("")) {
			System.out.println("確認密碼輸入為空");
			return "checkPasswordNull";
		}else {
			System.out.println("判斷  ==確認密碼==  輸入不是空的哦");
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(checkPassword);
			if(!matcher.matches()) {
				System.out.println("判斷    ==確認密碼== 和規定的格式不符合");
				return "checkPasswordTypeError";
			}
		}
		if( newPassword==checkPassword || newPassword.equals(checkPassword)) {
			oldMemberData.setmemberpassword(newPassword);
			updateService.updateMemberInfo(oldMemberData);
			System.out.println(oldMemberData);
			return "updatePasswordSuccess";
		}else {
			System.out.println("判斷新密碼 和 確認密碼不一樣 ");
			return "newAndCheckDifferent";
		}
	}
}

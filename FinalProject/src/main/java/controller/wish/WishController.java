package controller.wish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.MemberBean;
import model.bean.WishBean;
import model.service.login.LoginService;
import model.service.wish.WishService;

@Controller
public class WishController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	WishService wishService;
	
	@RequestMapping(path = "processMemberWish", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String processWish(String email, Integer proId/*,Xxxx ccCc*/) {
//接收資料
		System.out.println("點選愛心之後有沒有將值丟到controllerl：");
		System.out.println(proId);
//		System.out.println(ccCc);
//驗證資料
		MemberBean memberInfo = loginService.checkEmail(email);
		Integer memberId = memberInfo.getMemberid();
		
		WishBean aWishRow = wishService.selectByMemberIdProId(memberId, proId);
		WishBean newWishBean = new WishBean();
		
//		if("前端傳回的愛心狀態是紅色") {
//			if(aWishRow!=null) {//有願望清單 更改狀態
//				aWishRow.setTracked(1);
//				return "";//尚未確認需要回傳什麼
//			}else {//沒有願望清單 新增一筆
//				newWishBean.setMemberid(memberInfo.getMemberid());
//				newWishBean.setProid(proId);
//				newWishBean.setTracked(1);
//				return "";//尚未確認需要回傳什麼
//			}
//		}
//		if("前端傳回的愛心狀態是白色") {
//			aWishRow.setTracked(0);
//			return "";//尚未確認需要回傳什麼
//		}
//		return "";
//		if("前端傳回的狀態是貨到付款") {
//			if(aWishRow!=null) {//有願望清單 更改狀態
//				aWishRow.setTracked(2);
//				return "";//尚未確認需要回傳什麼
//			}else {//沒有願望清單 新增一筆
//				newWishBean.setMemberid(memberInfo.getMemberid());
//				newWishBean.setProid(proId);
//				newWishBean.setTracked(2);
//				return "";//尚未確認需要回傳什麼
//			}
//		}
		return "";
	}
	
	@RequestMapping(path = "processFirstMemberLoadWish", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String processFirstMemberLoadWish(String email, Integer proId) {
		
		MemberBean memberBean = loginService.checkEmail(email);
		
		 WishBean wishBean = wishService.selectByMemberIdProId(memberBean.getMemberid(), proId);
		
		return new Gson().toJson(wishBean);
	}
	
}

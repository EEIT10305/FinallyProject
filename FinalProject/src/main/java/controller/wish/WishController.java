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
	public String processWish(String email, Integer proId,Integer tracked) {
//接收資料
		System.out.println("點選愛心或是貨到通知的controllerl：");
		System.out.println(email);
		System.out.println(proId);
//		System.out.println(ccCc);
//驗證資料
		MemberBean memberInfo = loginService.checkEmail(email);
		System.out.println("查不查得到會員資料????"+memberInfo);
		Integer memberId = memberInfo.getMemberid();
		
		WishBean newWishBean = new WishBean();
		if(tracked==2) {
		try {
			WishBean aWishRow = wishService.selectByMemberIdProId(memberId, proId);
				System.out.println("使用者是點選貨到通知的按鈕");
				if(aWishRow!=null) {//有願望清單 更改狀態
					System.out.println("點選的商品已在願望清單 修改狀態");
					aWishRow.setTracked(2);
					wishService.update(aWishRow);
					return "";
				}
		}catch(Exception e) {
			System.out.println("點選的商品不在願望清單 新增一筆");
			newWishBean.setMemberid(memberInfo.getMemberid());
			newWishBean.setProid(proId);
			newWishBean.setTracked(2);
			wishService.insertAWishBean(newWishBean);
			return "";
		}
		}
		if(tracked==1) {
			try {
				WishBean aWishRow = wishService.selectByMemberIdProId(memberId, proId);
					System.out.println("使用者是點選貨到通知的按鈕");
					if(aWishRow!=null) {//有願望清單 更改狀態
						System.out.println("點選的商品已在願望清單 修改狀態");
						aWishRow.setTracked(1);
						wishService.update(aWishRow);
						return "";
					}
			}catch(Exception e) {
				System.out.println("點選的商品不在願望清單 新增一筆");
				newWishBean.setMemberid(memberInfo.getMemberid());
				newWishBean.setProid(proId);
				newWishBean.setTracked(1);
				wishService.insertAWishBean(newWishBean);
				return "";
			}
		}
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
//		if(tracked==2) {
//			System.out.println("使用者是點選貨到通知的按鈕");
//			if(aWishRow!=null) {//有願望清單 更改狀態
//				System.out.println("點選的商品已在願望清單 修改狀態");
//				aWishRow.setTracked(2);
//				wishService.update(aWishRow);
//				return "";
//			}else {//沒有願望清單 新增一筆
//				System.out.println("點選的商品不在願望清單 新增一筆");
//				newWishBean.setMemberid(memberInfo.getMemberid());
//				newWishBean.setProid(proId);
//				newWishBean.setTracked(2);
//				wishService.insertAWishBean(newWishBean);
//				return "";
//			}
//		}
		return "";
	}
	
	@RequestMapping(path = "processFirstMemberLoadWish", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String processFirstMemberLoadWish(String email, Integer proId) {
		System.out.println("從資料庫撈會員的願望清單controller");
		System.out.println("有沒有接收到會員的Email??=> " + email);
		System.out.println("有沒有接收到user點選的商品id??=> " + proId);
		MemberBean memberBean = loginService.checkEmail(email);
		System.out.println("透過email有沒有撈取到會員資料" +memberBean);
		
	
			WishBean wishBean;
			try {//會員有願望清單資料
				wishBean = wishService.selectByMemberIdProId(memberBean.getMemberid(), proId);
				System.out.println(wishBean);
				return new Gson().toJson(wishBean);
			} catch (Exception e) {//會員沒有願望清單資料
				return "nowish";
			}
	
	}
	
}

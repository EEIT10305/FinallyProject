package controller.login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.CartBean;
import model.bean.MemberBean;
import model.service.CartService;
import model.service.login.LoginService;

@Controller
public class TestLogin {

	@Autowired
	private LoginService loginService;

	@Autowired
	private CartService cartService;

	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");

	// ---------------------------------------------------一進入網站判斷登入者的登入方式--------------------------------------
	@RequestMapping(path = "testlogin", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String isUserOurs(String email) {

		String strDate = sdFormat.format(new Date());// 建立進入這隻controller的時間

		System.out.println("使用者一進入網站判斷登入方式的controller     前端傳回的資料:::=>" + email);

		List<MemberBean> memberBeanList = loginService.checkEamilList(email);

		if (memberBeanList == null || memberBeanList.size() == 0 || memberBeanList.isEmpty()) {

			return "notFoundMemberInfo";

		} else {

			for (MemberBean bean : memberBeanList) {

				if (bean.getPermission() == "gm" || "gm".equals(bean.getPermission())) {

					return "gmLogin";

				} else if (bean.getPermission() == "normal" || "normal".equals(bean.getPermission())) {
					// 如果判斷是fb登入 就新增一個cart的id給他
					System.out.println("一般會員登入");
					Integer memberid = bean.getMemberid();// 取出會員的id
					System.out.println("會員的id=" + memberid);
					// 將此會員的資料寫進cartBean內
					List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
					List<String> addMemberStatus = new ArrayList<String>();
					System.out.println("用會員id查詢的cartBean有沒有資料??" + cmb);
					CartBean cartBean = new CartBean();// 建立一個新的cartBean後面用來新增
					if (cmb == null || cmb.isEmpty() || cmb.size() == 0) {// 如果登入的會員沒有cartId 就新增一個給他
						System.out.println("此會員的cartBean沒有資料 新增資料");
						cartBean.setMemberid(memberid);
						cartBean.setDate(strDate);
						cartBean.setStatus("nopay");// 狀態設定為尚未付款
						cartService.saveCartBean(cartBean);
					}
					for (CartBean oneMemberCartRow : cmb) {
						addMemberStatus.add(oneMemberCartRow.getStatus());
					}
					if (addMemberStatus.contains("pay") && !addMemberStatus.contains("nopay")) {
						cartBean.setMemberid(memberid);
						cartBean.setDate(strDate);
						cartBean.setStatus("nopay");
						cartService.saveCartBean(cartBean);
					}
//					if (addMemberStatus.contains("nopay")) {
//					}
					return new Gson().toJson(bean);
				}

				else if (bean.getPermission() == "facebook" || "facebook".equals(bean.getPermission())) {
					// 如果判斷是fb登入 就新增一個cart的id給他
					System.out.println("facebook登入");
					Integer memberid = bean.getMemberid();// 取出會員的id
					System.out.println("會員的id=" + memberid);
					// 將此會員的資料寫進cartBean內
					List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
					List<String> addMemberStatus = new ArrayList<String>();
					System.out.println("用會員id查詢的cartBean有沒有資料??" + cmb);
					CartBean cartBean = new CartBean();// 建立一個新的cartBean後面用來新增
					if (cmb == null || cmb.isEmpty() || cmb.size() == 0) {// 如果登入的會員沒有cartId 就新增一個給他
						System.out.println("此會員的cartBean沒有資料 新增資料");
						cartBean.setMemberid(memberid);
						cartBean.setDate(strDate);
						cartBean.setStatus("nopay");// 狀態設定為尚未付款
						cartService.saveCartBean(cartBean);
					}
					for (CartBean oneMemberCartRow : cmb) {
						addMemberStatus.add(oneMemberCartRow.getStatus());
					}
					if (addMemberStatus.contains("pay") && !addMemberStatus.contains("nopay")) {
						cartBean.setMemberid(memberid);
						cartBean.setDate(strDate);
						cartBean.setStatus("nopay");
						cartService.saveCartBean(cartBean);
					}
//					if (addMemberStatus.contains("nopay")) {
//					}
					return new Gson().toJson(bean);
				}

				else if (bean.getPermission() == "google" || "google".equals(bean.getPermission())) {
					// 如果判斷是google登入 就新增一個cart的id給他
					System.out.println("google登入");

					System.out.println("google登入");
					Integer memberid = bean.getMemberid();// 取出會員的id
					System.out.println("會員的id=" + memberid);
					// 將此會員的資料寫進cartBean內
					List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
					List<String> addMemberStatus = new ArrayList<String>();
					System.out.println("用會員id查詢的cartBean有沒有資料??" + cmb);
					CartBean cartBean = new CartBean();// 建立一個新的cartBean後面用來新增
					if (cmb == null || cmb.isEmpty() || cmb.size() == 0) {// 如果登入的會員沒有cartId 就新增一個給他
						System.out.println("此會員的cartBean沒有資料 新增資料");
						cartBean.setMemberid(memberid);
						cartBean.setDate(strDate);
						cartBean.setStatus("nopay");// 狀態設定為尚未付款
						cartService.saveCartBean(cartBean);
					}
					for (CartBean oneMemberCartRow : cmb) {
						addMemberStatus.add(oneMemberCartRow.getStatus());
					}
					if (addMemberStatus.contains("pay") && !addMemberStatus.contains("nopay")) {
						cartBean.setMemberid(memberid);
						cartBean.setDate(strDate);
						cartBean.setStatus("nopay");
						cartService.saveCartBean(cartBean);
					}
//					if (addMemberStatus.contains("nopay")) {
//					}

					return new Gson().toJson(bean);
				} else {
					return new Gson().toJson(bean);
				}
			}
			return "notFoundMemberInfo";
		}

	}

}

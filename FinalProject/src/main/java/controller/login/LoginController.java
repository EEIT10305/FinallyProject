package controller.login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
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
import model.service.register.RegisterService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private CartService cartService;

	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
//--------------------------------------一般會員登入判斷-----------------------------------------------------------
	@RequestMapping(path = "processlogin", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String processLogin(String email, String password) {
		// 接收資料
		System.out.println("email:");
		System.out.println(email);
		System.out.println("password:");
		System.out.println(password);

		// 驗證資料
		if (email == null || email.length() == 0 || email.equals("")) {// 判斷email是否為空
			return "email";
		}

		if (password == null || password.length() == 0 || password.equals("")) {// 判斷password是否為空
			return "password";
		}

		// 呼叫model_service

		MemberBean bean = loginService.checkEmailPwd(email, password);
		System.out.println(bean);
		// 根據model執行結果，導向view
		if (bean == null) {// 找不到會員資料~請註冊
			return "notFoundData";
		} 
		
		else if (bean.getPermission() == "gm" && bean.getPermission().equals("gm")) {
			System.out.println("是否能抓到權限是gm呢?? : " + bean.getPermission());
			return "gmLogin";
		}
		
		else {// 找到會員資料 將會員email傳回前端
			Date date = new Date();//建立進入這隻controller的時間
			String strDate = sdFormat.format(date);//建立進入這隻controller的時間
			
			System.out.println("網站會員正常登入");
			
			Integer memberid = bean.getMemberid();//取出會員的id
			System.out.println("會員的id="+memberid);
			
			// 將此會員的資料寫進cartBean內
			List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
			List<String> addMemberStatus=new ArrayList<String>();
			System.out.println("用會員id查詢的cartBean有沒有資料??"+cmb);
			CartBean cartBean = new CartBean();//建立一個新的cartBean後面用來新增
			if (cmb == null||cmb.isEmpty()||cmb.size()==0) {// 如果登入的會員沒有cartId 就新增一個給他
				System.out.println("此會員的cartBean沒有資料 新增資料");
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");// 狀態設定為尚未付款
				cartService.saveCartBean(cartBean);
				
			}
			for(CartBean oneMemberCartRow:cmb) {
				addMemberStatus.add(oneMemberCartRow.getStatus());
			}
			if(addMemberStatus.contains("pay")&&!addMemberStatus.contains("nopay")) {
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");
				cartService.saveCartBean(cartBean);
			}
			if(addMemberStatus.contains("nopay")) {
			}
			
			return bean.getEmail();
		}
	}

//---------------------------------------------------一進入網站判斷登入者的登入方式--------------------------------------
	@RequestMapping(path = "processFirstUser", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String isUserOurs(String email) {
		
		Date date = new Date();//建立進入這隻controller的時間
		String strDate = sdFormat.format(date);//建立進入這隻controller的時間
		
		System.out.println("網頁一進入的時候有沒有跑到這隻servlet");
		System.out.println(email);

		MemberBean bean = loginService.checkEmail(email);
		System.out.println("網頁一進來的時候抓到的資料轉成json格式:"+new Gson().toJson(bean));
		
		if (bean == null) {
			
			return "notFoundMemberInfo";
		
		} 
		else if (bean.getPermission() == "gm" || "gm".equals(bean.getPermission())) {
		
			return "gmLogin";
			
		} 
		else if (bean.getPermission() == "facebook" || "facebook".equals(bean.getPermission())) {
			//如果判斷是fb登入 就新增一個cart的id給他
			System.out.println("facebook登入");
			Integer memberid = bean.getMemberid();//取出會員的id
			System.out.println("會員的id="+memberid);
			// 將此會員的資料寫進cartBean內
			List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
			List<String> addMemberStatus=new ArrayList<String>();
			System.out.println("用會員id查詢的cartBean有沒有資料??"+cmb);
			CartBean cartBean = new CartBean();//建立一個新的cartBean後面用來新增
			if (cmb == null||cmb.isEmpty()||cmb.size()==0) {// 如果登入的會員沒有cartId 就新增一個給他
				System.out.println("此會員的cartBean沒有資料 新增資料");
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");// 狀態設定為尚未付款
				cartService.saveCartBean(cartBean);
			}
			for(CartBean oneMemberCartRow:cmb) {
				addMemberStatus.add(oneMemberCartRow.getStatus());
			}
			if(addMemberStatus.contains("pay")&&!addMemberStatus.contains("nopay")) {
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");
				cartService.saveCartBean(cartBean);
			}
			if(addMemberStatus.contains("nopay")) {
			}
			
			return new Gson().toJson(bean);
			
		} 
		else if (bean.getPermission() == "google" || "google".equals(bean.getPermission())) {
			//如果判斷是google登入 就新增一個cart的id給他
			System.out.println("google登入");
			
			System.out.println("google登入");
			Integer memberid = bean.getMemberid();//取出會員的id
			System.out.println("會員的id="+memberid);
			// 將此會員的資料寫進cartBean內
			List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
			List<String> addMemberStatus=new ArrayList<String>();
			System.out.println("用會員id查詢的cartBean有沒有資料??"+cmb);
			CartBean cartBean = new CartBean();//建立一個新的cartBean後面用來新增
			if (cmb == null||cmb.isEmpty()||cmb.size()==0) {// 如果登入的會員沒有cartId 就新增一個給他
				System.out.println("此會員的cartBean沒有資料 新增資料");
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");// 狀態設定為尚未付款
				cartService.saveCartBean(cartBean);
			}
			for(CartBean oneMemberCartRow:cmb) {
				addMemberStatus.add(oneMemberCartRow.getStatus());
			}
			if(addMemberStatus.contains("pay")&&!addMemberStatus.contains("nopay")) {
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");
				cartService.saveCartBean(cartBean);
			}
			if(addMemberStatus.contains("nopay")) {
			}
			
			return new Gson().toJson(bean);
		} 
		else {
			
			
			
			
			
			
			
			
			
			return new Gson().toJson(bean);
		}
	}

//------------facebook----------------------------
	@RequestMapping(value = "processFacebookLogin")
	@ResponseBody
	public String getUserInfo(String userInfo) {
//接收資料
		System.out.println("進入臉書登入的controller");
		System.out.println("前端頁面送來的資料:");
		System.out.println(userInfo);// {"name":"陳秉毅","first_name":"秉毅","last_name":"陳","email":"gn01046294@hotmail.com","id":"2039588499396795"}
//資料轉換
		JSONObject j = new JSONObject(userInfo);
		System.out.println("email抓不抓得到" + j.get("email"));// gn01046294@hotmail.com
//驗證資料

		String userFBLonin = (String) j.get("email");
		System.out.println("臉書的email轉成stringQQ : " + userFBLonin);
		if (loginService.checkEmailPwd(userFBLonin, "facebook") != null) {
			System.out.println("判斷此facebook已經註冊過"+userFBLonin);
			//---------------------------------------------------------------------cartId處理
			MemberBean bean = loginService.checkEmailPwd(userFBLonin, "facebook");
			Date date = new Date();//建立進入這隻controller的時間
			String strDate = sdFormat.format(date);//建立進入這隻controller的時間
			System.out.println("網站會員正常登入");
			Integer memberid = bean.getMemberid();//取出會員的id
			System.out.println("會員的id="+memberid);
			// 將此會員的資料寫進cartBean內
			List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
			List<String> addMemberStatus=new ArrayList<String>();
			System.out.println("用會員id查詢的cartBean有沒有資料??"+cmb);
			CartBean cartBean = new CartBean();//建立一個新的cartBean後面用來新增
			if (cmb == null||cmb.isEmpty()||cmb.size()==0) {// 如果登入的會員沒有cartId 就新增一個給他
				System.out.println("此會員的cartBean沒有資料 新增資料");
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");// 狀態設定為尚未付款
				cartService.saveCartBean(cartBean);
			}
			for(CartBean oneMemberCartRow:cmb) {
				addMemberStatus.add(oneMemberCartRow.getStatus());
			}
			if(addMemberStatus.contains("pay")&&!addMemberStatus.contains("nopay")) {
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");
				cartService.saveCartBean(cartBean);
			}
			if(addMemberStatus.contains("nopay")) {
			}
			//---------------------------------------------------------------------cartId處理
			return userFBLonin;
		} else {
			System.out.println("此facebook尚未!!!還沒!!!註冊過");
			MemberBean bean = new MemberBean();
			bean.setEmail(j.get("email").toString());
			bean.setmembername(j.get("name").toString());
			bean.setmemberpassword("facebook");
			bean.setPermission("facebook");
			bean.setmemberaddress("facebook");
			bean.setPhone("facebook");
			bean.setGender("man");
			registerService.saveMember(bean);
			System.out.println("有沒有新增一個fb的bean_" + bean);
			
			return userFBLonin;
		}
	}

//-----------------google----------------------

	@RequestMapping(path = "processGoogleLogin", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String getGoogleInfo(String email, String name) {
		System.out.println(email);
		System.out.println(name);
		MemberBean googleLoginInfo = loginService.checkEmailPwd(email, "google");
		if (googleLoginInfo != null) {
			System.out.println("判斷這個google已經註冊了");
			//---------------------------------------------------------------------cartId處理
			Date date = new Date();//建立進入這隻controller的時間
			String strDate = sdFormat.format(date);//建立進入這隻controller的時間
			System.out.println("網站會員正常登入");
			Integer memberid = googleLoginInfo.getMemberid();//取出會員的id
			System.out.println("會員的id="+memberid);
			// 將此會員的資料寫進cartBean內
			List<CartBean> cmb = cartService.selectMemberIdList(memberid);// 以會員的id查詢會員的cartId
			List<String> addMemberStatus=new ArrayList<String>();
			System.out.println("用會員id查詢的cartBean有沒有資料??"+cmb);
			CartBean cartBean = new CartBean();//建立一個新的cartBean後面用來新增
			if (cmb == null||cmb.isEmpty()||cmb.size()==0) {// 如果登入的會員沒有cartId 就新增一個給他
				System.out.println("此會員的cartBean沒有資料 新增資料");
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");// 狀態設定為尚未付款
				cartService.saveCartBean(cartBean);
			}
			for(CartBean oneMemberCartRow:cmb) {
				addMemberStatus.add(oneMemberCartRow.getStatus());
			}
			if(addMemberStatus.contains("pay")&&!addMemberStatus.contains("nopay")) {
				cartBean.setMemberid(memberid);
				cartBean.setDate(strDate);
				cartBean.setStatus("nopay");
				cartService.saveCartBean(cartBean);
			}
			if(addMemberStatus.contains("nopay")) {
			}
			//---------------------------------------------------------------------cartId處理
			
			return email;
		} else {
			MemberBean bean = new MemberBean();
			bean.setEmail(email);
			bean.setmembername(name);
			bean.setmemberpassword("google");
			bean.setPermission("google");
			bean.setmemberaddress("google");
			bean.setPhone("google");
			bean.setGender("man");

			System.out.println(bean);
			registerService.saveMember(bean);

			return email;
		}
	}
/*------------------抓取cartId用(已確定是我們的會員且有mail了!)------------------------------------*/
	@RequestMapping(path = "catchMemberCartId", produces = "text/html;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public String catchCartId(String email) {

		System.out.println("有沒有抓到登入後的請求??????");
		System.out.println(email);
		
		MemberBean bean = loginService.checkEmail(email);
		System.out.println("有沒有抓到會員資料:");
		System.out.println(bean);
		System.out.println("有沒有抓到會員的id???："+bean.getMemberid());//8
		List<CartBean> cartBean=null;
		Map<String,Integer> memberInfo = new HashMap<String,Integer>();
		
		cartBean = cartService.selectMemberIdList(bean.getMemberid());
		System.out.println("會員的cartId"+cartBean);

		for(CartBean cartBeanList:cartBean) {
			memberInfo.put(cartBeanList.getStatus(), cartBeanList.getCartid());
		}
		System.out.println("有沒有抓到該會員的購物車id???"+memberInfo.get("nopay"));
		if(memberInfo.get("nopay")==null) {
			Date date = new Date();//建立進入這隻controller的時間
			String strDate = sdFormat.format(date);//建立進入這隻controller的時間
			CartBean newCartBean = new CartBean();
			newCartBean.setMemberid(bean.getMemberid());
			newCartBean.setDate(strDate);
			newCartBean.setStatus("nopay");
			cartService.saveCartBean(newCartBean);
			
			System.out.println(newCartBean);
			
			return newCartBean.getCartid().toString();
		}
		System.out.println("會員id轉成字串");
		System.out.println(memberInfo.get("nopay").toString());
		return memberInfo.get("nopay").toString();
	}
	
}

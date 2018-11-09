package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.PkService;

@Controller
public class PkController {
	@Autowired
	PkService pk;

	@RequestMapping(path="pkSelectAll", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String pkSelectAll() {
		System.out.println("=============================================================================");
        System.out.println("pkpkpkpkpkpkpkpkpkpkpkpkpkpkpk    CONTTROLLER");
		System.out.println("=============================================================================");
		return new Gson().toJson(pk.pkSelectAll());
	}
	
	@RequestMapping(path="showPinginDetail", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showPinginDetail(String pkNo) {
		System.out.println("=============================================================================");
        System.out.println("pkpkpkpkpkpkpkpkpkpkpkpkpkpkpk    CONTTROLLER    " + pkNo);
		System.out.println("=============================================================================");
		return new Gson().toJson(pk.showPinginDetail(pkNo));
	}
	
	@RequestMapping(path="updateCartDetailAmount", produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String updateCartDetailAmount(Integer cartid, Integer amount,Integer proid) {
		System.out.println("=============================================================================");
        System.out.println("idididididiiddiididid    " + cartid);
        System.out.println("amountamount    " + amount);        
        System.out.println("=============================================================================");
          pk.updateCartDetailAmount(cartid, amount,proid);
          return("修改數量成功");
	}
}

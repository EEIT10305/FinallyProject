package controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.service.ImportDetailService;
import model.service.ImportService;

@Controller
@SessionAttributes(names = { "user" })
public class ImportController {

	@Autowired
	private ImportService importService;

	
	@RequestMapping("/pages/search.controller")
	public String searchResult(ImportBean bean, String arrivedate, String orderdate, String statu, Integer improtid,
			Model model, WebRequest request) {
//
//		System.out.println("arrivedate1------------------" + arrivedate);
//		System.out.println("orderdate1-------------------" + orderdate);
//		System.out.println("statu------------------------" + statu);

		request.removeAttribute("detail", WebRequest.SCOPE_SESSION);	
		
		
		
		
//Converts arrivedate format from yyyy-mm-dd to yyyy/mm/dd
		if (arrivedate.contains("-")) {
			String Arrive = arrivedate;
			String[] ADparts = Arrive.split("-");
			String ADpart1 = ADparts[0];
			String ADpart2 = ADparts[1];
			String ADpart3 = ADparts[2];
			String AD = ADpart1 + "/" + ADpart2 + "/" + ADpart3;
			arrivedate = AD;
		}
//Converts orderdate format from yyyy-mm-dd to yyyy/mm/dd
		if (orderdate.contains("-")) {
			String Order = orderdate;
			String[] ODparts = Order.split("-");
			String ODpart1 = ODparts[0];
			String ODpart2 = ODparts[1];
			String ODpart3 = ODparts[2];
			String OD = ODpart1 + "/" + ODpart2 + "/" + ODpart3;
			orderdate = OD;
		}

//		if (arrivedate.length() > 0 & orderdate.length() == 0) {
//			List<ImportBean> result = importService.selectByArrivedate(arrivedate);
//			model.addAttribute("user", result);
//			System.out.println("SelectbyArrivedate===============================");
//		}
//
//		if (orderdate.length() > 0 & arrivedate.length() == 0) {
//			List<ImportBean> result = importService.selectByOrderdate(orderdate);
//			model.addAttribute("user", result);
//			System.out.println("SelectbyOrderdate================================");
//		}

		if (statu.length() > 0 & arrivedate.length() == 0 & orderdate.length() == 0) {
			List<ImportBean> result = importService.selectByStatus(statu);
			model.addAttribute("user", result);
			System.out.println("SelectbyStatus==================================");
		}

		if (arrivedate.length() > 0 & orderdate.length() > 0) {
			List<ImportBean> result = importService.selectByADODS(arrivedate, orderdate, statu);
			model.addAttribute("user", result);
			System.out.println("SelectbyADODS===================================");
		}

		if (statu.length() > 0 & arrivedate.length() > 0 & orderdate.length() == 0) {
			List<ImportBean> result = importService.selectByADS(arrivedate, statu);
			model.addAttribute("user", result);
			System.out.println("SelectbyADS====================================");
		}

		if (statu.length() > 0 & arrivedate.length() == 0 & orderdate.length() > 0) {
			List<ImportBean> result = importService.selectByODS(orderdate, statu);
			model.addAttribute("user", result);
			System.out.println("SelectbyODS===================================");
		}

//		System.out.println("arrivedate2++++++++++++++++" + arrivedate);
//		System.out.println("orderdate2+++++++++++++++++" + orderdate);
//		System.out.println("statu2+++++++++++++++++++++" + statu);
		
		return "/Backstage_Search_Import_Result.jsp";

	}

}

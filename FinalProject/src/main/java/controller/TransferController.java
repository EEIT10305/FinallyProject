package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.BranchStockBean;
import model.service.Branch_StockService;

@Controller
@SessionAttributes(names = {"transfer"})
public class TransferController {
	
	@Autowired
	Branch_StockService branchStockService;
	
	
	@RequestMapping("/pages/search.transfer.controller")
	public String searchResult(Model model) {
		
		System.out.println("1111111111111111111111111111");

		List<BranchStockBean> result = branchStockService.selectALL();
		model.addAttribute("transfer", result);
		
		System.out.println("2222222222222222222222222222");
		
		
		return "/Backstage_Transfer_Search_Result.jsp";
	}
	
	@RequestMapping("/pages/transfer.controller")
	public String transfer() {
		
		System.out.println("transfer controller=================================================");
		
		return "/Backstage_Transfer.jsp";
		
	}
	
	@RequestMapping("/pages/insert.transfer.controller")
	public String InsertTransfer(Integer branchidin, Integer proidin, Integer amountin, Integer branchidout, Model model) {
		 
		
		
		System.out.println("branchidin==================" + branchidin);
		
		
		branchStockService.updateBranchStock(branchidin, branchidout, amountin, proidin);
		
		branchStockService.insertTransfer(amountin, branchidin, branchidout, proidin);
		
		System.out.println("branchidout====================" + branchidout);
		
		model.addAttribute("transferRecord", null);
//		record insert into transfer

		
		return "/Backstage_Transfer.jsp";		
	}
	
	
	
	
	
	
}

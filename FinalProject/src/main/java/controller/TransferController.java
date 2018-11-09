package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.BranchStockBean;
import model.bean.BrandBean;
import model.bean.StaffBean;
import model.bean.TransferBean;
import model.service.Branch_StockService;

@Controller
@SessionAttributes(names = {"transfer"})
public class TransferController {
	
	@Autowired
	Branch_StockService branchStockService;
	
	
	@RequestMapping("/pages/search.transfer.controller")
	public String searchResult(Model model, String brand) {
		
		System.out.println("transfer search controller============================");

			List<BranchStockBean> result = branchStockService.selectALL();
			model.addAttribute("transfer", result);
				
		
		return "/Backstage_Transfer_Search_Result.jsp";
	}
	
	@RequestMapping("/pages/transfer.controller")
	public String transfer() {
		
		System.out.println("transfer controller=================================================");
		
	
		
		return "/Backstage_Transfer.jsp";
		
	}
	
	@RequestMapping("/pages/insert.transfer.controller")
	public String InsertTransfer(Integer branchidin, Integer proidin, Integer amountin, Integer branchidout, Model model, HttpSession session) {
		
		if(branchidin == null | proidin == null | amountin == null | branchidout == null) {
			return "/Backstage_Transfer.jsp";			
		}
			
		
		System.out.println("branchidin==================" + branchidin);
		
		
		branchStockService.updateBranchStock(branchidin, branchidout, amountin, proidin);
		
		branchStockService.insertTransfer(amountin, branchidin, branchidout, proidin, session);
		
		System.out.println("branchidout====================" + branchidout);
		
		List<TransferBean> result = branchStockService.selectAll();
		
		model.addAttribute("transferRecord", result);
		
		return "/Backstage_Transfer.jsp";		
	}
	
	
	
	
	
	
}

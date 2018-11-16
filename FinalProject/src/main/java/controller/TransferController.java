package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.BranchStockBean;
import model.bean.BrandBean;
import model.bean.ProductBean;
import model.bean.StaffBean;
import model.bean.TransferBean;
import model.service.Branch_StockService;

@Controller
@SessionAttributes(names = {"transfer"})
public class TransferController {
	
	@Autowired
	Branch_StockService branchStockService;
	
	
	@RequestMapping("/pages/search.transfer.controller")
	public String searchResult(Model model, String promodel) {
		System.out.println("promodel=======" + promodel);
			
		if(promodel==null || promodel.length()==0) {
				
			System.out.println("promodel is nulllllllllllll");
			
			List<BranchStockBean> result = branchStockService.selectALL();
			model.addAttribute("transfer", result);
			
		}
		else if (promodel!= null || promodel.length()!=0) {
			System.out.println("promodel is not nulllllllllllllll");
			 List<BranchStockBean> branch = branchStockService.selectByProModel(promodel);
			model.addAttribute("transfer", branch);
		}
		
		
		
		return "/Backstage_Transfer_Search_Result.jsp";
	}
	
	@RequestMapping("/pages/transfer.controller")
	public String transfer() {
		
//		verify data
		
		
		
		System.out.println("return========================================");
		return "/Backstage_Transfer.jsp";
		
	}
	
	@RequestMapping("/pages/insert.transfer.controller")
	public String InsertTransfer(Integer branchidin, Integer proidin, Integer amountin, Integer branchidout, Model model, HttpSession session) {
		System.out.println("shopname===" + branchidin);		
		if(branchidin == null | proidin == null | amountin == null | branchidout == null) {
			return "/Backstage_Transfer.jsp";
		}
		if(branchidin == branchidout) {
			return "/Backstage_Transfer.jsp";
		}
		
		branchStockService.updateBranchStock(branchidin, branchidout, amountin, proidin);
		
		branchStockService.insertTransfer(amountin, branchidin, branchidout, proidin, session);
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd 'at' HH:mm:ss");
		String Date = dateFormat.format(date);
		
		
		List<TransferBean> result = branchStockService.selectLatestRecord(Date);
	
		model.addAttribute("transferRecord", result);
		
		return "/Backstage_Transfer.jsp";		
	}
	
	
	
	
	
	
}

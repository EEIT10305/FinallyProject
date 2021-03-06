package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.bean.BranchStockBean;
import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.dao.BranchStockDAO;
import model.service.ImportDetailService;
import model.service.ImportService;


@Controller
@SessionAttributes(names = {"detail"})
public class ImportDetailController {
	
	@Autowired
	private ImportDetailService importDetailService;
	
	@Autowired
	private ImportService importService;
	
	@Autowired
	private BranchStockDAO branchStockDAO;

	@RequestMapping("/pages/detail.controller")
	public String showDetail(Integer improtid, Model model) {
		System.out.println("import id ========================" + improtid);
		
		List<ImportDetailBean> detailresult = importDetailService.selectAllByID(improtid);
		
		if(improtid!=0) {			
						
			model.addAttribute("detail", detailresult);
		}else {
			System.out.println("importid is nullllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
			return null;
		}
			
		
		return "/Backstage_Search_Import_Result.jsp";
	}
	


	@RequestMapping("/pages/import.updateController")

	public String update(ImportBean bean, Integer improtid, Integer proid, Model model, WebRequest request) {

//		System.out.println("importtttttttttttttttttttttttttttttttttttttttiiiiiiiiiiiiiiiid" + improtid);
		
		request.removeAttribute("user", WebRequest.SCOPE_SESSION);
		
		String statu = importService.selectByimprotid(improtid).getStatu();
		
		if("on".equals(statu)) {
			statu = "off";
			System.out.println("on================================" + statu);

		}
//		else if("off".equals(statu)) {
//			return "/Backstage_Search_Import_Result.jsp";
//			
//		}
		
	    importService.updateStatus(statu, improtid);
	    
		
		List<BranchStockBean> result = importService.insertBranchStock(improtid, proid);

		model.addAttribute("stock", result);

		return "/Backstage_Search_Import_Result.jsp";

	}

	
	
	
	
}

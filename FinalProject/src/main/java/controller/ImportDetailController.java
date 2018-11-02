package controller;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.service.ImportDetailService;
import model.service.ImportService;


@Controller
@SessionAttributes(names = {"detail"})
public class ImportDetailController {
	
	@Autowired
	private ImportDetailService importDetailService;
	
	@Autowired
	private ImportService importService;
	

	@RequestMapping("/pages/detail.controller")
	public String method(Integer improtid, Model model) {
		System.out.println("import id ========================" + improtid);
	
		List<ImportDetailBean> detailresult = importDetailService.selectAllByID(improtid);
		
		
		model.addAttribute("detail", detailresult);

		
		return "/Backstage_Detail.jsp";
	}
	


	@RequestMapping("/pages/import.updateController")
	public String update(ImportBean bean, String statu, Integer improtid, Model model) {
		System.out.println("importid++++++++++++++++++++" + improtid + improtid.getClass());
		System.out.println("update controller==========================" + statu);
		System.out.println(statu.getClass() + "---------------------------------");
		if(statu.contains("on")) {			
			String off = "off";
			statu = off;
			System.out.println("on================================" + statu);			
		}
		
		else if("off".equals(statu)) {
			String on = "on";
			statu = on;
			System.out.println("off===============================" + statu);
		}
		
		System.out.println("updating++++++++++++++++++++++++++++++++++++++" + statu);
//		List<ImportBean> result = 
				importService.updateStatus(statu, improtid);
//		model.addAttribute("success", result);
		System.out.println("Update controller============================ update success");
		
		
		
		return "/Backstage_Success.jsp";

	}

	
	
	
	
}

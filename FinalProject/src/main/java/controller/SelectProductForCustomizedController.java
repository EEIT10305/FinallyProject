package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.service.SelectProductForCustomizedService;

@Controller
public class SelectProductForCustomizedController {
	@Autowired
	private SelectProductForCustomizedService SPFCS;
	
	@RequestMapping(path="SelectMbForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectMb() {
		return new Gson().toJson(SPFCS.selectMb());
	}
	@RequestMapping(path="SelectCpuForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectCpu() {
//		JSONArray ja = new JSONArray(SPFCS.selectCpu()); SpringMVC無法用舊方法傳JSON	
		return new Gson().toJson(SPFCS.selectCpu());
	}
	@RequestMapping(path="selectRamForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectRam() {
		return new Gson().toJson(SPFCS.selectRam());
	}
	@RequestMapping(path="selectVgaForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectVga() {	
		return new Gson().toJson(SPFCS.selectVga());
	}
	@RequestMapping(path="selectStorageForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectStorage() {
		return new Gson().toJson(SPFCS.selectStorage());
	}
	@RequestMapping(path="selectCabinetForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectCabinet() {	
		return new Gson().toJson(SPFCS.selectCabinet());
	}
	@RequestMapping(path="selectPowerSupplierForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectPowerSupplier() {	
		return new Gson().toJson(SPFCS.selectPowerSupplier());
	}
	@RequestMapping(path="selectPinginForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectPingin() {	
		return new Gson().toJson(SPFCS.selectPingin());
	}
	@RequestMapping(path="checkRamForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkRamInController(String Mbmodel) {
		
		return new Gson().toJson(SPFCS.checkRamInService(Mbmodel));
	}
	@RequestMapping(path="checkCpuForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkCpuInController(String Mbmodel) {
		
		return new Gson().toJson(SPFCS.checkCpuInService(Mbmodel));
	}
	@RequestMapping(path="selectCategoryForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectCategoryInController() {
		
		return new Gson().toJson(SPFCS.selectCategoryInService());
	}
	@RequestMapping(path="selectBrandForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selectBrandInController(String Brandmodel) {
		
		return new Gson().toJson(SPFCS.selectBrandInService(Brandmodel));
	}
	@RequestMapping(path="showProductByCategoryForCustomized",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showProductByCategoryInController(String Categorymodel,String Brandmodel) {
		
		return new Gson().toJson(SPFCS.showProductByCategoryInService(Categorymodel,Brandmodel));
	}
	@RequestMapping(path="showProductByPrice",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showProductByPriceInController(String Categorymodel,String Brandmodel,Integer Pricemodel) {
		
		return new Gson().toJson(SPFCS.showProductByPriceInService(Categorymodel,Brandmodel,Pricemodel));
	}
	@RequestMapping(path="showPinginDetailByImage",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showPinginDetailInController(String Pinginmodel) {
		
		return new Gson().toJson(SPFCS.showPinginDetailInService(Pinginmodel));
	}
	
}

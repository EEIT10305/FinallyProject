package controller;

import javax.transaction.Transactional;

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
	@RequestMapping(path="showInitPrice",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showInitPriceInController(String model) {
		
		return new Gson().toJson(SPFCS.showInitPriceInService(model));
	}
	
	@RequestMapping(path="showAllProductImg",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showAllProductImgInController() {
		
		return new Gson().toJson(SPFCS.showAllProductImgInService());
	}
	@RequestMapping(path="showCpuPower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showCpuPowerInController(String Cpumodel) {
		
		return new Gson().toJson(SPFCS.showCpuPowerInService(Cpumodel));
	}
	@RequestMapping(path="showRamPower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showRamPowerInController(String Rammodel) {
		
		return new Gson().toJson(SPFCS.showRamPowerInService(Rammodel));
	}
	@RequestMapping(path="showMbPower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showMbPowerInController(String Mbmodel) {
		
		return new Gson().toJson(SPFCS.showMbPowerInService(Mbmodel));
	}
	@RequestMapping(path="showVgaPower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showVgaPowerInController(String Vgamodel) {
		
		return new Gson().toJson(SPFCS.showVgaPowerInService(Vgamodel));
	}
	@RequestMapping(path="showStoragePower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showStoragePowerInController(String Storagemodel) {
		
		return new Gson().toJson(SPFCS.showStoragePowerInService(Storagemodel));
	}
	@RequestMapping(path="showCabinetPower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showCabinetPowerInController(String Cabinetmodel) {
		
		return new Gson().toJson(SPFCS.showCabinetPowerInService(Cabinetmodel));
	}
	@RequestMapping(path="showPowerSupplierByTotalPower",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showPowerSupplierByTotalPowerInController(Integer PowerModel) {
		
		return new Gson().toJson(SPFCS.showPowerSupplierByTotalPowerInService(PowerModel));
	}
	@RequestMapping(path="showCartDetail",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showCartDetailInController(String model,Integer CartId) {
		return new Gson().toJson(SPFCS.showCartDetailInService(model,CartId));
	}
	
}

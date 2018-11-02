package model.service;

import java.util.List;
import java.util.Set;

import com.google.gson.JsonElement;

import model.bean.BrandBean;
import model.bean.CabinetBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.MbBean;
import model.bean.PinginBean;
import model.bean.PinginDetailBean;
import model.bean.PowerSupplierBean;
import model.bean.ProductBean;
import model.bean.RamBean;
import model.bean.StorageBean;
import model.bean.VgaBean;

public interface SelectProductForCustomizedService {

	List<CpuBean> selectCpu();

	List<MbBean> selectMb();

	List<RamBean> selectRam();

	List<VgaBean> selectVga();

	List<StorageBean> selectStorage();

	List<CabinetBean> selectCabinet();

	List<PowerSupplierBean> selectPowerSupplier();

	List<ProductBean> selectPingin();

	List<RamBean> checkRamInService(String Mbmodel);

	List<CpuBean> checkCpuInService(String Mbmodel);

	List<CategoryBean> selectCategoryInService();

	Set<BrandBean> selectBrandInService(String Category);
	
	List<PinginBean> showProductByCategoryInService(String Categorymodel, String Brandmodel);

	List<PinginBean> showProductByPriceInService(String categorymodel, String brandmodel, Integer pricemodel);

	List<PinginDetailBean> showPinginDetailInService(String Pinginmodel);

	ProductBean showInitPriceInService(String model);

	List<PinginBean> showAllProductImgInService();

	CpuBean showCpuPowerInService(String Cpumodel);

	RamBean showRamPowerInService(String Rammodel);

	MbBean showMbPowerInService(String Mbmodel);

	VgaBean showVgaPowerInService(String Vgamodel);

	StorageBean showStoragePowerInService(String Storagemodel);

	CabinetBean showCabinetPowerInService(String Cabinetmodel);


}
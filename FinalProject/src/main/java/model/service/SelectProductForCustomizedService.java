package model.service;

import java.util.List;
import java.util.Set;

import com.google.gson.JsonElement;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.PinginBean;
import model.bean.PinginDetailBean;
import model.bean.ProductBean;
import model.bean.RamBean;

public interface SelectProductForCustomizedService {

	List<ProductBean> selectCpu();

	List<ProductBean> selectMb();

	List<ProductBean> selectRam();

	List<ProductBean> selectVga();

	List<ProductBean> selectStorage();

	List<ProductBean> selectCabinet();

	List<ProductBean> selectPowerSupplier();

	List<ProductBean> selectPingin();

	List<RamBean> checkRamInService(String Mbmodel);

	List<CpuBean> checkCpuInService(String Mbmodel);

	List<CategoryBean> selectCategoryInService();

	Set<BrandBean> selectBrandInService(String Category);
	
	List<PinginBean> showProductByCategoryInService(String Categorymodel, String Brandmodel);

	List<PinginBean> showProductByPriceInService(String categorymodel, String brandmodel, Integer pricemodel);

	List<PinginDetailBean> showPinginDetailInService(String Pinginmodel);

}
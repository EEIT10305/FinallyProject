package model.dao;

import java.util.List;

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

public interface ProductDAO {
    List<ProductBean> selectAll();
    ProductBean selectById(int id);
    List<ProductBean> selectByCategory(int Categoryid);
    ProductBean insert(ProductBean bean);
    boolean update(ProductBean bean);
	List<ProductBean> selectNeedProduct();
	List<ProductBean> selectNeedProduct2();
	MbBean checkByMb(String Mbmodel);
	List<RamBean> checkRamByDDR(String DDR);
	List<CpuBean> checkCpuByFeet(String Feet);
	List<CategoryBean> selectAllCategory();
	CategoryBean CategoryTurnCategoryid(String Category);
	BrandBean BrandidTurnBrand(int Brandid);

	List<PinginDetailBean> showPinginByCategoryAndBrand(String Category, String Brand);
	PinginBean showPingin(String name);
	PinginBean showPinginByPrice(String name, Integer Price);
	List<PinginDetailBean> showPinginByImg(String Pinginname);

	boolean updateHotSeq(Integer count, Integer id);
	boolean updateNoHot(Integer id);
	List<ProductBean> selectUpProduct();
	List<ProductBean> selectProductExcludeDown();
	ProductBean selectProductPrice(String model);
	List<PinginBean> showAllProductImg();
	CpuBean showCpuPower(String Cpumodel);
	RamBean showRamPower(String Rammodel);
	MbBean showMbPower(String Mbmodel);
	VgaBean showVgaPower(String Vgamodel);
	StorageBean showStoragePower(String Storagemodel);
	CabinetBean showCabinetPower(String Cabinetmodel);
	List<PowerSupplierBean> selectPowerSupplier();
	List<CabinetBean> selectCabinet();
	List<StorageBean> selectStorage();
	List<VgaBean> selectVga();
	List<RamBean> selectRam();
	List<CpuBean> selectCpu();
	List<MbBean> selectMb();

}

package model.dao;

import java.util.List;
import java.util.Map;

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

    public List<ProductBean> selectByCategory(int Categoryid);
    public List<ProductBean> selectByinput(String input);

    ProductBean insert(ProductBean bean);

	List<ProductBean> selectByCatBraPri(Integer categoryid, Integer brandid, Integer price);
	List<ProductBean> selectByCatBraPriBigger(Integer categoryid, Integer brandid, Integer price);
	List<ProductBean> selectByCatBra(Integer categoryid, Integer brandid);
	List<ProductBean> selectByCatPri(Integer categoryid, Integer price);
	List<ProductBean> selectByCatPriBigger(Integer categoryid, Integer price);
	List<ProductBean> selectByCat(Integer categoryid);

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
	List<PowerSupplierBean> showPowerSupplier(Integer PowerModel);
	List<ProductBean> selectByCatorderbyprice(Integer categoryid);
	List<ProductBean> selectByCatPriBiggerorderbyprice(Integer categoryid, Integer price);
	List<ProductBean> selectByinputorderbyprice(String searchspace);
	List<ProductBean> selectByCatPriorderbyprice(Integer categoryid, Integer price);
	List<ProductBean> selectByCatBraPriorderbyprice(Integer categoryid, Integer brandid, Integer price);
	List<ProductBean> selectByCatBraPriBiggerorderbyprice(Integer categoryid, Integer brandid, Integer price);
	List<ProductBean> selectByCatBraorderbyprice(Integer categoryid, Integer brandid);
	Map<String, Integer> selectAllByHashMap();


}

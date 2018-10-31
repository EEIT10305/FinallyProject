package model.dao;

import java.util.List;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.MbBean;
import model.bean.PinginBean;
import model.bean.PinginDetailBean;
import model.bean.ProductBean;
import model.bean.RamBean;

public interface ProductDAO {
    List<ProductBean> selectAll();
    ProductBean selectById(int id);
    List<ProductBean> selectByCategory(int Categoryid);
    ProductBean insert(ProductBean bean);
    boolean update(ProductBean bean);
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
}

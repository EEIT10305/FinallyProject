package model.dao;

import java.util.List;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.ImportDetailBean;
import model.bean.MbBean;
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
	
	
	List<ProductBean> selectAllByID(String improtid);

}

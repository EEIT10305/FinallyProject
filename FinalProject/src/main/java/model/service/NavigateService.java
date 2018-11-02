package model.service;

import java.util.List;
import java.util.Set;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.ProductBean;

public interface NavigateService {
	public List<CategoryBean> selectAllCategory();
	Set<BrandBean> selectBrand(String category);
	List<ProductBean> showProductByCategory(String category);
	List<ProductBean> selectByCatBraPri(String category, String brand, Integer price);
	List<ProductBean> selectByCatBra(String category, String brand);
	List<ProductBean> selectByCatPri(String category, Integer price);
	List<ProductBean> selectByCat(String category);
	List<ProductBean> selectByinput(String searchspace);
	
	
}

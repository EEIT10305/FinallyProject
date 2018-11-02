package model.dao;

import java.util.List;

import model.bean.ProductBean;

public interface ProductDAO {
    List<ProductBean> selectAll();
    ProductBean selectById(int id);
    public List<ProductBean> selectByCategory(int Categoryid);
    public List<ProductBean> selectByinput(String input);
    ProductBean insert(ProductBean bean);
    boolean update(ProductBean bean);
	List<ProductBean> selectByCatBraPri(Integer categoryid, Integer brandid, Integer price);
	List<ProductBean> selectByCatBraPriBigger(Integer categoryid, Integer brandid, Integer price);
	List<ProductBean> selectByCatBra(Integer categoryid, Integer brandid);
	List<ProductBean> selectByCatPri(Integer categoryid, Integer price);
	List<ProductBean> selectByCatPriBigger(Integer categoryid, Integer price);
	List<ProductBean> selectByCat(Integer categoryid);
}

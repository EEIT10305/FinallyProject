package model.dao;

import java.util.List;

import model.bean.ProductBean;

public interface ProductDAO {
    List<ProductBean> selectAll();
    ProductBean selectById(int id);
    ProductBean insert(ProductBean bean);
    boolean update(ProductBean bean);
}

package model.service;

import java.util.List;

import model.bean.CartDetailBean;

public interface CartDetailService {
	List<CartDetailBean> selectAll();
    CartDetailBean selectById(int id);
    CartDetailBean insert(CartDetailBean bean);
    boolean update(CartDetailBean bean);
    boolean delete(CartDetailBean bean);
}

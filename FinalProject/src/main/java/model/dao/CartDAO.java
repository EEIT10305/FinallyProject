package model.dao;

import java.util.List;

import model.CartBean;

public interface CartDAO {
	 List<CartBean> selectAll();
	    CartBean selectById(int id);
	    CartBean insert(CartBean bean);
	    boolean update(CartBean bean);
	    boolean delete(CartBean bean);
}

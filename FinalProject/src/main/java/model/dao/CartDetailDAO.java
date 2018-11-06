package model.dao;

import java.util.List;

import model.bean.CartDetailBean;

public interface CartDetailDAO {
	 List<CartDetailBean> selectAll();
	    CartDetailBean selectById(int id);
	    CartDetailBean insert(CartDetailBean bean);
	    boolean update(CartDetailBean bean);
	    boolean delete(CartDetailBean bean);
	    Integer getMemberId();
	    void setMemberId(Integer memberid);
		List<CartDetailBean> selectAllByCartId(Integer cartid);
}

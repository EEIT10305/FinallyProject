package model.service;

import java.util.List;

import model.bean.CartBean;

public interface CartService {

	 List<CartBean> selectAll();
	    CartBean selectById(int id);
	    CartBean insert(CartBean bean);
	    boolean update(CartBean bean);
	    boolean delete(CartBean bean);
	    Integer getMemberId();
	    void setMemberId(Integer memberid);
	    
}

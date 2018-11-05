package model.dao;

import java.util.List;

import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.MemberBean;

public interface CartDetailDAO {
	 List<CartDetailBean> selectAll();
	    CartDetailBean selectById(int id);
	    CartDetailBean insert(CartDetailBean bean);
	    boolean update(CartDetailBean bean);
//	    boolean deletebycartId(int cartid);
	    MemberBean getMemberId(int memberId);
	    //CartDetailBean selectCartId(int cartid);
	    List<CartDetailBean> selectbycartId(int cartid);
	    //void setMemberId(Integer memberid);
		boolean deletebycartId(Integer cartid);
	    
}

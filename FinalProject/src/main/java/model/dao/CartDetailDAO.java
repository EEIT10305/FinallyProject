package model.dao;

import java.util.List;

import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.MemberBean;

public interface CartDetailDAO {
	 List<CartDetailBean> selectAll();
	 List<CartDetailBean> selectAllByCartId(Integer cartid);
	    CartDetailBean selectById(int id);
	    CartDetailBean insert(CartDetailBean bean);
	    boolean update(CartDetailBean bean);
	    boolean deletebycartId(Integer cartid);
	    MemberBean getMemberId(int memberId);
	    List<CartDetailBean> selectbycartId(int cartid);
//	    boolean delete(CartDetailBean bean);
//	    boolean deletebycartId(int cartid);
	    //CartDetailBean selectCartId(int cartid);
	    //void setMemberId(Integer memberid);
	    
}

package model.service;

import java.util.List;

import model.bean.CartDetailBean;

public interface CartDetailService {
	List<CartDetailBean> selectAll();
    CartDetailBean selectById(Integer cartid);
    CartDetailBean insert(CartDetailBean bean);
    boolean update(CartDetailBean bean);
    boolean deletebycartId(int cartid);
    Integer getMemberId();
    void setMemberId(Integer memberid);
    //CartDetailBean selectCartId(int CartId);
    List<CartDetailBean> selectbycartId(int cartid);
   
    
}

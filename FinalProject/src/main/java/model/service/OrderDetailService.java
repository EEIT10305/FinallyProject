package model.service;

import java.util.List;

import model.bean.OrderDetailBean;

public interface OrderDetailService {
	 List<OrderDetailBean> selectAll();
	    OrderDetailBean selectById(Integer id);
	    OrderDetailBean insert(OrderDetailBean bean);
	    boolean update(OrderDetailBean bean);	
	    Integer getMemberId();
	    void setMemberId(Integer memberid);
	    List<OrderDetailBean> selectAllByOrderId(Integer OrderId);
}

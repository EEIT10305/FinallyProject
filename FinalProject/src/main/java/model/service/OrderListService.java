package model.service;

import java.util.List;

import model.bean.OrderListBean;

public interface OrderListService {
	 List<OrderListBean> selectAll();
	    OrderListBean selectById(int id);
	    OrderListBean insert(OrderListBean bean);
	    boolean update(OrderListBean bean);
	    Integer getMemberId();
	    void setMemberId(Integer memberid);
	    boolean updateOrderStatusByOrderId(int orderid);
	    boolean updateOrderArriveByOrderId(int orderid);
	    boolean updateOrderStatusByMemberId(int memberid);
	    boolean updateOrderArriveByMemberId(int memberid);
	    
}

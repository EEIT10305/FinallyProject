package model.dao;

import java.util.List;

import model.OrderDetailBean;

public interface OrderDetailDAO {
	 List<OrderDetailBean> selectAll();
	    OrderDetailBean selectById(int id);
	    OrderDetailBean insert(OrderDetailBean bean);
	    boolean update(OrderDetailBean bean);	   
}

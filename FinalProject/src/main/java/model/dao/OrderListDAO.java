package model.dao;

import java.util.List;

import model.bean.OrderListBean;

public interface OrderListDAO {
	 List<OrderListBean> selectAll();
	    OrderListBean selectById(int id);
	    OrderListBean insert(OrderListBean bean);
	    boolean update(OrderListBean bean);
}

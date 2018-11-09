package model.dao;

import java.util.List;

import model.bean.MemberBean;
import model.bean.OrderListBean;

public interface OrderListDAO {
	 List<OrderListBean> selectAll();
	    OrderListBean selectById(int id);
	    OrderListBean insert(OrderListBean bean);
	    boolean update(OrderListBean bean);
	    Integer getMemberId();
	    void setMemberId(Integer memberid);
		MemberBean selectMemberIdByEmail(String email);
		List<OrderListBean> selectAllByTime(String Time);
}

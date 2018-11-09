package model.dao;

import java.util.List;
import java.util.Map;

import model.bean.CartDetailBean;
import model.bean.MemberBean;
import model.bean.OrderDetailBean;

public interface OrderDetailDAO {
	 List<OrderDetailBean> selectAll();
	    OrderDetailBean selectById(int id);
	    OrderDetailBean insert(OrderDetailBean bean);
	    boolean update(OrderDetailBean bean);	 
	    Integer getMemberId();
	    void setMemberId(Integer memberid);
		List<Map<String, Object>> countSoldPro();
		List<OrderDetailBean> selectAllByOrderId(Integer OrderId);
		MemberBean selectMemberIdByEmail(String email);
		List<OrderDetailBean> selectByOrderId(Integer OrderId);
}

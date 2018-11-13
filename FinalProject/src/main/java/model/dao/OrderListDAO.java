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
	boolean updateOrderStatusByOrderId(int orderid);
	boolean updateOrderArriveByOrderId(int orderid);
	boolean updateOrderStatusByMemberId(int memberid);
	boolean updateOrderArriveByMemberId(int memberid);
	MemberBean selectMemberIdByEmail(String email);
	List<OrderListBean> selectAllByTime(String Time);
	List<OrderListBean> selectOrderListByMemberDate(String dateStart, String dateEnd, Integer memberId);
	List<OrderListBean> selectAllMemberOrderListByDateStatu(String dateStart, String dateEnd, String statu);
	List<OrderListBean> selectBetweenTime(String start, String end);

}

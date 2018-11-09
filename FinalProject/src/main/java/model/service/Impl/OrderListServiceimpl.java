package model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import model.bean.OrderListBean;
import model.dao.OrderListDAO;
import model.service.OrderListService;
@Service
@Transactional
public class OrderListServiceimpl implements OrderListService {

	@Autowired
	OrderListDAO  dao;
	
	private Integer memberid = null;

	public OrderListServiceimpl() {
		
	}

	@Override
	public List<OrderListBean> selectAll() {
		return dao.selectAll();
	}

	@Override
	public OrderListBean selectById(int id) {
		return dao.selectById(id);
	}

	@Override
	public OrderListBean insert(OrderListBean bean) {
		return dao.insert(bean);
	}

	@Override
	public boolean update(OrderListBean bean) {
		return dao.update(bean);
	}

	@Override
	public Integer getMemberId() {
		return memberid;
	}

	@Override
	public void setMemberId(Integer memberid) {
		this.memberid  = memberid;
		
	}

	@Override
	public boolean updateOrderStatusByOrderId(int orderid) {
		return dao.updateOrderStatusByOrderId(orderid);
	}

	@Override
	public boolean updateOrderArriveByOrderId(int orderid) {
		return dao.updateOrderArriveByOrderId(orderid);
	}

	@Override
	public boolean updateOrderStatusByMemberId(int memberid) {
		return dao.updateOrderStatusByMemberId(memberid);
	}

	@Override
	public boolean updateOrderArriveByMemberId(int memberid) {
		return dao.updateOrderArriveByMemberId(memberid);
	}

}

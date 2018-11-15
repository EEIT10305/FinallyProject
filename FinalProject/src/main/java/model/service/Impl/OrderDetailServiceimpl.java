package model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.OrderDetailBean;
import model.dao.OrderDetailDAO;
import model.service.OrderDetailService;
@Service
@Transactional
public class OrderDetailServiceimpl implements OrderDetailService {
	@Autowired
	OrderDetailDAO Dao;
	
	private Integer memberid = null;
	
	
	public OrderDetailServiceimpl() {
		
	}
	@Override
	public List<OrderDetailBean> selectAll() {
		return Dao.selectAll();
	}

	@Override
	public OrderDetailBean selectById(Integer id) {
		return Dao.selectById(id);
	}

	@Override
	public OrderDetailBean insert(OrderDetailBean bean) {
		return Dao.insert(bean);
	}

	@Override
	public boolean update(OrderDetailBean bean) {
		return Dao.update(bean);
	}
	@Override
	public Integer getMemberId() {
		return memberid;
	}
	@Override
	public void setMemberId(Integer memberid) {
		this.memberid= memberid;
		
	}
	@Override
	public List<OrderDetailBean> selectAllByOrderId(Integer OrderId) {
		return Dao.selectAllByOrderId(OrderId);
	}

}

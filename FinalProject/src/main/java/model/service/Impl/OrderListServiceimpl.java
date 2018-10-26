package model.service.Impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import model.bean.OrderListBean;
import model.dao.OrderListDAO;
import model.service.OrderListService;
@Service
public class OrderListServiceimpl implements OrderListService {

	@Autowired
	OrderListDAO  dao;

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

}

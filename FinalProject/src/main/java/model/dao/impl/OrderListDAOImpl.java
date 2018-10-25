package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.OrderListBean;
import model.dao.OrderListDAO;
@Repository
public class OrderListDAOImpl implements OrderListDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<OrderListBean> selectAll() {
		return this.getSession().createQuery("FROM OrderListBean",OrderListBean.class).setMaxResults(50).list();
	}

	@Override
	public OrderListBean selectById(int id) {
		return this.getSession().get(OrderListBean.class, id);
	}

	@Override
	public OrderListBean insert(OrderListBean bean) {
		if(bean!=null) {
			if(true) {
				System.out.println(bean.getOrderid());
				this.getSession().save(bean);
				return bean;
			}			
		}
		return null;
	}

	@Override
	public boolean update(OrderListBean bean) {
		if(bean!=null) {
			OrderListBean temp = this.getSession().get(OrderListBean.class, bean.getOrderid());
			if(temp!=null) {
				temp.setDate(bean.getDate());
				temp.setMemberid(bean.getMemberid());
				temp.setTotal(bean.getTotal());
				temp.setShipping(bean.getShipping());
				this.getSession().flush();
				return true;
			}			
		}
		return false;
	}
}

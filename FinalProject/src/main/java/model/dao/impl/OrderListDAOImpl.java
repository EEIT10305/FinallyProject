package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MemberBean;
import model.bean.OrderListBean;
import model.dao.OrderListDAO;
@Repository
public class OrderListDAOImpl implements OrderListDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Integer memberid = null;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<OrderListBean> selectAll() {
		return this.getSession().createQuery("FROM OrderListBean",OrderListBean.class).setMaxResults(50).list();
	}
	@Override
	public List<OrderListBean> selectAllByTime(String Time) {
		return this.getSession().createQuery("FROM OrderListBean where date=:Time",OrderListBean.class).setParameter("Time", Time).list();
	}

	@Override
	public OrderListBean selectById(int id) {
		return this.getSession().get(OrderListBean.class, id);
	}
	@Override
	public MemberBean selectMemberIdByEmail(String email) {
		String hql="FROM MemberBean where email=:email";
		return this.getSession().createQuery(hql,MemberBean.class).setParameter("email", email).getSingleResult();
	}

	@Override
	public OrderListBean insert(OrderListBean bean) {
		if(bean!=null) {
				this.getSession().save(bean);
				return bean;
		}else {
			return null;
		}
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

	@Override
	public Integer getMemberId() {
		return memberid;
	}

	@Override
	public void setMemberId(Integer memberid) {
		this.memberid = memberid;
		
	}

	@Override
	public boolean updateOrderStatusByOrderId(int orderid) {
		String hql = "from OrderListBean where orderid=: orderid";
		this.getSession().get(OrderListBean.class, orderid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("orderid", orderid).getSingleResult();
		orderListBean.setStatu("pay");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public boolean updateOrderArriveByOrderId(int orderid) {
		String hql = "from OrderListBean where orderid=: orderid";
		this.getSession().get(OrderListBean.class, orderid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("orderid", orderid).getSingleResult();
		orderListBean.setArrive("arrived");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public boolean updateOrderStatusByMemberId(int memberid) {
		String hql = "from OrderListBean where memberid=: memberid";
		this.getSession().get(OrderListBean.class, memberid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("memberid", memberid).getSingleResult();
		orderListBean.setStatu("pay");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public boolean updateOrderArriveByMemberId(int memberid) {
		String hql = "from OrderListBean where memberid=: memberid";
		this.getSession().get(OrderListBean.class, memberid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("memberid", memberid).getSingleResult();
		orderListBean.setArrive("arrived");
		this.getSession().update(orderListBean);
		return true;
	}
	
	
	
}

package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.CartBean;
import model.dao.CartDAO;
@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Integer memberid = null;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CartBean> selectAll() {
		return this.getSession().createQuery("FROM CartBean",CartBean.class).setMaxResults(50).list();
	}

	@Override
	public CartBean selectById(int id) {
		return this.getSession().get(CartBean.class, id);
	}

	@Override
	public CartBean insert(CartBean bean) {
		if(bean!=null) {
			if(true) {
				System.out.println(bean.getCartid());
				this.getSession().save(bean);
				return bean;
			}			
		}
		return null;
	}

	@Override
	public boolean update(CartBean bean) {
		if(bean!=null) {
			CartBean temp = this.getSession().get(CartBean.class, bean.getCartid());
			if(temp!=null) {
				temp.setCartid(bean.getCartid());
				temp.setMemberid(bean.getMemberid());
				temp.setDate(bean.getDate());
				temp.setStatus(bean.getStatus());
				this.getSession().flush();
				return true;
			}			
		}
		return false;
	}

	@Override
	public boolean delete(CartBean bean) {
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
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
}

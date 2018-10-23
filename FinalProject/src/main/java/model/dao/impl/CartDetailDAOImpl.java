package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartDetailBean;
import model.dao.CartDetailDAO;

@Repository
public class CartDetailDAOImpl implements CartDetailDAO{
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CartDetailBean> selectAll() {
		return this.getSession().createQuery("FROM CartDetailBean", CartDetailBean.class).setMaxResults(50).list();
	}

	@Override
	public CartDetailBean selectById(int id) {
		return this.getSession().get(CartDetailBean.class, id);
	}

	@Override
	public CartDetailBean insert(CartDetailBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(CartDetailBean bean) {
		if (bean != null) {
			CartDetailBean temp = this.getSession().get(CartDetailBean.class, bean.getId());
			if (temp != null) {
				try {
					temp.setCartid(bean.getCartid());
					temp.setProid(bean.getProid());
					temp.setAmount(bean.getAmount());
					this.getSession().flush();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public boolean delete(CartDetailBean bean) {
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
}

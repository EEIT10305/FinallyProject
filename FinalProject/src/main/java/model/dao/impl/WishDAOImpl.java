package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishBean;
import model.dao.WishDAO;

@Repository
public class WishDAOImpl implements WishDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishBean> selectAll() {
		return this.getSession().createQuery("FROM WishBean", WishBean.class).setMaxResults(50).list();
	}

	@Override
	public WishBean selectById(int id) {
		return this.getSession().get(WishBean.class, id);
	}

	@Override
	public WishBean insert(WishBean bean) {
		if (bean != null) {
			if (true) {
				System.out.println(bean.getWishid());
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public boolean update(WishBean bean) {
		if (bean != null) {
			WishBean temp = this.getSession().get(WishBean.class, bean.getWishid());
			if (temp != null) {
				temp.setMemberid(bean.getMemberid());
				temp.setProid(bean.getProid());
				temp.setTracked(bean.getTracked());
				this.getSession().flush();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(WishBean bean) {
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
}

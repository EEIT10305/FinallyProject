package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.BranchBean;
import model.dao.BranchDAO;
@Repository
public class BranchDAOImpl implements BranchDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<BranchBean> selectAll() {
		return this.getSession().createQuery("FROM BranchBean", BranchBean.class).setMaxResults(50).list();
	}

	@Override
	public BranchBean selectById(int id) {
		return this.getSession().get(BranchBean.class, id);
	}

	@Override
	public BranchBean insert(BranchBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(BranchBean bean) {
		if (bean != null) {
			BranchBean temp = this.getSession().get(BranchBean.class, bean.getBranchid());
			if (temp != null) {
				try {
					temp.setName(bean.getName());
					temp.setAddress(bean.getAddress());
					temp.setPhone(bean.getPhone());
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}

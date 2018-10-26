package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StorageBean;
import model.dao.StorageDAO;
@Repository
public class StorageDAOImpl implements StorageDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<StorageBean> selectAll() {
		return this.getSession().createQuery("FROM StorageBean", StorageBean.class).setMaxResults(50).list();
	}

	@Override
	public StorageBean selectById(int id) {
		return this.getSession().get(StorageBean.class, id);
	}

	@Override
	public StorageBean insert(StorageBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(StorageBean bean) {
		if (bean != null) {
			StorageBean temp = this.getSession().get(StorageBean.class, bean.getStorage_id());
			if (temp != null) {
				try {
					temp.setProid(bean.getProid());
					temp.setBrand(bean.getBrand());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setStatu(bean.getStatu());
					temp.setPsu(bean.getPsu());
					this.getSession().flush();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}

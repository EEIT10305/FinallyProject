package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.ImportBean;
import model.dao.ImportDAO;
@Repository
public class ImportDAOImpl implements ImportDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ImportBean> selectAll() {
		return this.getSession().createQuery("FROM ImportBean", ImportBean.class).setMaxResults(50).list();
	}

	@Override
	public ImportBean selectById(int id) {
		return this.getSession().get(ImportBean.class, id);
	}

	@Override
	public ImportBean insert(ImportBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(ImportBean bean) {
		if (bean != null) {
			ImportBean temp = this.getSession().get(ImportBean.class, bean.getImprotid());
			if (temp != null) {
				try {
					temp.setOrderdate(bean.getOrderdate());
					temp.setArrivedate(bean.getArrivedate());
					temp.setStatu(bean.getStatu());
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

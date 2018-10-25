package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.CabinetBean;
import model.dao.CabinetDAO;
@Repository
public class CabinetDAOimpl implements CabinetDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CabinetBean> selectAll() {
		return this.getSession().createQuery("FROM CabinetBean", CabinetBean.class).setMaxResults(50).list();
	}

	@Override
	public CabinetBean selectById(int id) {
		return this.getSession().get(CabinetBean.class, id);
	}

	@Override
	public CabinetBean insert(CabinetBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(CabinetBean bean) {
		if (bean != null) {
			CabinetBean temp = this.getSession().get(CabinetBean.class, bean.getCabinet_id());
			if (temp != null) {
				try {
					temp.setProid(bean.getProid());
					temp.setBrand(bean.getBrand());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setStatus(bean.getStatus());
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

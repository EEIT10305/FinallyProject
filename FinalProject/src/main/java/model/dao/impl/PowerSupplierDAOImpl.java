package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.PowerSupplierBean;
import model.dao.PowerSupplierDAO;

@Repository
public class PowerSupplierDAOImpl implements PowerSupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<PowerSupplierBean> selectAll() {
		return this.getSession().createQuery("FROM PowerSupplierBean", PowerSupplierBean.class).setMaxResults(50).list();
	}

	@Override
	public PowerSupplierBean selectById(int id) {
		return this.getSession().get(PowerSupplierBean.class, id);
	}

	@Override
	public PowerSupplierBean insert(PowerSupplierBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(PowerSupplierBean bean) {
		if (bean != null) {
			PowerSupplierBean temp = this.getSession().get(PowerSupplierBean.class, bean.getPowersupplier_id());
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

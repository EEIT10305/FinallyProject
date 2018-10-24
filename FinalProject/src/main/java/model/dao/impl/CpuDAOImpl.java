package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.CpuBean;
import model.dao.CpuDAO;
@Repository
public class CpuDAOImpl implements CpuDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CpuBean> selectAll() {
		return this.getSession().createQuery("FROM CpuBean", CpuBean.class).setMaxResults(50).list();
	}

	@Override
	public CpuBean selectById(int id) {
		return this.getSession().get(CpuBean.class, id);
	}

	@Override
	public CpuBean insert(CpuBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(CpuBean bean) {
		if (bean != null) {
			CpuBean temp = this.getSession().get(CpuBean.class, bean.getCpu_id());
			if (temp != null) {
				try {
					temp.setCpu_id(bean.getCpu_id());
					temp.setBrand(bean.getBrand());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setStatus(bean.getStatus());
					temp.setFeet(bean.getFeet());
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

package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.RamBean;
import model.dao.RamDAO;
@Repository
public class RamDAOImpl implements RamDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<RamBean> selectAll() {
		return this.getSession().createQuery("FROM RamBean", RamBean.class).setMaxResults(50).list();
	}

	@Override
	public RamBean selectById(int id) {
		return this.getSession().get(RamBean.class, id);
	}

	@Override
	public RamBean insert(RamBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(RamBean bean) {
		if (bean != null) {
			RamBean temp = this.getSession().get(RamBean.class, bean.getRam_id());
			if (temp != null) {
				try {
					temp.setProid(bean.getProid());
					temp.setBrand(bean.getBrand());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setStatu(bean.getStatu());
					temp.setDdr(bean.getDdr());
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

package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.VgaBean;
import model.dao.VgaDAO;
@Repository
public class VgaDAOImpl implements VgaDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<VgaBean> selectAll() {
		return this.getSession().createQuery("FROM VgaBean", VgaBean.class).setMaxResults(50).list();
	}

	@Override
	public VgaBean selectById(int id) {
		return this.getSession().get(VgaBean.class, id);
	}

	@Override
	public VgaBean insert(VgaBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(VgaBean bean) {
		if (bean != null) {
			VgaBean temp = this.getSession().get(VgaBean.class, bean.getVga_id());
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

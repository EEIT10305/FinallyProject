package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MbBean;
import model.dao.MbDAO;
@Repository
public class MbDAOImpl implements MbDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<MbBean> selectAll() {
		return this.getSession().createQuery("FROM MbBean", MbBean.class).setMaxResults(50).list();
	}

	@Override
	public MbBean selectById(int id) {
		return this.getSession().get(MbBean.class, id);
	}

	@Override
	public MbBean insert(MbBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(MbBean bean) {
		if (bean != null) {
			MbBean temp = this.getSession().get(MbBean.class, bean.getMb_id());
			if (temp != null) {
				try {
					temp.setProid(bean.getProid());
					temp.setBrand(bean.getBrand());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setStatus(bean.getStatus());
					temp.setFeet(bean.getFeet());
					temp.setDdr(bean.getDdr());
					temp.setPsu(bean.getPsu());
					temp.setSize(bean.getSize());
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

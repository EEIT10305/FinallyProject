package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.PinginDetailBean;
import model.dao.PinginDetailDAO;
@Repository
public class PinginDetailDAOImpl implements PinginDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<PinginDetailBean> selectAll() {
		return this.getSession().createQuery("FROM PinginDetailBean", PinginDetailBean.class).setMaxResults(50).list();
	}

	@Override
	public PinginDetailBean selectById(int id) {
		return this.getSession().get(PinginDetailBean.class, id);
	}

	@Override
	public PinginDetailBean insert(PinginDetailBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(PinginDetailBean bean) {
		if (bean != null) {
			PinginDetailBean temp = this.getSession().get(PinginDetailBean.class, bean.getPingin_detail_id());
			if (temp != null) {
				try {
					temp.setPinginid(bean.getPinginid());
					temp.setName(bean.getName());				
					temp.setBrand(bean.getBrand());
					temp.setCategory(bean.getCategory());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());				
					this.getSession().flush();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	@Override
	public List<PinginDetailBean> selectPinginDetailByName(String name) {
		String hql = "from PinginDetailBean where name= :name";
		return this.getSession().createQuery(hql,PinginDetailBean.class).setParameter("name", name).getResultList();
	}
	
}

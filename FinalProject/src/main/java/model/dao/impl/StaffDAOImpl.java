package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StaffBean;
import model.dao.StaffDAO;
@Repository
public class StaffDAOImpl implements StaffDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<StaffBean> selectAll() {
		return this.getSession().createQuery("FROM StaffBean",StaffBean.class).setMaxResults(50).list();
	}

	@Override
	public StaffBean selectById(int id) {
		return this.getSession().get(StaffBean.class, id);
	}

	@Override
	public StaffBean insert(StaffBean bean) {
		if(bean!=null) {
			if(true) {
				System.out.println(bean.getStaff_id());
				this.getSession().save(bean);
				return bean;
			}			
		}
		return null;
	}

	@Override
	public boolean update(StaffBean bean) {
		if(bean!=null) {
			StaffBean temp = this.getSession().get(StaffBean.class, bean.getStaff_id());
			if(temp!=null) {
				temp.setName(bean.getName());
				temp.setEmail(bean.getEmail());
 			    temp.setPassword(bean.getEmail());
				temp.setPermission(bean.getPermission());
				temp.setAddress(bean.getAddress());
				temp.setPhone(bean.getPhone());				
				return true;
			}			
		}
		return false;
	}
}

package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MemberBean;
import model.dao.MemberDAO;
import model.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<MemberBean> selectAll() {
		return this.getSession().createQuery("FROM MemberBean",MemberBean.class).setMaxResults(50).list();
	}

	@Override
	public MemberBean selectById(int id) {
		return this.getSession().get(MemberBean.class, id);
	}

	@Override
	public MemberBean insert(MemberBean bean) {
		if(bean!=null) {
			if(true) {
				System.out.println(bean.getMemberid());
				this.getSession().save(bean);
				return bean;
			}			
		}
		return null;
	}

	@Override
	public boolean update(MemberBean bean) {
		if(bean!=null) {
			MemberBean temp = this.getSession().get(MemberBean.class, bean.getMemberid());
			if(temp!=null) {
				temp.setName(bean.getName());
				temp.setEmail(bean.getEmail());
 			    temp.setPassword(bean.getEmail());
				temp.setPermission(bean.getPermission());
				temp.setAddress(bean.getAddress());
				temp.setPhone(bean.getPhone());
				temp.setGender(bean.getGender());
				return true;
			}			
		}
		return false;
	}
}

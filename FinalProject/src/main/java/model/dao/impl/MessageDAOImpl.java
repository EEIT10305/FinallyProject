package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MessageBean;
import model.dao.MessageDAO;
@Repository
public class MessageDAOImpl implements MessageDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<MessageBean> selectAll() {
		return this.getSession().createQuery("FROM MessageBean", MessageBean.class).setMaxResults(50).list();
	}

	@Override
	public MessageBean selectById(int id) {
		return this.getSession().get(MessageBean.class, id);
	}

	@Override
	public MessageBean insert(MessageBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(MessageBean bean) {
		if (bean != null) {
			MessageBean temp = this.getSession().get(MessageBean.class, bean.getMessage_id());
			if (temp != null) {
				try {
					temp.setMemberidA(bean.getMemberidA());
					temp.setMemberidB(bean.getMemberidB());
					temp.setDate(bean.getDate());
					temp.setMessage(bean.getMessage());				
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}

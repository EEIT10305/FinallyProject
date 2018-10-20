package model.dao.impl;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import misc.SpringJavaConfiguration;
import model.PinginBean;
import model.dao.PinginDAO;
@Repository
public class PinginDAOImpl implements PinginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	

	/* (non-Javadoc)
	 * @see model.dao.impl.PinginDAO#select(java.lang.Integer)
	 */
	@Override
	public PinginBean select(Integer pinginid) {
		return this.getSession().get(PinginBean.class, pinginid);
	}
	/* (non-Javadoc)
	 * @see model.dao.impl.PinginDAO#select()
	 */
	@Override
	public List<PinginBean> select() {
		return this.getSession().createQuery(
				"from PinginBean", PinginBean.class).list();
	}
	/* (non-Javadoc)
	 * @see model.dao.impl.PinginDAO#update(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.sql.Blob)
	 */
	@Override
	public boolean update(String pinginid,String name, Integer price, String status,Blob picture) {
		PinginBean temp = this.getSession().get(PinginBean.class, pinginid);
		if(temp!=null) {
			temp.setName(name);
			temp.setPrice(price);
			temp.setStatus(status);
			temp.setPicture(picture);
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.impl.PinginDAO#insert(model.PinginBean)
	 */
	@Override
	public PinginBean insert(PinginBean bean) {
		if(bean!=null) {
			PinginBean temp = this.getSession().get(PinginBean.class, bean.getPinginid());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.impl.PinginDAO#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer pingin_id) {
		PinginBean temp = this.getSession().get(PinginBean.class, pingin_id);
		if(temp!=null) {
			this.getSession().delete(temp);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		System.out.println(1);
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		sessionFactory.getCurrentSession().beginTransaction();
		System.out.println(2);
		PinginDAO pinginDAO =context.getBean(PinginDAO.class);
		System.out.println(3);
		List<PinginBean> select = pinginDAO.select();
		if(select.size()==0) {
			System.out.println("hahaha");
		}

		sessionFactory.getCurrentSession().getTransaction().commit();
	}
}

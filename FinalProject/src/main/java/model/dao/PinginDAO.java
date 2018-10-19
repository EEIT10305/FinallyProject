package model.dao;

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
@Repository
public class PinginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	

	public PinginBean select(Integer pinginid) {
		return this.getSession().get(PinginBean.class, pinginid);
	}
	public List<PinginBean> select() {
		return this.getSession().createQuery(
				"from PinginBean", PinginBean.class).list();
	}
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

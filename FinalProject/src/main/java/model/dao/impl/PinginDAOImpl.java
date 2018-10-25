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
import model.bean.PinginBean;
import model.dao.PinginDAO;
@Repository
public class PinginDAOImpl implements PinginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	

	@Override
	public PinginBean selectById(int pinginid) {
		return this.getSession().get(PinginBean.class, pinginid);
	}
	
	@Override
	public List<PinginBean> selectAll() {
		return this.getSession().createQuery(
				"from PinginBean", PinginBean.class).list();
	}
	
	@Override
	public boolean update(PinginBean bean) {
		PinginBean temp = this.getSession().get(PinginBean.class, bean.getPinginid());
		if(temp!=null) {
			temp.setName(bean.getName());
			temp.setPrice(bean.getPrice());
			temp.setStatus(bean.getStatus());
			temp.setPicture(bean.getPicture());
			return true;
		}
		return false;
	}
	
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
		List<PinginBean> select = pinginDAO.selectAll();
		if(select.size()==0) {
			System.out.println("hahaha");
		}

		sessionFactory.getCurrentSession().getTransaction().commit();
	}
}

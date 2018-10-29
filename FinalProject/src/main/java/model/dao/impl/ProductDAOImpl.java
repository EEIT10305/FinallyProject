package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.ProductBean;
import model.dao.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ProductBean> selectAll() {
		return this.getSession().createQuery("FROM ProductBean", ProductBean.class).setMaxResults(50).list();
	}

	@Override
	public ProductBean selectById(int id) {
		return this.getSession().get(ProductBean.class, id);
	}
	@Override
	public List<ProductBean> selectByCategory(int Categoryid) {
		String hql ="From ProductBean where Categoryid= :Categoryid";
		
		return this.getSession().createQuery(hql,ProductBean.class).setParameter("Categoryid", Categoryid).getResultList();	
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(ProductBean bean) {
		if (bean != null) {
			ProductBean temp = this.getSession().get(ProductBean.class, bean.getProid());
			if (temp != null) {
				try {
					temp.setBrandid(bean.getBrandid());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setPicture(bean.getPicture());
					temp.setStatu(bean.getStatu());
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

package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.dao.BrandDAO;
@Repository
@Transactional
public class BrandDAOImpl implements BrandDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

		@Override
	public List<BrandBean> selectAll() {
		return this.getSession().createQuery("FROM BrandBean", BrandBean.class).setMaxResults(50).list();
	}

	@Override
	public BrandBean selectById(int id) {
		return this.getSession().get(BrandBean.class, id);
	}

	@Override
	public BrandBean insert(BrandBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(BrandBean bean) {		
		if(bean!=null) {
			BrandBean temp = this.getSession().get(BrandBean.class, bean.getBrandid());
			if(temp!=null) {
				temp.setBrandid(bean.getBrandid());
				temp.setBrand(bean.getBrand());				
				return true;
			}			
		}
		return false;
	}

	@Override
	public BrandBean getBrandBeanBybrand(String brand) {		
		String hql ="From BrandBean where brand=:brand";
		return this.getSession().createQuery(hql,BrandBean.class).setParameter("brand", brand).getSingleResult();
	}
	
	
}

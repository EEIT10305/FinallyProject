/**
 * 
 */
package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import jdk.nashorn.internal.runtime.ECMAException;
import misc.SpringJavaConfiguration;
import model.bean.BranchStockBean;
import model.bean.ProductBean;
import model.dao.BranchStockDAO;

@Repository
public class BranchStockDAOImpl implements BranchStockDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionfactroy=(SessionFactory) ctx.getBean("sessionFactory");
		sessionfactroy.getCurrentSession().beginTransaction();
		BranchStockDAOImpl branchStockDAOImpl= (BranchStockDAOImpl) ctx.getBean("branchStockDAOImpl");
		Integer selects = branchStockDAOImpl.checkAmmount(3);
		sessionfactroy.getCurrentSession().getTransaction().commit();
		System.out.println(selects);
	    sessionfactroy.close();
	}

	@Override
	public List<BranchStockBean> selectAll() {
		return this.getSession().createQuery("FROM BranchStockBean", BranchStockBean.class).setMaxResults(50).list();
	}

	@Override
	public BranchStockBean selectById(int id) {
		return this.getSession().get(BranchStockBean.class, id);
	}
	@Override	
	public BranchStockBean selectAllByID(Integer proid) {
		String hql = "From BranchStockBean where proid =:proid";
		try {
			BranchStockBean bean= this.getSession().createQuery(hql, BranchStockBean.class).setParameter("proid", proid).getSingleResult();			
			return bean;
		}catch(Exception e) {
			return null;
		}
	}	
	
	@Override
	public BranchStockBean insert(BranchStockBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(BranchStockBean bean) {
		if (bean != null) {
			BranchStockBean temp = this.getSession().get(BranchStockBean.class, bean.getBranch_stock_id());
			if (temp != null) {
				try {
					temp.setBranchid(bean.getBranchid());
					temp.setProid(bean.getProid());
					temp.setAmount(bean.getAmount());
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
	
	@Override
	public boolean updateBranchStock(Integer amount, String statu, Integer proid){
		this.getSession();
		String hql = "Update BranchStockBean set amount =: amount , statu =: statu where proid =: proid";
		Query query = this.getSession().createQuery(hql)
				.setParameter("amount", amount)
				.setParameter("statu", statu)
				.setParameter("proid", proid);
		 int re = query.executeUpdate();
		 if(re > 0) {
			 return  true;
		 }
		
		return false;
	}
	
	@Override
	public BranchStockBean insertintoStock(Integer amount, Integer branchid, Integer proid, String statu){
		this.getSession();
		
		BranchStockBean bean = new BranchStockBean();		
		bean.setAmount(amount);
		bean.setBranchid(branchid);
		bean.setProid(proid);
		bean.setStatu(statu);
		this.getSession().save(bean);	
		
		return bean;
	}
	@Override
	public BranchStockBean selectbranchStock(Integer proid) {
		String hql="from BranchStockBean where proid=:proid and branchid=1";
		
		return this.getSession().createQuery(hql,BranchStockBean.class).setParameter("proid", proid).getSingleResult();
	}

	@Override
	public ProductBean selectByModel(String Model) {
        String hql="from ProductBean where Model=:Model";
        ProductBean  productBean = new ProductBean();
        productBean = this.getSession()
				.createQuery(hql,ProductBean.class).setParameter("Model", Model).getSingleResult();
		return productBean;
	}

	@Override
	public Integer checkAmmount(Integer proid) {
		 String hql="from BranchStockBean where proid=:proid and branchid=1";
		 BranchStockBean  branchStockBean = new BranchStockBean();
		 branchStockBean = this.getSession()
					.createQuery(hql,BranchStockBean.class).setParameter("proid", proid).getSingleResult();
		 Integer number = branchStockBean.getAmount();
			return number;
	}


	
	
	
	
	
	
}

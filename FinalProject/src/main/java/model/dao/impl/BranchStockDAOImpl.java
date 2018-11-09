/**
 * 
 */
package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BranchStockBean;
import model.dao.BranchStockDAO;

@Repository
@Transactional
public class BranchStockDAOImpl implements BranchStockDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
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
	public List<BranchStockBean> selectAllByBranchID(Integer branchid) {
		String hql = "From BranchStockBean where branchid =:branchid";
		try {
			List<BranchStockBean> bean= this.getSession().createQuery(hql, BranchStockBean.class).setParameter("branchid", branchid).getResultList();			
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
	public List<BranchStockBean> updateList(List<BranchStockBean> branchStockBean, Integer x){
		BranchStockBean temp = this.getSession().get(BranchStockBean.class, branchStockBean.get(x).getBranch_stock_id());
		temp.setBranchid(branchStockBean.get(x).getBranchid());
		temp.setProid(branchStockBean.get(x).getProid());
		temp.setAmount(branchStockBean.get(x).getAmount());
		temp.setStatu(branchStockBean.get(x).getStatu());
		this.getSession().flush();
	
		
		return null;
				
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
	public List<BranchStockBean> selectByProId(Integer proid) {
		String hql = "From BranchStockBean where proid =:proid";
		return this.getSession().createQuery(hql, BranchStockBean.class).setParameter("proid", proid).list();
	}
	
	
	@Override
	public Integer getAmountByproid(Integer proid) {
		String hql = "from BranchStockBean where branchid=1 and proid= :proid";
		BranchStockBean bean = this.getSession().createQuery(hql,BranchStockBean.class).setParameter("proid", proid).getSingleResult();
		System.out.println("proid= " + proid);
		return bean.getAmount();
		
	}
	
	
	
}

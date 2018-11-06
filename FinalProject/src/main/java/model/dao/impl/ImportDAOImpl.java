package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.bean.ImportBean;
import model.dao.ImportDAO;

@Repository
public class ImportDAOImpl implements ImportDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ImportBean> selectAll() {
		return this.getSession().createQuery("FROM ImportBean", ImportBean.class).getResultList();
	}

	@Override
	public ImportBean selectById(int id) {
		return this.getSession().get(ImportBean.class, id);
	}
	
	
	@Override
	public List<ImportBean> selectByArrivedate(String arrivedate) {
		String hql = "From ImportBean where arrivedate=:arrivedate";

		return this.getSession().createQuery(hql, ImportBean.class).setParameter("arrivedate", arrivedate).list();

	}

	
	@Override
	public List<ImportBean> selectByOrderdate(String orderdate) {
		
		String hql = "From ImportBean where orderdate = : orderdate";

		return this.getSession().createQuery(hql, ImportBean.class).setParameter("orderdate", orderdate).list();
	}

	
	@Override
	public List<ImportBean> selectByStatus(String statu) {

		String hql = "From ImportBean where statu = : statu";
	
		return this.getSession().createQuery(hql, ImportBean.class).setParameter("statu", statu).list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ImportBean> selectByADOD(String arrivedate, String orderdate) {

		String hql = "From ImportBean where arrivedate =: arrivedate "
									 + "and orderdate =: orderdate";
		return this.getSession().createQuery(hql)
				.setParameter("arrivedate", arrivedate)
				.setParameter("orderdate", orderdate).list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ImportBean> selectByADS(String arrivedate, String statu) {

		String hql = "From ImportBean where arrivedate =: arrivedate "
									 + "and statu =: statu";
		return this.getSession().createQuery(hql)
				.setParameter("arrivedate", arrivedate)
				.setParameter("statu", statu).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ImportBean> selectByODS(String orderdate, String statu) {

		String hql = "From ImportBean where orderdate =: orderdate "
									 + "and statu =: statu";
		return this.getSession().createQuery(hql)
				.setParameter("orderdate", orderdate)
				.setParameter("statu", statu).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ImportBean> selectByADODS(String arrivedate, String orderdate, String statu) {

		
		String hql = "From ImportBean where arrivedate =: arrivedate "
				 + "and orderdate =: orderdate "
				 + "and statu =: statu";

		return this.getSession().createQuery(hql)
				.setParameter("arrivedate", arrivedate)
				.setParameter("orderdate", orderdate)
				.setParameter("statu", statu).list();
	}

	@Override
	public ImportBean insert(ImportBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(ImportBean bean) {
		if (bean != null) {
			ImportBean temp = this.getSession().get(ImportBean.class, bean.getImprotid());
			if (temp != null) {
				try {
					temp.setOrderdate(bean.getOrderdate());
					temp.setArrivedate(bean.getArrivedate());
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

	
	@SuppressWarnings("rawtypes")
	@Override
	public List <ImportBean> updateStatus(String statu, Integer improtid) {
		this.getSession();
		String hql = "Update ImportBean set statu =: statu where improtid =: improtid";		
		Query query = this.getSession().createQuery(hql).setParameter("statu", statu).setParameter("improtid", improtid);
		query.executeUpdate();
//		return this.getSession().createQuery(hql).setParameter("statu", statu).setParameter("improtid", improtid).list();
		return null;
	}

	@Override
	public ImportBean getImportDetail(Integer improtid){

		String hql = "From ImportBean where improtid =: improtid";
		
		return this.getSession().createQuery(hql, ImportBean.class).setParameter("improtid", improtid).getSingleResult();
	}
		
	

}

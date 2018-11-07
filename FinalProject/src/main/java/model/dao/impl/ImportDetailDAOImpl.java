package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.ImportDetailBean;
import model.bean.ProductBean;
import model.dao.ImportDetailDAO;

@Repository
public class ImportDetailDAOImpl implements ImportDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ImportDetailBean> selectAll() {
		return this.getSession().createQuery("FROM ImportDetailBean", ImportDetailBean.class).setMaxResults(50).list();
	}

	@Override
	public ImportDetailBean selectById(int id) {
		return this.getSession().get(ImportDetailBean.class, id);
	}

	@Override
	public List<ImportDetailBean> selectAllByID(Integer improtid) {
		String hql = "FROM ImportDetailBean where improtid=:improtid";
		return this.getSession().createQuery(hql, ImportDetailBean.class).setParameter("improtid", improtid).list();
	}
	

	@Override
	public ImportDetailBean insert(ImportDetailBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(ImportDetailBean bean) {
		if (bean != null) {
			ImportDetailBean temp = this.getSession().get(ImportDetailBean.class, bean.getImprot_detailid());
			if (temp != null) {
				try {
					temp.setImprotid(bean.getImprotid());
					temp.setProid(bean.getProid());
					temp.setAmount(bean.getAmount());
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

package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.AllStockBean;
import model.dao.AllStockDAO;
@Repository
public class AllStockDAOImpl implements AllStockDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<AllStockBean> selectAll() {
		return this.getSession().createQuery("FROM AllStockBean", AllStockBean.class).setMaxResults(50).list();
	}

	@Override
	public AllStockBean selectById(int id) {
		return this.getSession().get(AllStockBean.class, id);
	}

	@Override
	public AllStockBean insert(AllStockBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(AllStockBean bean) {
		if (bean != null) {
			AllStockBean temp = this.getSession().get(AllStockBean.class, bean.getAll_stock_id());
			if (temp != null) {
				try {
					temp.setProid(bean.getProid());
					temp.setBrand(bean.getBrand());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setUnitprice(bean.getUnitprice());
					temp.setStock(bean.getStock());				
					temp.setStatus(bean.getStatus());					
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}

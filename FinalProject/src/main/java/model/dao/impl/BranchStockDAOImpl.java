/**
 * 
 */
package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.BranchStockBean;
import model.dao.BranchStockDAO;

@Repository
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
}

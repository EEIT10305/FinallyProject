package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.TransferBean;
import model.dao.TransferDAO;
@Repository
public class TransferDAOImpl implements TransferDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<TransferBean> selectAll() {
		return this.getSession().createQuery("FROM TransferBean", TransferBean.class).setMaxResults(50).list();
	}

	@Override
	public TransferBean selectById(int id) {
		return this.getSession().get(TransferBean.class, id);
	}

	@Override
	public TransferBean insert(TransferBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(TransferBean bean) {
		if (bean != null) {
			TransferBean temp = this.getSession().get(TransferBean.class, bean.getTransferid());
			if (temp != null) {
				try {
					temp.setDate(bean.getDate());
					temp.setProid(bean.getProid());
					temp.setAmount(bean.getAmount());
					temp.setBranchBeanin(bean.getBranchBeanin());
					temp.setBranchBeanout(bean.getBranchBeanout());
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

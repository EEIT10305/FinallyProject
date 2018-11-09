package model.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MemberBean;
import model.bean.OrderDetailBean;
import model.dao.OrderDetailDAO;
@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {
	@Autowired 
	private SessionFactory sessionFactory;
	
	private Integer memberid = null;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<OrderDetailBean> selectAll() {
		return this.getSession().createQuery("FROM OrderDetailBean", OrderDetailBean.class).list();
	}
	@Override
	public List<OrderDetailBean> selectAllByOrderId(Integer OrderId) {
		return this.getSession().createQuery("FROM OrderDetailBean where orderid=:OrderId", OrderDetailBean.class).setParameter("OrderId", OrderId).list();
	}
    
	@Override
	public List<Map<String,Object>> countSoldPro() {
//		Query list = this.getSession().createQuery("SELECT new map(proid,SUM(amount)) FROM OrderDetailBean GROUP BY proid").setMaxResults(50);
		List<Map<String,Object>> map =this.getSession().createQuery("SELECT new Map(proid as pro,SUM(amount) as sum) FROM OrderDetailBean GROUP BY proid").list();
		return map;
	}

	@Override
	public OrderDetailBean selectById(int id) {
		return this.getSession().get(OrderDetailBean.class, id);
	}
	@Override
	public List<OrderDetailBean> selectByOrderId(Integer OrderId) {
		String hql="from OrderDetailBean where orderid=:OrderId";
		return this.getSession().createQuery(hql,OrderDetailBean.class).setParameter("OrderId", OrderId).getResultList();
	}

	@Override
	public OrderDetailBean insert(OrderDetailBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(OrderDetailBean bean) {
		if (bean != null) {
			OrderDetailBean temp = this.getSession().get(OrderDetailBean.class, bean.getOrder_detail_id());
			if (temp != null) {
				try {
					temp.setOrderid(bean.getOrderid());
					temp.setProid(bean.getProid());
					temp.setBrand(bean.getBrand());
					temp.setCategory(bean.getCategory());
					temp.setModel(bean.getModel());
					temp.setAmount(bean.getAmount());
					temp.setPrice(bean.getPrice());
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
	public Integer getMemberId() {
		return memberid;
	}

	@Override
	public void setMemberId(Integer memberid) {
		this.memberid = memberid;
		
	}

	@Override
	public MemberBean selectMemberIdByEmail(String email) {
		return null;
	}

}

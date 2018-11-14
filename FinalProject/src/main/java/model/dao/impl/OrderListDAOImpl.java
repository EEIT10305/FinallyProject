package model.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MemberBean;
import model.bean.OrderListBean;
import model.dao.OrderListDAO;
@Repository
public class OrderListDAOImpl implements OrderListDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Integer memberid = null;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<OrderListBean> selectAll() {
		return this.getSession().createQuery("FROM OrderListBean",OrderListBean.class).setMaxResults(50).list();
	}
	@Override
	public List<OrderListBean> selectAllByTime(String Time) {
		return this.getSession().createQuery("FROM OrderListBean where dat=:Time",OrderListBean.class).setParameter("Time", Time).list();
	}

	@Override
	public OrderListBean selectById(int id) {
		return this.getSession().get(OrderListBean.class, id);
	}
	@Override
	public MemberBean selectMemberIdByEmail(String email) {
		String hql="FROM MemberBean where email=:email";
		return this.getSession().createQuery(hql,MemberBean.class).setParameter("email", email).getSingleResult();
	}

	@Override
	public OrderListBean insert(OrderListBean bean) {
		if(bean!=null) {
				this.getSession().save(bean);
				return bean;
		}else {
			return null;
		}
	}

	@Override
	public boolean update(OrderListBean bean) {
		if(bean!=null) {
			OrderListBean temp = this.getSession().get(OrderListBean.class, bean.getOrderid());
			if(temp!=null) {
				temp.setDat(bean.getDat());
				temp.setAddres(bean.getAddres());
				temp.setMemberid(bean.getMemberid());
				temp.setTotal(bean.getTotal());
				temp.setShipping(bean.getShipping());
				temp.setStatu(bean.getStatu());
				temp.setDat(bean.getDat());
				this.getSession().flush();
				return true;
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
	public boolean updateOrderStatusByOrderId(int orderid) {
		String hql = "from OrderListBean where orderid=: orderid";
		this.getSession().get(OrderListBean.class, orderid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("orderid", orderid).getSingleResult();
		orderListBean.setStatu("pay");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public boolean updateOrderArriveByOrderId(int orderid) {
		String hql = "from OrderListBean where orderid=: orderid";
		this.getSession().get(OrderListBean.class, orderid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("orderid", orderid).getSingleResult();
		orderListBean.setArrive("arrived");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public boolean updateOrderStatusByMemberId(int memberid) {
		String hql = "from OrderListBean where memberid=: memberid";
		this.getSession().get(OrderListBean.class, memberid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("memberid", memberid).getSingleResult();
		orderListBean.setStatu("pay");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public boolean updateOrderArriveByMemberId(int memberid) {
		String hql = "from OrderListBean where memberid=: memberid";
		this.getSession().get(OrderListBean.class, memberid);
		OrderListBean orderListBean= (OrderListBean) this.getSession().
				createQuery(hql).setParameter("memberid", memberid).getSingleResult();
		orderListBean.setArrive("arrived");
		this.getSession().update(orderListBean);
		return true;
	}

	@Override
	public List<OrderListBean> selectOrderListByMemberDate(String dateStart, String dateEnd, Integer memberId) {
		String hql = "FROM OrderListBean where date between :dateStart and :dateEnd and memberid=:memberid ORDER BY date DESC";
		
		return this.getSession().createQuery(hql, OrderListBean.class).setParameter("dateStart", dateStart).setParameter("dateEnd", dateEnd).setParameter("memberid", memberId).list();
	}

	@Override
	public List<OrderListBean> selectAllMemberOrderListByDateStatu(String dateStart, String dateEnd, String statu) {
		String hql = "FROM OrderListBean where date between :dateStart and :dateEnd and statu=:statu ORDER BY date DESC";
		
//		       CriteriaBuilder builder = this.getSession().getCriteriaBuilder() ; 
//		       CriteriaQuery<OrderListBean> query = builder.createQuery(OrderListBean.class) ; 
//		       Root<OrderListBean> classgo = query.from(OrderListBean.class) ; 
//		       
//		       query.orderBy(builder.desc(classgo.get("date"))) ; 
//		       
//		       query.select(classgo).where(builder.between(classgo.get("date"), dateStart, dateEnd)) ; 
//		       List<OrderListBean> rrr = this.getSession().createQuery(query).getResultList() ; 
		
		return this.getSession().createQuery(hql, OrderListBean.class).setParameter("dateStart", dateStart).setParameter("dateEnd", dateEnd).setParameter("statu", statu).list();
//		               return rrr ; 
		               
	}
	
	
	
}

package model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import misc.SpringJavaConfiguration;
import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.MemberBean;
import model.dao.CartDetailDAO;

@Repository
public class CartDetailDAOImpl implements CartDetailDAO{
	@Autowired
	private SessionFactory sessionFactory;

	//private Integer memberid = null;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionfactroy=(SessionFactory) ctx.getBean("sessionFactory");
		sessionfactroy.getCurrentSession().beginTransaction();
		CartDetailDAOImpl cartDetailDAOImpl= (CartDetailDAOImpl) ctx.getBean("cartDetailDAOImpl");
//		List<CartDetailBean> aa = cartDetailDAOImpl.selectbycartId(19);
//		System.out.println(aa);
		Boolean selects = cartDetailDAOImpl.deletebycartId(27);
		System.out.println(selects);
		sessionfactroy.getCurrentSession().getTransaction().commit();
		sessionfactroy.close();
	}

	@Override
	public List<CartDetailBean> selectAll() {
		return this.getSession().createQuery("FROM CartDetailBean", CartDetailBean.class).setMaxResults(50).list();
	}
	@Override
	public List<CartDetailBean> selectAllByCartId(Integer cartid) {
		String hql="FROM CartDetailBean where cartid=:cartid";
		return this.getSession().createQuery(hql, CartDetailBean.class).setParameter("cartid", cartid).getResultList();
	}

	@Override
	public CartDetailBean selectById(int id) {
		//String hql = "FROM CartDetailBean Where cartid=:cartid";等同下方 get與load方法只有主要鍵才可以使用		
		return this.getSession().get(CartDetailBean.class, id);
	}

	@Override
	public CartDetailBean insert(CartDetailBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(CartDetailBean bean) {
		if (bean != null) {
			CartDetailBean temp = this.getSession().get(CartDetailBean.class, bean.getId());
			if (temp != null) {
				try {
					temp.setCartid(bean.getCartid());
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

//	@Override
//	public boolean deletebycartId(Integer cartid) {
//	
//		String hql = "FROM CartDetailBean where cartid=: cartid";
//		List<CartDetailBean> cdb = this.getSession()
//				.createQuery(hql,CartDetailBean.class)
//				.setParameter("cartid", cartid).getResultList();
//		for(int x=0;x<cdb.size();x++) {
//			this.getSession().delete(cdb.get(x));			//如果是多項東西的泛型必須用迴圈把每一個bean給分別取出來，程式才知道要刪除的是一個bean物件，而非
//		}
//		return true;
//	}

	@Override
	public MemberBean getMemberId(int memberId) {
	
	//	MemberBean mb = new MemberBean();
	//	this.getSession().get(MemberBean.class, memberId);
		return this.getSession().get(MemberBean.class, memberId);
	}

	@Override
	public List<CartDetailBean> selectbycartId(int cartid) {
		String hql = "FROM CartDetailBean Where cartid=:cartid";
		List<CartDetailBean>list = this.getSession().
		createQuery(hql).setParameter("cartid", cartid).getResultList();
		return list ; 
	}

	@Override
	public boolean deletebycartId(Integer cartid) {
		String hql = "FROM CartDetailBean where cartid=: cartid";
//		CartDetailBean cdb = this.getSession().createQuery(hql,CartDetailBean.class).setParameter("cartid", cartid).getSingleResult();
//		this.getSession().delete(cdb);
		List<CartDetailBean> cdb = this.getSession()
				.createQuery(hql,CartDetailBean.class)
				.setParameter("cartid", cartid).getResultList();
		for(int x=0;x<cdb.size();x++) {
			this.getSession().delete(cdb.get(x));			//如果是多項東西的泛型必須用迴圈把每一個bean給分別取出來，程式才知道要刪除的是一個bean物件，而非
		}
		return true;
	}

	@Override
	public boolean checkProductisAlive(int proid) {
		boolean dup = false ;
		String hql = "FROM CartDetailBean Where proid=:proid";
		List<CartBean>list = this.getSession().
		createQuery(hql).setParameter("proid", proid).getResultList();
		if(list.size()>0) {
			dup = true ;
		}
		return dup ; 
	}

	@Override
	public CartDetailBean selectByProductId(int proid) {
		String hql = "FROM CartDetailBean Where proid=:proid";
		CartDetailBean cartDetailBean = (CartDetailBean) this.getSession().
		createQuery(hql).setParameter("proid", proid).getSingleResult();
		return cartDetailBean;
		
	}
	
	
	




}

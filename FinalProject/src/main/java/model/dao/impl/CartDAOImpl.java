package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import misc.SpringJavaConfiguration;
import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.MemberBean;
import model.bean.ProductBean;
import model.service.CartDAO;

@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProductDAOImpl productDAOImpl;
	
	public CartDAOImpl() {}

	Integer memberid = null;
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
		SessionFactory sessionfactroy=(SessionFactory) ctx.getBean("sessionFactory");
		sessionfactroy.getCurrentSession().beginTransaction();
		CartDAOImpl cartDAOImpl=(CartDAOImpl) ctx.getBean("cartDAOImpl");
		Boolean selects = cartDAOImpl.updatestatus(3);
		sessionfactroy.getCurrentSession().getTransaction().commit();
		System.out.println(selects);
		sessionfactroy.close();
	}

	@Override
	public List<CartBean> selectAll() {
		return this.getSession().createQuery("FROM CartBean",CartBean.class).setMaxResults(50).list();
	}

	@Override
	public CartBean selectById(int cartid) {
		return this.getSession().get(CartBean.class, cartid);
	}

	
	
	
	@Override
	public CartBean insert(CartBean bean) {
		if(bean!=null) {
			if(true) {
				System.out.println(bean.getCartid());
				this.getSession().save(bean);
				return bean;
			}			
		}
		return null;
	}

	@Override
	public boolean update(CartBean bean) {
		if(bean!=null) {
			CartBean temp = this.getSession().get(CartBean.class, bean.getCartid());
			if(temp!=null) {
				temp.setCartid(bean.getCartid());
				temp.setMemberid(bean.getMemberid());
				temp.setDate(bean.getDate());
				temp.setStatus(bean.getStatus());
				this.getSession().flush();
				return true;
			}			
		}
		return false;
	}

	@Override
	public boolean delete(CartBean bean) {
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public MemberBean getMemberId() {
		return this.getSession().get(MemberBean.class, memberid);
	}



	@Override
	public void setMemberId(int memberId) {
		
	}
	@Override
	public boolean checkMember(int memberid) {
		boolean dup = false ;
		String hql = "FROM CartBean Where memberid=:memberid";
		List<CartBean>list = this.getSession().
		createQuery(hql).setParameter("memberid", memberid).getResultList();
		if(list.size()>0) {
			dup = true ;
		}
		return dup ; 
	}

	@Override
	public void getCartId() {
		
		this.getSession().get(CartBean.class, memberid);
	}

	@Override
	public CartBean selectByMemberId(int memberid) {
		String hql = "FROM CartBean Where memberid=:memberid";	
		return this.getSession().createQuery(hql,CartBean.class).setParameter("memberid", memberid).getSingleResult();
		
	}
	@Override
	public ProductBean insertmodelfromProduct(String model) {
		String hql = "from ProductBean where model=: model";
		ProductBean productbean = productDAOImpl.getSession().
		createQuery(hql,ProductBean.class).setParameter("model", model).getSingleResult();  //利用model這個條件去得到productbean
		return productbean ;
	//	return null;

	}

	@Override
	public boolean deletebyCartId(int cartid) {

		CartBean cb = this.getSession().get(CartBean.class,cartid);
		this.getSession().delete(cb);
		return true;
	}
	
	@Override
	public boolean updatestatus(int cartid) {
		String hql = "from CartBean where cartid=: cartid";
		this.getSession().get(CartBean.class, cartid);
		CartBean cartBean= (CartBean) this.getSession().
				createQuery(hql).setParameter("cartid", cartid).getSingleResult();
		cartBean.setStatus("pay");
		this.getSession().update(cartBean);
		return false;
	}
	@Override
	public List<CartBean> selectByMemberIdList(Integer memberId) {
		String hql = "FROM CartBean Where memberid=:memberid";	
	return this.getSession().createQuery(hql,CartBean.class).setParameter("memberid", memberId).list();
	}


}

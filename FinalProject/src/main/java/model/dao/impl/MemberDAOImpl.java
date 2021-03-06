package model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MemberBean;
import model.dao.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MemberDAOImpl() {
	}

	@Override
	public List<MemberBean> selectAll() {// 查詢全部會員資料
		return this.getSession().createQuery("FROM MemberBean", MemberBean.class).list();
	}

	@Override
	public MemberBean selectById(Integer memberId) {// 查詢單筆會員資料
		return this.getSession().get(MemberBean.class, memberId);
	}

	@Override
	public MemberBean insert(MemberBean bean) {// 新增一筆會員資料
		if (bean != null) {
				System.out.println(bean.getMemberid());
				this.getSession().save(bean);
				return bean;
			
		}
		return null;
	}

	@Override
	public boolean update(MemberBean bean) {// 更新一筆會員資料
		if (bean != null) {
			MemberBean temp = this.getSession().get(MemberBean.class, bean.getMemberid());
			if (temp != null) {
				temp.setmembername(bean.getmembername());
				temp.setEmail(bean.getEmail());
				temp.setmemberpassword(bean.getmemberpassword());
				temp.setPermission(bean.getPermission());
				temp.setmemberaddress(bean.getmemberaddress());
				temp.setPhone(bean.getPhone());
				temp.setGender(bean.getGender());
				return true;
			}
		}
		return false;
	}

	@Override
	public MemberBean selectByEmail(String email) {// 查詢此email是否有人用過
		MemberBean mb = null;
		String hql = "FROM MemberBean WHERE email = :email ";
//		Session session = getSession();
//		Query query = session.createQuery(hql);
//		query = query.setParameter("email", email);
		try {
			mb = this.getSession().createQuery(hql,MemberBean.class).setParameter("email", email).getSingleResult();

		} catch (Exception ex) {// NoResultException
			mb = null;
		}
		return mb;
	}

	@Override
	public MemberBean checkEmailPwd(String email, String password) {// 判斷使用者登入的帳號密碼是否正確
		MemberBean mb = null;
		String hql = "FROM MemberBean WHERE email = :email and memberpassword = :password";
		Session session = getSession();
		try {
			mb = (MemberBean) session.createQuery(hql)
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		} catch (Exception ex) {// NoResultException
			mb = null;
		}
		return mb;
	}

	@Override
	public List<MemberBean> checkEmailList(String email) {
		return this.getSession().createQuery("FROM MemberBean WHERE email =:email", MemberBean.class).setParameter("email", email).list();
	}

}

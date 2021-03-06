package model.dao.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.dao.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
	private SessionFactory sessionFactory;
    
    private Session getSession() {
    	return sessionFactory.getCurrentSession();
    }
	@Override
	public List<CategoryBean> selectAll() {
		return this.getSession().createQuery("FROM CategoryBean",CategoryBean.class).setMaxResults(50).list();
	}

	@Override
	public CategoryBean selectById(int id) {
		return this.getSession().get(CategoryBean.class, id);
	}

	@Override
	public List<Object> selectSubTable(String hql) {
		return this.getSession().createQuery(hql).list();
	}
	@Override
	public CategoryBean insert(CategoryBean bean) {
		if(bean!=null) {
			if(true) {
//				System.out.println(bean.getCategoryid());
				this.getSession().save(bean);
				return bean;
			}			
		}
		return null;
	}

	@Override
	public boolean update(CategoryBean bean) {
		if(bean!=null) {
			CategoryBean temp = this.getSession().get(CategoryBean.class, bean.getCategoryid());
			if(temp!=null) {
				temp.setCategory(bean.getCategory());
				temp.setCode(bean.getCode());
				return true;
			}			
		}
		return false;
	}
	@Override
	public CategoryBean getCategoryBeanBycategorycode(String category) {
		//得到CategoryBean是為了知道categoryid
		String hql ="From CategoryBean where category=:category";
		return this.getSession().createQuery(hql,CategoryBean.class).setParameter("category", category).getSingleResult();
	}
}

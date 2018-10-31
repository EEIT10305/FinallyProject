package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.MbBean;
import model.bean.ProductBean;
import model.bean.RamBean;
import model.dao.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<ProductBean> selectAll() {
		return this.getSession().createQuery("FROM ProductBean", ProductBean.class).setMaxResults(50).list();
	}
	@Override
	public List<CategoryBean> selectAllCategory() {
		String hql="From CategoryBean";
		return this.getSession().createQuery(hql, CategoryBean.class).getResultList();
	}
	@Override
	public CategoryBean CategoryTurnCategoryid(String Category) {
		String hql="From CategoryBean where Category=:Category";
		return this.getSession().createQuery(hql, CategoryBean.class).setParameter("Category", Category).getSingleResult();
	}

	@Override
	public ProductBean selectById(int id) {
		return this.getSession().get(ProductBean.class, id);
	}
	@Override
	public List<ProductBean> selectByCategory(int Categoryid) {
		String hql ="From ProductBean where Categoryid= :Categoryid";
		
		return this.getSession().createQuery(hql,ProductBean.class).setParameter("Categoryid", Categoryid).getResultList();	
	}
	@Override
	public List<ProductBean> selectNeedProduct() {
		return this.getSession().createQuery("FROM ProductBean Where hot >=: hot and statu = 'on' Order By hot", ProductBean.class)
				.setParameter("hot", 0).list();
	}
	
	
	@Override
	public List<ProductBean> selectNeedProduct2() {
		return this.getSession().createQuery("FROM ProductBean Where hot < : hot and statu = 'on' ", ProductBean.class)
				.setParameter("hot", 0).list();
	}
	
	

	@Override
	public List<ProductBean> selectUpProduct() {
		String hql ="From ProductBean where statu='off' and hot=-1";
		return this.getSession().createQuery(hql,ProductBean.class).list();
	}

	public BrandBean BrandidTurnBrand(int Brandid) {
		String hql ="From BrandBean where Brandid= :Brandid";
		
		return this.getSession().createQuery(hql,BrandBean.class).setParameter("Brandid", Brandid).getSingleResult();	
	}
	@Override
	public MbBean checkByMb(String Mbmodel) {
		String hql ="From MbBean where Model= :Mbmodel";
		
		return this.getSession().createQuery(hql,MbBean.class).setParameter("Mbmodel", Mbmodel).getSingleResult();	
	}
	@Override
	public List<RamBean> checkRamByDDR(String DDR) {
		String hql ="From RamBean where ddr= :DDR";
		return this.getSession().createQuery(hql,RamBean.class).setParameter("DDR", DDR).getResultList();
	}
	@Override
	public List<CpuBean> checkCpuByFeet(String Feet) {
		String hql ="From CpuBean where feet= :Feet";
		return this.getSession().createQuery(hql,CpuBean.class).setParameter("Feet", Feet).getResultList();
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean update(ProductBean bean) {
		if (bean != null) {
			ProductBean temp = this.getSession().get(ProductBean.class, bean.getProid());
			if (temp != null) {
				try {
					temp.setBrandid(bean.getBrandid());
					temp.setCategoryid(bean.getCategoryid());
					temp.setModel(bean.getModel());
					temp.setPrice(bean.getPrice());
					temp.setPicture(bean.getPicture());
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
	@Override
	public boolean updateHotSeq(Integer count,Integer id) {
		ProductBean temp = this.getSession().get(ProductBean.class, id);
		if(temp!=null) {
			temp.setHot(count);
		}
		
		return false;
	}
	@Override
	public boolean updateNoHot(Integer id) {
		ProductBean temp = this.getSession().get(ProductBean.class, id);
		if(temp!=null) {
			temp.setHot(-1);
		}
		
		return false;
	}

}

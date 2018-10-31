package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.MbBean;
import model.bean.PinginBean;
import model.bean.PinginDetailBean;
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
		String hql = "From CategoryBean";
		return this.getSession().createQuery(hql, CategoryBean.class).getResultList();
	}

	@Override
	public CategoryBean CategoryTurnCategoryid(String Category) {
		String hql = "From CategoryBean where Category=:Category";
		return this.getSession().createQuery(hql, CategoryBean.class).setParameter("Category", Category)
				.getSingleResult();
	}

	@Override
	public ProductBean selectById(int id) {
		return this.getSession().get(ProductBean.class, id);
	}

	@Override
	public List<ProductBean> selectByCategory(int Categoryid) {
		String hql = "From ProductBean where Categoryid= :Categoryid";

		return this.getSession().createQuery(hql, ProductBean.class).setParameter("Categoryid", Categoryid)
				.getResultList();
	}

	@Override
	public List<PinginDetailBean> showPinginByCategoryAndBrand(String Category, String Brand) {
		String hql = "From PinginDetailBean where Category= :Category and Brand=:Brand";

		return this.getSession().createQuery(hql, PinginDetailBean.class).setParameter("Category", Category)
				.setParameter("Brand", Brand).getResultList();
	}
	@Override
	public List<PinginDetailBean> showPinginByImg(String Pinginname) {
		String hql = "From PinginDetailBean where name= :Pinginname";

		return this.getSession().createQuery(hql, PinginDetailBean.class).setParameter("Pinginname", Pinginname)
				.getResultList();
	}

	@Override
	public PinginBean showPingin(String name) {
		String hql = "From PinginBean where name= :name";

		return this.getSession().createQuery(hql, PinginBean.class).setParameter("name", name).getSingleResult();
	}

	@Override
	public PinginBean showPinginByPrice(String name, Integer Price) {
		String hql = "From PinginBean where name= :name and Price between :Price and (:Price+5000)";
		
	return this.getSession().createQuery(hql, PinginBean.class).setParameter("name", name).setParameter("Price", Price).getSingleResult();
	}

	@Override
	public BrandBean BrandidTurnBrand(int Brandid) {
		String hql = "From BrandBean where Brandid= :Brandid";

		return this.getSession().createQuery(hql, BrandBean.class).setParameter("Brandid", Brandid).getSingleResult();
	}

	@Override
	public MbBean checkByMb(String Mbmodel) {
		String hql = "From MbBean where Model= :Mbmodel";

		return this.getSession().createQuery(hql, MbBean.class).setParameter("Mbmodel", Mbmodel).getSingleResult();
	}

	@Override
	public List<RamBean> checkRamByDDR(String DDR) {
		String hql = "From RamBean where ddr= :DDR";
		return this.getSession().createQuery(hql, RamBean.class).setParameter("DDR", DDR).getResultList();
	}

	@Override
	public List<CpuBean> checkCpuByFeet(String Feet) {
		String hql = "From CpuBean where feet= :Feet";
		return this.getSession().createQuery(hql, CpuBean.class).setParameter("Feet", Feet).getResultList();
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

}

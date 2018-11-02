package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import model.bean.BrandBean;
import model.bean.CabinetBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.MbBean;
import model.bean.PinginBean;
import model.bean.PinginDetailBean;
import model.bean.PowerSupplierBean;
import model.bean.ProductBean;
import model.bean.RamBean;
import model.bean.StorageBean;
import model.bean.VgaBean;
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
	public List<MbBean> selectMb() {
		String hql = "From MbBean";

		return this.getSession().createQuery(hql, MbBean.class).getResultList();
	}
	@Override
	public List<CpuBean> selectCpu() {
		String hql = "From CpuBean";

		return this.getSession().createQuery(hql, CpuBean.class).getResultList();
	}
	@Override
	public List<RamBean> selectRam() {
		String hql = "From RamBean";

		return this.getSession().createQuery(hql, RamBean.class).getResultList();
	}
	@Override
	public List<VgaBean> selectVga() {
		String hql = "From VgaBean";

		return this.getSession().createQuery(hql, VgaBean.class).getResultList();
	}
	@Override
	public List<StorageBean> selectStorage() {
		String hql = "From StorageBean";

		return this.getSession().createQuery(hql, StorageBean.class).getResultList();
	}
	@Override
	public List<CabinetBean> selectCabinet() {
		String hql = "From CabinetBean";

		return this.getSession().createQuery(hql, CabinetBean.class).getResultList();
	}
	@Override
	public List<PowerSupplierBean> selectPowerSupplier() {
		String hql = "From PowerSupplierBean";

		return this.getSession().createQuery(hql, PowerSupplierBean.class).getResultList();
	}
	@Override
	public List<PinginBean> showAllProductImg() {
		String hql = "From PinginBean";

		return this.getSession().createQuery(hql, PinginBean.class).getResultList();
	}
	@Override
	public CpuBean showCpuPower(String Cpumodel) {
		String hql = "From CpuBean where model=:Cpumodel";

		return this.getSession().createQuery(hql, CpuBean.class).setParameter("Cpumodel", Cpumodel).getSingleResult();
	}
	@Override
	public RamBean showRamPower(String Rammodel) {
		String hql = "From RamBean where model=:Rammodel";

		return this.getSession().createQuery(hql, RamBean.class).setParameter("Rammodel", Rammodel).getSingleResult();
	}
	@Override
	public MbBean showMbPower(String Mbmodel) {
		String hql = "From MbBean where model=:Mbmodel";

		return this.getSession().createQuery(hql, MbBean.class).setParameter("Mbmodel", Mbmodel).getSingleResult();
	}
	@Override
	public VgaBean showVgaPower(String Vgamodel) {
		String hql = "From VgaBean where model=:Vgamodel";

		return this.getSession().createQuery(hql, VgaBean.class).setParameter("Vgamodel", Vgamodel).getSingleResult();
	}
	@Override
	public StorageBean showStoragePower(String Storagemodel) {
		String hql = "From StorageBean where model=:Storagemodel";

		return this.getSession().createQuery(hql, StorageBean.class).setParameter("Storagemodel", Storagemodel).getSingleResult();
	}
	@Override
	public CabinetBean showCabinetPower(String Cabinetmodel) {
		String hql = "From CabinetBean where model=:Cabinetmodel";

		return this.getSession().createQuery(hql, CabinetBean.class).setParameter("Cabinetmodel", Cabinetmodel).getSingleResult();
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

	@Override
	public List<ProductBean> selectProductExcludeDown() {
		String hql ="From ProductBean where hot >= -1";
		return this.getSession().createQuery(hql,ProductBean.class).list();
	}

	@Override
	public ProductBean selectProductPrice(String model) {
		String hql ="From ProductBean where model=:Mbmodel";
		return this.getSession().createQuery(hql,ProductBean.class).setParameter("Mbmodel", model).getSingleResult();
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
		String hql = "From RamBean where ddr= :DDR order by proid";
		return this.getSession().createQuery(hql, RamBean.class).setParameter("DDR", DDR).getResultList();
	}

	@Override
	public List<CpuBean> checkCpuByFeet(String Feet) {
		String hql = "From CpuBean where feet= :Feet order by proid";
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

	
	
	
	
	@Override
	public List<ProductBean> selectByCatBraPri(Integer categoryid, Integer brandid, Integer price){
		String hql = "from ProductBean where categoryid= : categoryid and brandid = :brandid and price between :price and :price+5000";
		return this.getSession().createQuery(hql,ProductBean.class)
				.setParameter("categoryid", categoryid).setParameter("brandid", brandid).setParameter("price",price).getResultList();		
	}
    
	@Override
	public List<ProductBean> selectByCatBraPriBigger(Integer categoryid, Integer brandid, Integer price){
		String hql = "from ProductBean where categoryid= : categoryid and brandid = :brandid and price > :price";
		return this.getSession().createQuery(hql,ProductBean.class)
				.setParameter("categoryid", categoryid).setParameter("brandid", brandid).setParameter("price",price).getResultList();		
	}
	
	@Override
	public List<ProductBean> selectByCatBra(Integer categoryid, Integer brandid){
		String hql = "from ProductBean where categoryid= : categoryid and brandid = :brandid";
		return this.getSession().createQuery(hql,ProductBean.class)
				.setParameter("categoryid", categoryid).setParameter("brandid", brandid).getResultList();		
	}
	
	@Override
	public List<ProductBean> selectByCatPri(Integer categoryid, Integer price){
		String hql = "from ProductBean where categoryid= : categoryid and price between :price and :price+5000";
		return this.getSession().createQuery(hql,ProductBean.class)
				.setParameter("categoryid", categoryid).setParameter("price",price).getResultList();		
	}
    
	@Override
	public List<ProductBean> selectByCatPriBigger(Integer categoryid, Integer price){
		String hql = "from ProductBean where categoryid= : categoryid and price > :price";
		return this.getSession().createQuery(hql,ProductBean.class)
				.setParameter("categoryid", categoryid).setParameter("price",price).getResultList();		
	}
	
	@Override
	public List<ProductBean> selectByCat(Integer categoryid){
		String hql = "from ProductBean where categoryid= : categoryid ";
		return this.getSession().createQuery(hql,ProductBean.class)
				.setParameter("categoryid", categoryid).getResultList();		
	}
	
	@Override
	public List<ProductBean> selectByinput(String searchspace) {
		String hql ="From ProductBean where model like :input";
		return this.getSession().createQuery(hql,ProductBean.class).setParameter("input", "%" + searchspace + "%").getResultList();
	}
}

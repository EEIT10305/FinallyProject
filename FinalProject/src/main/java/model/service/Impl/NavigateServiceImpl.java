package model.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.ProductBean;
import model.dao.BrandDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.service.NavigateService;

@Service
@Transactional
public class NavigateServiceImpl implements NavigateService {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private BrandDAO brandDAO;
	@Autowired
	private ProductDAO productDAO;

	// 分類標籤內顯示所有分類
	@Override
	public List<CategoryBean> selectAllCategory() {
		return categoryDAO.selectAll();
	}

	// 按下類別標籤後顯示出對應的品牌
	@Override
	public Set<BrandBean> selectBrand(String category) {
		// 得到CategoryBean是為了知道categoryid
//		String hql ="From CategoryBean where category=:category";
//		CategoryBean categoryBean=this.getSession().createQuery(hql,CategoryBean.class).setParameter("category", category).getSingleResult();
		CategoryBean categoryBean = categoryDAO.getCategoryBeanBycategorycode(category);

		Set<BrandBean> brandBeans = new HashSet<BrandBean>();
		for (int x = 0; x < productDAO.selectByCategory(categoryBean.getCategoryid()).size(); x++) { // x<productDAO....回傳List<ProductBean>的size(有幾個ProductBean)
			brandBeans.add(productDAO.selectByCategory(categoryBean.getCategoryid()).get(x).getBrandBean());
		} // 取得List<ProductBean> 取得第x的ProductBean
		return brandBeans;
	}

	// 按下分類標籤即時顯示商品 目前沒用到
	@Override
	public List<ProductBean> showProductByCategory(String category) {
		CategoryBean categoryBean = categoryDAO.getCategoryBeanBycategorycode(category);
		List<ProductBean> productBeans = productDAO.selectByCategory(categoryBean.getCategoryid());
		return productBeans;
	}

	// 按下搜尋時 searchcspace == null
	// 分類 品牌 價格 都有選
	@Override
	public List<ProductBean> selectByCatBraPri(String category, String brand, Integer price) {
		CategoryBean categoryBean = categoryDAO.getCategoryBeanBycategorycode(category);
		BrandBean brandBean = brandDAO.getBrandBeanBybrand(brand);
		if (price == 20000) {// 20000↑
			return productDAO.selectByCatBraPriBigger(categoryBean.getCategoryid(), brandBean.getBrandid(), price);
		}
		return productDAO.selectByCatBraPri(categoryBean.getCategoryid(), brandBean.getBrandid(), price);
	}

	// 分類 品牌 有選
	@Override
	public List<ProductBean> selectByCatBra(String category, String brand) {
		CategoryBean categoryBean = categoryDAO.getCategoryBeanBycategorycode(category);
		BrandBean brandBean = brandDAO.getBrandBeanBybrand(brand);
		return productDAO.selectByCatBra(categoryBean.getCategoryid(), brandBean.getBrandid());
	}

	// 分類 價格 有選
	@Override
	public List<ProductBean> selectByCatPri(String category, Integer price) {
		CategoryBean categoryBean = categoryDAO.getCategoryBeanBycategorycode(category);
		if (price == 20000) {
			return productDAO.selectByCatPriBigger(categoryBean.getCategoryid(), price);
		}
		return productDAO.selectByCatPri(categoryBean.getCategoryid(), price);
	}

	// 只選分類
	@Override
	public List<ProductBean> selectByCat(String category) {
		CategoryBean categoryBean = categoryDAO.getCategoryBeanBycategorycode(category);
		return productDAO.selectByCat(categoryBean.getCategoryid());
	}

	// 使用搜尋欄
	@Override
	public List<ProductBean> selectByinput(String searchspace) {
//		System.out.println("=======================================");
//		System.out.println("到service了");
//		System.out.println(searchspace);
//		System.out.println("=======================================");
		return productDAO.selectByinput(searchspace);
	}
}

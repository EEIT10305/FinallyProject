package model.service.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.BrandBean;
import model.bean.CategoryBean;
import model.bean.CpuBean;
import model.bean.MbBean;
import model.bean.ProductBean;
import model.bean.RamBean;
import model.dao.MbDAO;
import model.dao.ProductDAO;
import model.service.SelectProductForCustomizedService;
@Service
public class SelectProductForCustomizedServiceImpl implements SelectProductForCustomizedService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private MbDAO mbDAO;
	@Override
	public List<ProductBean> selectMb() {
		return productDAO.selectByCategory(2);		
	}
	@Override
	public List<ProductBean> selectCpu() {
		return productDAO.selectByCategory(1);		
	}
	@Override
	public List<ProductBean> selectRam() {
		return productDAO.selectByCategory(3);		
	}
	@Override
	public List<ProductBean> selectVga() {
		return productDAO.selectByCategory(4);		
	}
	@Override
	public List<ProductBean> selectStorage() {
		
		return productDAO.selectByCategory(5);		
	}
	@Override
	public List<ProductBean> selectCabinet() {
		return productDAO.selectByCategory(6);		
	}
	@Override
	public List<ProductBean> selectPowerSupplier() {
		return productDAO.selectByCategory(7);		
	}
	@Override
	public List<ProductBean> selectPingin() {
		return productDAO.selectByCategory(8);		
	}
	@Override
	public List<RamBean> checkRamInService(String Mbmodel) {
		MbBean mbBean=productDAO.checkByMb(Mbmodel);
		String DDR=mbBean.getDdr();
		
		return productDAO.checkRamByDDR(DDR);
		
	}
	@Override
	public List<CpuBean> checkCpuInService(String Mbmodel) {
		MbBean mbBean=productDAO.checkByMb(Mbmodel);
		String Feet=mbBean.getFeet();
		
		return productDAO.checkCpuByFeet(Feet);
		
	}
	@Override
	public List<CategoryBean> selectCategoryInService() {
		
		return productDAO.selectAllCategory();	
	}
	@Override
	public Set<BrandBean> selectBrandInService(String Category) {
		CategoryBean categoryBean=productDAO.CategoryTurnCategoryid(Category);
		List<ProductBean> list =productDAO.selectByCategory(categoryBean.getCategoryid());
		Set<BrandBean> set = new HashSet<>();
		for(int x=0;x<list.size();x++) {
			set.add(productDAO.BrandidTurnBrand(list.get(x).getBrandid()));
		}
		return set;
	}
}

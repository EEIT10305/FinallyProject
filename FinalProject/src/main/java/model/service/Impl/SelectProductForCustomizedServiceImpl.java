package model.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.BrandBean;
import model.bean.CabinetBean;
import model.bean.CartDetailBean;
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
import model.dao.CartDetailDAO;
import model.dao.MbDAO;
import model.dao.ProductDAO;
import model.service.SelectProductForCustomizedService;

@Service
@Transactional
public class SelectProductForCustomizedServiceImpl implements SelectProductForCustomizedService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private MbDAO mbDAO;
	@Autowired
	private CartDetailDAO cartDetailDAO;

	@Override
	public List<MbBean> selectMb() {
		return productDAO.selectMb();
	}

	@Override
	public List<CpuBean> selectCpu() {
		return productDAO.selectCpu();
	}

	@Override
	public List<RamBean> selectRam() {
		return productDAO.selectRam();
	}

	@Override
	public List<VgaBean> selectVga() {
		return productDAO.selectVga();
	}

	@Override
	public List<StorageBean> selectStorage() {

		return productDAO.selectStorage();
	}

	@Override
	public List<CabinetBean> selectCabinet() {
		return productDAO.selectCabinet();
	}

	@Override
	public List<PowerSupplierBean> selectPowerSupplier() {
		return productDAO.selectPowerSupplier();
	}

	@Override
	public List<ProductBean> selectPingin() {
		return productDAO.selectByCategory(8);
	}

	@Override
	public List<RamBean> checkRamInService(String Mbmodel) {
		MbBean mbBean = productDAO.checkByMb(Mbmodel);
		String DDR = mbBean.getDdr();

		return productDAO.checkRamByDDR(DDR);

	}

	@Override
	public List<CpuBean> checkCpuInService(String Mbmodel) {
		return productDAO.checkCpuByFeet(productDAO.checkByMb(Mbmodel).getFeet());
	}

	@Override
	public List<CategoryBean> selectCategoryInService() {

		return productDAO.selectAllCategory();
	}

	@Override
	public Set<BrandBean> selectBrandInService(String Category) {
		List<ProductBean> list = productDAO.selectByCategory(productDAO.CategoryTurnCategoryid(Category).getCategoryid());
		Set<BrandBean> set = new HashSet<>();
		for (int x = 0; x < list.size(); x++) {
			set.add(productDAO.BrandidTurnBrand(list.get(x).getBrandid()));
		}
		return set;
	}

	@Override
	public List<PinginBean> showProductByCategoryInService(String Categorymodel, String Brandmodel) {
		List<PinginDetailBean> listdetail = productDAO.showPinginByCategoryAndBrand(Categorymodel, Brandmodel);
		List<PinginBean> list = new ArrayList<PinginBean>();
		for (int x = 0; x < listdetail.size(); x++) {
			list.add(listdetail.get(x).getPinginBean());
		}
		return list;
	}
	@Override
	public List<PinginBean> showProductByPriceInService(String Categorymodel, String Brandmodel, Integer Pricemodel) {
		List<PinginDetailBean> listdetail = productDAO.showPinginByCategoryAndBrand(Categorymodel, Brandmodel);
		List<PinginBean> list = new ArrayList<PinginBean>();
		for (int x = 0; x < listdetail.size(); x++) {
			if (listdetail.get(x).getPinginBean().getPrice() > Pricemodel
					&& listdetail.get(x).getPinginBean().getPrice() < (Pricemodel + 5000)) {
				list.add(listdetail.get(x).getPinginBean());
			}
		}

		return list;
	}
	@Override
	public List<PinginDetailBean> showPinginDetailInService(String Pinginmodel) {
		
		return productDAO.showPinginByImg(Pinginmodel);
	}
	@Override
	public ProductBean showInitPriceInService(String model) {
		return productDAO.selectProductPrice(model);
	}
	@Override
	public ProductBean showCartDetailInService(String model,Integer CartId) {
		cartDetailDAO.insert(new CartDetailBean(null,1,CartId,productDAO.selectProductPrice(model).getProid()));
		return productDAO.selectProductPrice(model);
	}
	
	@Override
	public List<PinginBean> showAllProductImgInService() {
	
		return productDAO.showAllProductImg();
	}
	@Override
	public CpuBean showCpuPowerInService(String Cpumodel) {
		
		return productDAO.showCpuPower(Cpumodel);
	}
	@Override
	public RamBean showRamPowerInService(String Rammodel) {
			
			return productDAO.showRamPower(Rammodel);
		}
	@Override
	public MbBean showMbPowerInService(String Mbmodel) {
		
		return productDAO.showMbPower(Mbmodel);
	}
	@Override
	public VgaBean showVgaPowerInService(String Vgamodel) {
		
		return productDAO.showVgaPower(Vgamodel);
	}
	@Override
	public StorageBean showStoragePowerInService(String Storagemodel) {
		
		return productDAO.showStoragePower(Storagemodel);
	}
	@Override
	public CabinetBean showCabinetPowerInService(String Cabinetmodel) {
		
		return productDAO.showCabinetPower(Cabinetmodel);
	}
	@Override
	public List<PowerSupplierBean> showPowerSupplierByTotalPowerInService(Integer PowerModel) {
		
		return productDAO.showPowerSupplier(PowerModel);
	}
}

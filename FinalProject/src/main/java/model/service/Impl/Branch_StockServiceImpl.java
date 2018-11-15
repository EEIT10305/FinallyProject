package model.service.Impl;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BranchStockBean;
import model.bean.BrandBean;
import model.bean.ProductBean;
import model.bean.StaffBean;
import model.bean.TransferBean;
import model.dao.BranchStockDAO;
import model.dao.BrandDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.dao.TransferDAO;
import model.service.Branch_StockService;

@Service
@Transactional
public class Branch_StockServiceImpl implements Branch_StockService {

	@Autowired
	BranchStockDAO branchStockDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	BrandDAO brandDAO;

	@Autowired
	TransferDAO transferDAO;

	@Override
	public List<BranchStockBean> selectALL() {

		return branchStockDAO.selectAll();
	}

	@Override
	public BrandBean selectByBrand(String brand) {

		return brandDAO.getBrandBeanBybrand(brand);
	}

	@Override
	public BranchStockBean selectById(Integer improtid) {
		return branchStockDAO.selectById(improtid);

	}

	@Override
	public List<TransferBean> selectAll() {
		return transferDAO.selectAll();
	}

	@Override
	public List<TransferBean> selectLatestRecord(String date) {
		return transferDAO.selectLatestRecord(date);
	}

	@Override
	public List<BranchStockBean> selectByProID(Integer proid) {
		return branchStockDAO.selectByProId(proid);
	}

	@Override
	public List<BranchStockBean> searchResult() {
		List<BranchStockBean> result = new ArrayList<>();
		System.out.println("searchresult==========================================");
		List<BranchStockBean> branchStockBean = branchStockDAO.selectAll();
		for (int x = 0; x < branchStockBean.size(); x++) {
			System.out.println("forrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			branchStockBean.get(x).getBranch_stock_id();
			branchStockBean.get(x).getBranchBean().getShopname();
			branchStockBean.get(x).getAmount();
			branchStockBean.get(x).getProductBean().getBrandBean().getBrand();
			branchStockBean.get(x).getProductBean().getModel();
			branchStockBean.get(x).getProid();
			branchStockBean.get(x).getProductBean().getCategoryBean().getCategory();
			System.out.println("amount===============" + branchStockBean.get(x).getAmount());
			result.addAll(branchStockBean);
		}

		return result;
	}

	@Override
	public List<TransferBean> insertTransfer(Integer amountin, Integer branchidin, Integer branchidout, Integer proidin,
			HttpSession session) {
		StaffBean staff = (StaffBean) session.getAttribute("staffBean");

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd 'at' HH:mm:ss");
		String Date = dateFormat.format(date);

		System.out.println("Date in insert==============" + Date);
		TransferBean bean = new TransferBean();
		bean.setAmount(amountin);
		bean.setBranchidin(branchidin);
		bean.setBranchidout(branchidout);
		bean.setDate(Date);
		bean.setProid(proidin);
		System.out.println("staff id====================" + staff.getStaff_id());
		bean.setStaff_id(staff.getStaff_id());
	
		transferDAO.insert(bean);

		return null;
	}

	@Override
	public List<BranchStockBean> updateBranchStock(Integer branchidin, Integer branchidout, Integer amountin,
			Integer proidin) {

		List<BranchStockBean> result = new ArrayList<>();

		List<BranchStockBean> branchStockBean = branchStockDAO.selectAll();

		for (int x = 0; x < branchStockBean.size(); x++) {
			result.clear();
			branchStockBean.get(x).getBranch_stock_id();
			System.out.println("BranchStock id====================================="
					+ branchStockBean.get(x).getBranch_stock_id());
			int inAmount = branchStockBean.get(x).getAmount() - amountin;
			int outAmount = branchStockBean.get(x).getAmount() + amountin;

			if (branchStockBean.get(x).getBranchid() == branchidin & branchStockBean.get(x).getProid() == proidin) {
				System.out.println("amount in =====================" + branchStockBean.get(x).getAmount());

				System.out.println("proid in =======================" + proidin);
				System.out.println("inamount==========================" + inAmount);
				branchStockBean.get(x).setAmount(inAmount);

				branchStockDAO.updateList(branchStockBean, x);

			} else if (branchStockBean.get(x).getBranchid() == branchidout
					& branchStockBean.get(x).getProid() == proidin) {
				System.out.println("amount out ===============================" + branchStockBean.get(x).getAmount());

				System.out.println("branchidout=========================================" + branchidout);
				System.out.println("outamount=====================================" + outAmount);

				branchStockBean.get(x).setAmount(outAmount);
				branchStockDAO.updateList(branchStockBean, x);

			} else if (branchStockBean.get(x).getBranchid() == branchidout
					& branchStockBean.get(x).getProid() == null) {
				System.out.println("insertttttttttttttttttttttttttttttttttttttttttttttttttt");
				branchStockDAO.insertintoStock(inAmount, branchidout, proidin, "on");

			}

			result.addAll(branchStockBean);

		}

		return result;

	}


	@Override
	public List<BranchStockBean> selectByProModel(String promodel) {
		List<BranchStockBean> result = new ArrayList<>();
		List<BranchStockBean> result2 = new ArrayList<>();
 		List<ProductBean> product = productDAO.selectByModel(promodel);
		for (int x = 0; x < product.size(); x++) {
			List<BranchStockBean> branch = branchStockDAO.selectByProId(product.get(x).getProid());	
			result.add(branch.get(0));	
			result2.add(branch.get(1));	
		}
		result.addAll(result2);
		return result;
	}


	@Override
	public List<BranchStockBean> selectAllAmountByProId(Integer proid) {
		return branchStockDAO.selectByProId(proid);
	}
	@Override
	public Integer getAmountByproid(Integer proid) {
		return branchStockDAO.getAmountByproid(proid);
	}
	
	
	@Override
	public BranchStockBean selectADataByProid(Integer proid) {
		return branchStockDAO.selectAllBy(proid);
	}
	
		
	

}

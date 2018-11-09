package model.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.mail.handlers.image_gif;

import model.bean.BranchStockBean;
import model.bean.TransferBean;
import model.dao.BranchStockDAO;
import model.dao.BrandDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.dao.TransferDAO;
import model.service.Branch_StockService;
@Service
public class Branch_StockServiceImpl implements Branch_StockService{
	
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
	public List <BranchStockBean> selectALL(){
		
		return branchStockDAO.selectAll();
	}
	
	
	
	@Override
	public BranchStockBean selectById (Integer improtid){
		return branchStockDAO.selectById(improtid);
	
	}
	
	@Override
	public List <BranchStockBean> searchResult(){
		List<BranchStockBean> result = new ArrayList<>();
		System.out.println("searchresult==========================================");
		List<BranchStockBean> branchStockBean = branchStockDAO.selectAll();		
		for(int x = 0 ; x < branchStockBean.size(); x++) {
			System.out.println("forrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			branchStockBean.get(x).getBranch_stock_id();
			branchStockBean.get(x).getBranchBean().getName();
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
	public List <TransferBean> insertTransfer(Integer amountin, Integer branchidin, Integer branchidout, Integer proidin){
				
		TransferBean bean = new TransferBean();
		bean.setAmount(amountin);
		bean.setBranchidin(branchidin);
		bean.setBranchidout(branchidout);
		bean.setDate("date");
		bean.setProid(proidin);

		transferDAO.insert(bean);
		
		return null;
	}
	
	@Override
	public List <BranchStockBean> updateBranchStock(Integer branchidin, Integer branchidout, Integer amountin, Integer proidin){
		
		List<BranchStockBean> result =new ArrayList<>();
		
		List <BranchStockBean> branchStockBean = branchStockDAO.selectAll();
		
		
		for(int x = 0;x < branchStockBean.size(); x++) {			
			branchStockBean.get(x).getBranch_stock_id();
			System.out.println("BranchStock id=====================================" + branchStockBean.get(x).getBranch_stock_id());
			int inAmount = branchStockBean.get(x).getAmount() - amountin;
			int outAmount = branchStockBean.get(x).getAmount() + amountin;
			
			if(branchStockBean.get(x).getBranchid()==branchidin & branchStockBean.get(x).getProid()==proidin) {
				System.out.println("amount in =====================" + branchStockBean.get(x).getAmount());
				
				
				System.out.println("proid in =======================" + proidin);
				System.out.println("inamount==========================" + inAmount);
				branchStockBean.get(x).setAmount(inAmount);		
				
				branchStockDAO.updateList(branchStockBean, x);
				
			}else if (branchStockBean.get(x).getBranchid()==branchidout & branchStockBean.get(x).getProid()==proidin) {
				System.out.println("amount out ===============================" + branchStockBean.get(x).getAmount());
				
				System.out.println("branchidout=========================================" + branchidout);
				System.out.println("outamount=====================================" + outAmount);
				
			
				branchStockBean.get(x).setAmount(outAmount);
				branchStockDAO.updateList(branchStockBean, x);
				
			}else if (branchStockBean.get(x).getBranchid()==branchidout & branchStockBean.get(x).getProid()!=proidin){	
				System.out.println("insertttttttttttttttttttttttttttttttttttttttttttttttttt");
				branchStockDAO.insertintoStock(inAmount, branchidout, proidin, "on");
			}
			
			
			result.addAll(branchStockBean);
		}
	
		return result;		
		
	}
	
		
	
}

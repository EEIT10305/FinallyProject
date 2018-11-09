package model.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.BranchStockBean;
import model.bean.ImportBean;
import model.bean.ImportDetailBean;
import model.bean.MemberBean;
import model.bean.ProductBean;
import model.bean.WishBean;
import model.dao.BranchStockDAO;
import model.dao.ImportDAO;
import model.dao.ImportDetailDAO;
import model.dao.MemberDAO;
import model.dao.ProductDAO;
import model.dao.WishDAO;
import model.service.ImportService;
@Service
@Transactional
public class ImportServiceImpl implements ImportService {

	
	@Autowired
	ImportDAO importDAO;
	
	@Autowired
	ImportDetailDAO importDetailDAO;
	
	@Autowired
	BranchStockDAO branchStockDAO;	
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	WishDAO wishDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	public ImportServiceImpl() {}


	@Override
	public List<ImportBean> selectAll() {
		
		return importDAO.selectAll();
	}
	@Override
	public ImportBean selectByimprotid(Integer improtid) {
		
		return importDAO.getImportDetail(improtid);
	}

	
	@Override
	public List<ImportBean> selectByOrderdate(String orderdate) {
		 	
		return importDAO.selectByOrderdate(orderdate);
	}
	
	@Override
	public List<ImportBean> selectByArrivedate(String arrivedate) {
		
		return importDAO.selectByArrivedate(arrivedate);
			
	}
	
	@Override
	public List<ImportBean> selectByStatus(String statu) {				
		return importDAO.selectByStatus(statu);
			
	}
	
	@Override
	public List<ImportBean> selectByADOD(String arrivedate, String orderdate) {
		return importDAO.selectByADOD(arrivedate, orderdate);
		
	}
	
	
	@Override
	public List<ImportBean> selectByADS(String arrivedate, String statu) {
		return importDAO.selectByADS(arrivedate, statu);
		
	}
	
	@Override
	public List<ImportBean> selectByODS(String orderdate, String statu) {
		return importDAO.selectByODS(orderdate, statu);
		
	}
	
	@Override
	public List<ImportBean> selectByADODS(String arrivedate, String orderdate, String statu) {
		return importDAO.selectByADODS(arrivedate, orderdate, statu);
		
	}


	@Override
	public List<ImportBean> updateStatus(String statu, Integer improtid) {
			return importDAO.updateStatus(statu, improtid);
			
		}
	@Override
	public List<BranchStockBean> insertBranchStock(Integer improtid){//將商品庫存0  補貨
		List<BranchStockBean> result =new ArrayList<>();
		System.out.println("insertBranchStock==================================================================");

		 List<ImportDetailBean> importDetailBean = importDetailDAO.selectAllByID(improtid);//進貨id 帶入 查詢出多筆此進貨id的資料
		
			

		
		for(int x = 0 ; x < importDetailBean.size(); x++) {//用迴圈取出
			System.out.println("forrrrrrrrrrrrrrrrrrrr");
			
		System.out.println(importDetailBean.get(x).getProid());//看看有沒有抓到此商品的進貨id
		BranchStockBean branchStockBean = branchStockDAO.selectAllByID(importDetailBean.get(x).getProid());
		//利用每次取出一個的importDetailBean物件內的proid去查詢分店的資料
//如果branch_stock裡面有ImportDetailBean的proid
//update
		
			if(branchStockBean!=null) {//我們已有商品 但庫存0    再進貨      自動發mail

				int total = importDetailBean.get(x).getAmount() + branchStockBean.getAmount();
				System.out.println(importDetailBean.get(x).getAmount());
				System.out.println(branchStockBean.getAmount());
				System.out.println("total+++++++++++++++++++++++++++++++++++++++++++++++++" + total);
				branchStockBean.setAmount(total);
				boolean update = branchStockDAO.update(branchStockBean);
				if(update) {
					List<WishBean> allProWishList = wishDAO.selectAllByProId(importDetailBean.get(x).getProid());
					for(WishBean everyWishList:allProWishList) {
						if(everyWishList.getTracked()==2) {
							MemberBean memberBean = memberDAO.selectById(everyWishList.getMemberid());
							ProductBean productBean = productDAO.selectById(importDetailBean.get(x).getProid());
							System.out.println("會員mail="+memberBean.getEmail()+"關注商品已到貨"+"商品名稱為："+productBean.getModel());
							System.out.println("自動發mail第幾封?=>"+x);						
						}
					}
					result.add(branchStockBean);
					System.out.println("111111111111");
				
				}
			}else {//如果我們的庫存沒有此商品 就新增
		
				System.out.println("insert into stock+++++++++++++++++++++++++++++++++++++++++++++++");			

				BranchStockBean bean = new BranchStockBean(null,importDetailBean.get(x).getAmount(), 1, importDetailBean.get(x).getProid(), "on");
				branchStockDAO.insert(bean);
				result.add(bean);
				
				
			}
			
		}
		
		
//如果branch_stock裡面沒有ImportDetailBean的proid
//insert		
		
		return result;
	}
}


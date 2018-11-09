package model.dao;

import java.util.List;

import model.bean.BranchStockBean;
import model.bean.ProductBean;

public interface BranchStockDAO {
	    List<BranchStockBean> selectAll();
	    BranchStockBean selectById(int id);
	    BranchStockBean insert(BranchStockBean bean);
	    boolean update(BranchStockBean bean);		
		BranchStockBean selectAllByID(Integer proid);
		boolean updateBranchStock(Integer amount, String statu, Integer proid);

		BranchStockBean selectbranchStock(Integer proid);
		ProductBean selectByModel(String Model); 
		Integer checkAmmount(Integer proid);

		BranchStockBean insertintoStock(Integer amount, Integer branchid, Integer proid, String statu);
		Integer getAmountByproid(Integer proid);
		List<BranchStockBean> selectByProId(Integer proid);
		List<BranchStockBean> selectAllByBranchID(Integer branchid);
		List<BranchStockBean> updateList(List<BranchStockBean> branchStockBean, Integer x);

		BranchStockBean selectAllBy(Integer proid);


	
}

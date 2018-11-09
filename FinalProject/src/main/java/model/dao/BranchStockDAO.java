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
		BranchStockBean insertintoStock(Integer amount, Integer branchid, Integer proid, String statu);
		BranchStockBean selectbranchStock(Integer proid);
		ProductBean selectByModel(String Model); 
		Integer checkAmmount(Integer proid);
}

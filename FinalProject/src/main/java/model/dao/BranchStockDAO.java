package model.dao;

import java.util.List;

import model.bean.BranchStockBean;

public interface BranchStockDAO {
	 List<BranchStockBean> selectAll();
	    BranchStockBean selectById(int id);
	    BranchStockBean insert(BranchStockBean bean);
	    boolean update(BranchStockBean bean);		
		BranchStockBean selectAllByID(Integer proid);
		boolean updateBranchStock(Integer amount, String statu, Integer proid);
		BranchStockBean insertintoStock(Integer amount, Integer branchid, Integer proid, String statu);
		List<BranchStockBean> selectAllByBranchId(Integer BranchId);
		BranchStockBean selectbranchStock(Integer proid);
}

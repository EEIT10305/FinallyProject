package model.dao;

import java.util.List;

import model.BranchStockBean;

public interface BranchStockDAO {
	 List<BranchStockBean> selectAll();
	    BranchStockBean selectById(int id);
	    BranchStockBean insert(BranchStockBean bean);
	    boolean update(BranchStockBean bean);
}

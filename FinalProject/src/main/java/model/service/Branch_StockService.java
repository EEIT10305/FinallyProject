package model.service;

import java.util.List;

import model.bean.BranchStockBean;
import model.bean.TransferBean;

public interface Branch_StockService {

	List<BranchStockBean> selectALL();

	BranchStockBean selectById(Integer improtid);

	List<BranchStockBean> searchResult();

	
	List<BranchStockBean> updateBranchStock(Integer branchidin, Integer branchidout, Integer amountin, Integer proidin);

	List<TransferBean> insertTransfer(Integer amountin, Integer branchin, Integer branchout, Integer proidin);
	
	

}

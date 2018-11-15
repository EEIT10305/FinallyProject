package model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.bean.BranchStockBean;
import model.bean.BrandBean;
import model.bean.ProductBean;
import model.bean.TransferBean;

public interface Branch_StockService {

	List<BranchStockBean> selectALL();

	BranchStockBean selectById(Integer improtid);

	List<BranchStockBean> searchResult();

	
	List<BranchStockBean> updateBranchStock(Integer branchidin, Integer branchidout, Integer amountin, Integer proidin);

//	List<TransferBean> insertTransfer(Integer amountin, Integer branchin, Integer branchout, Integer proidin);

	List<TransferBean> insertTransfer(Integer amountin, Integer branchidin, Integer branchidout, Integer proidin,
			HttpSession session);

	List<TransferBean> selectAll();

	BrandBean selectByBrand(String brand);

	List<TransferBean> selectLatestRecord(String date);


	List<BranchStockBean> selectByProID(Integer proid);

	List<BranchStockBean> selectByProModel(String promodel);
	


}

package model.service;

import java.util.List;

import model.bean.BranchStockBean;

public interface TestExcelService {

	List<BranchStockBean> ShowExcelInService(String yyyy, String MM, String dd, Integer d);

}

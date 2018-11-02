package model.service;

import java.util.List;

import model.bean.ImportBean;

public interface ImportService {
	List<ImportBean> selectAll();

	List<ImportBean> selectByArrivedate(String arrivedate);

	List<ImportBean> selectByOrderdate(String orderdate);

	List<ImportBean> selectByStatus(String statu);

	List<ImportBean> selectByADOD(String arrivedate, String orderdate);

	List<ImportBean> selectByADS(String arrivedate, String statu);

	List<ImportBean> selectByODS(String orderdate, String statu);

	List<ImportBean> selectByADODS(String arrivedate, String orderdate, String statu);
	

	ImportBean updateStatus(String statu, Integer improtid);

}

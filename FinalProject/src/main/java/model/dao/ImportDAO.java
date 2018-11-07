package model.dao;

import java.util.List;

import model.bean.ImportBean;

public interface ImportDAO {
	List<ImportBean> selectAll();

	ImportBean selectById(int id);

	ImportBean insert(ImportBean bean);

	boolean update(ImportBean bean);

	List<ImportBean> selectByArrivedate(String arrivedate);

	List<ImportBean> selectByOrderdate(String orderdate);

	List<ImportBean> selectByStatus(String status);

	List<ImportBean> selectByADOD(String arrivedate, String orderdate);

	List<ImportBean> selectByADS(String arrivedate, String status);

	List<ImportBean> selectByODS(String orderdate, String status);

	List<ImportBean> selectByADODS(String arrivedate, String orderdate, String status);

	
	List<ImportBean> updateStatus(String statu, Integer improtid);

	ImportBean getImportDetail(Integer improtid);

	



}
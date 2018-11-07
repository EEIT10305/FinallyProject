package model.dao;

import java.util.List;

import model.bean.ImportDetailBean;

public interface ImportDetailDAO {
	List<ImportDetailBean> selectAll();

	ImportDetailBean selectById(int id);

	ImportDetailBean insert(ImportDetailBean bean);

	boolean update(ImportDetailBean bean);
	
	List<ImportDetailBean> selectAllByID(Integer improtid);

}

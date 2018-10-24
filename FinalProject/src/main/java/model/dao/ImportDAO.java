package model.dao;

import java.util.List;

import model.ImportBean;

public interface ImportDAO {
	 List<ImportBean> selectAll();
	    ImportBean selectById(int id);
	    ImportBean insert(ImportBean bean);
	    boolean update(ImportBean bean);
}

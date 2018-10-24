package model.dao;

import java.util.List;

import model.bean.StorageBean;

public interface StorageDAO {
	 List<StorageBean> selectAll();
	    StorageBean selectById(int id);
	    StorageBean insert(StorageBean bean);
	    boolean update(StorageBean bean);
}

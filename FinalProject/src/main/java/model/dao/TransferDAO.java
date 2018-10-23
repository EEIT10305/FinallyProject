package model.dao;

import java.util.List;

import model.TransferBean;

public interface TransferDAO {
	 List<TransferBean> selectAll();
	    TransferBean selectById(int id);
	    TransferBean insert(TransferBean bean);
	    boolean update(TransferBean bean);
}

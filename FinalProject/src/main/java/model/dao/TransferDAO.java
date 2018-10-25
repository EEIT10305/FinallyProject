package model.dao;

import java.util.List;

import model.bean.TransferBean;

public interface TransferDAO {
	 List<TransferBean> selectAll();
	    TransferBean selectById(int id);
	    TransferBean insert(TransferBean bean);
	    boolean update(TransferBean bean);
}

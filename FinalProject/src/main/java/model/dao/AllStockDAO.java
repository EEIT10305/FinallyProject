package model.dao;

import java.util.List;

import model.bean.AllStockBean;

public interface AllStockDAO {
	 
	List<AllStockBean> selectAll();
	
	AllStockBean selectById(int id);
	 
	AllStockBean insert(AllStockBean bean);
	 
	boolean update(AllStockBean bean);
	 
}

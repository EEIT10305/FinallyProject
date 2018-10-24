package model.dao;

import java.util.List;

import model.RamBean;

public interface RamDAO {
	 List<RamBean> selectAll();
	    RamBean selectById(int id);
	    RamBean insert(RamBean bean);
	    boolean update(RamBean bean);
}

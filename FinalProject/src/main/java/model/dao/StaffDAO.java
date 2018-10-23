package model.dao;

import java.util.List;

import model.StaffBean;

public interface StaffDAO {
	 List<StaffBean> selectAll();
	    StaffBean selectById(int id);
	    StaffBean insert(StaffBean bean);
	    boolean update(StaffBean bean);
}

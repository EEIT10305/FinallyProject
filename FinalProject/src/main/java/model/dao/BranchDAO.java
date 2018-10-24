package model.dao;

import java.util.List;

import model.BranchBean;

public interface BranchDAO {
	 List<BranchBean> selectAll();
	    BranchBean selectById(int id);
	    BranchBean insert(BranchBean bean);
	    boolean update(BranchBean bean);
}

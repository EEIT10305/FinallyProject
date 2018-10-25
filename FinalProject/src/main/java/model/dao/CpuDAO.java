package model.dao;

import java.util.List;

import model.bean.CpuBean;

public interface CpuDAO {
	 List<CpuBean> selectAll();
	    CpuBean selectById(int id);
	    CpuBean insert(CpuBean bean);
	    boolean update(CpuBean bean);
}

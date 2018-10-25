package model.dao;

import java.util.List;

import model.bean.CabinetBean;

public interface CabinetDAO {
	 List<CabinetBean> selectAll();
	    CabinetBean selectById(int id);
	    CabinetBean insert(CabinetBean bean);
	    boolean update(CabinetBean bean);
}

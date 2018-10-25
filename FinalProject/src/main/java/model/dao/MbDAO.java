package model.dao;

import java.util.List;

import model.bean.MbBean;

public interface MbDAO {
	 List<MbBean> selectAll();
	    MbBean selectById(int id);
	    MbBean insert(MbBean bean);
	    boolean update(MbBean bean);
}

package model.dao;

import java.util.List;

import model.PinginDetailBean;

public interface PinginDetailDAO {
	 List<PinginDetailBean> selectAll();
	    PinginDetailBean selectById(int id);
	    PinginDetailBean insert(PinginDetailBean bean);
	    boolean update(PinginDetailBean bean);
}

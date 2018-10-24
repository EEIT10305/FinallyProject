package model.dao;

import java.util.List;

import model.bean.VgaBean;

public interface VgaDAO {
	 List<VgaBean> selectAll();
	    VgaBean selectById(int id);
	    VgaBean insert(VgaBean bean);
	    boolean update(VgaBean bean);
}

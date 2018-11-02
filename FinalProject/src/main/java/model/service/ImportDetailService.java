package model.service;

import java.util.List;

import model.bean.ImportDetailBean;

public interface ImportDetailService {
	List<ImportDetailBean> selectAll();
	ImportDetailBean selectByID(int id);	
	
	List<ImportDetailBean> selectAllByID(Integer improtid);
}

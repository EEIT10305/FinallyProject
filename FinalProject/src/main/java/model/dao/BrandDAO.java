package model.dao;

import java.util.List;

import model.BrandBean;

public interface BrandDAO {
	 List<BrandBean> selectAll();
	    BrandBean selectById(int id);
	    BrandBean insert(BrandBean bean);
	    boolean update(BrandBean bean);
}

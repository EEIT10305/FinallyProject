package model.dao;

import java.util.List;

import model.WishBean;

public interface WishDAO {
	 List<WishBean> selectAll();
	    WishBean selectById(int id);
	    WishBean insert(WishBean bean);
	    boolean update(WishBean bean);
	    boolean delete(WishBean bean);
}

package model.dao;

import java.util.List;

import model.bean.WishBean;

public interface WishDAO {
	List<WishBean> selectAll();

	WishBean selectById(int id);

	WishBean insert(WishBean bean);

	boolean update(WishBean bean);

	boolean delete(WishBean bean);
	
	List<WishBean> selectByMemberId(Integer memberId);
	
	WishBean selectByMemberIdProId(Integer memberId, Integer proId);
	
	WishBean selectByProId(Integer proId);
	
	List<WishBean> selectAllByProId(Integer proid);
}

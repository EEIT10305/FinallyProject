package model.service.wish;

import java.util.List;

import model.bean.WishBean;

public interface WishService {

	WishBean selectByMemberIdProId(Integer memberId, Integer proId);
	
	boolean update(WishBean bean);
	
	List<WishBean> selectByMemberId(Integer memberId);
}

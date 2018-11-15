package model.service.wish.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishBean;
import model.dao.WishDAO;
import model.service.wish.WishService;

@Service
@Transactional
public class WishServiceImpl implements WishService {
	
	@Autowired
	WishDAO wishDao;
	
	
	public WishServiceImpl() {}

	@Override
	public WishBean selectByMemberIdProId(Integer memberId, Integer proId) {
		return wishDao.selectByMemberIdProId(memberId, proId);
	}

	@Override
	public boolean update(WishBean bean) {
		
		return wishDao.update(bean);
	}

	@Override
	public List<WishBean> selectByMemberId(Integer memberId) {
		wishDao.selectByMemberId(memberId);
		
		
		return wishDao.selectByMemberId(memberId);
	}

	@Override
	public WishBean insertAWishBean(WishBean bean) {
		return wishDao.insert(bean);
	}

}

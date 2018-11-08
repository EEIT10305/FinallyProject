package model.service.staff.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StaffBean;
import model.dao.StaffDAO;
import model.service.staff.StaffService;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffDAO staffDao;
	
	
	@Override
	public StaffBean checkByUseridPwd(String userId, String password) {
		return staffDao.selectByUseridPwd(userId, password);
	}

	
	
	
	
	
	
}

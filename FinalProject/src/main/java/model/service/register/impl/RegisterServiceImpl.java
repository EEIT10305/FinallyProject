package model.service.register.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.service.register.RegisterService;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private MemberDAO mbDao; 
	
	public RegisterServiceImpl() {}


	@Override
	public MemberBean idExists(int id) {
		return mbDao.selectById(id);
	}

	@Override
	public MemberBean saveMember(MemberBean mb) {
		return mbDao.insert(mb);
	}
	@Override
	public MemberBean userExists(String email) {
		
		return mbDao.selectByEmail(email);
	}
	
}

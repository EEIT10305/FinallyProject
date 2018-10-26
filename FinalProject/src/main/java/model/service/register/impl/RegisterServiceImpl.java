package model.service.register.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.service.register.RegisterIService;

@Service
public class RegisterServiceImpl implements RegisterIService {
	
	@Autowired
	private MemberDAO mbDao; 
	
	public RegisterServiceImpl() {}
	public RegisterServiceImpl(MemberDAO mbDao) {
		this.mbDao = mbDao;
	}

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

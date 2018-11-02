package model.service.updatememberinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.service.updatememberinfo.UpdateMemberInfoService;

@Service
public class UpdateMemberInfoServiceImpl implements UpdateMemberInfoService {
    @Autowired  
	MemberDAO memberDao;
	
	@Override
	public MemberBean selectMemberInfo(String email) {
		memberDao.selectByEmail(email);
		return memberDao.selectByEmail(email);
	}

}

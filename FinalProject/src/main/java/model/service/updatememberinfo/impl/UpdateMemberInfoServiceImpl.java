package model.service.updatememberinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.service.updatememberinfo.UpdateMemberInfoService;

@Service
@Transactional
public class UpdateMemberInfoServiceImpl implements UpdateMemberInfoService {
	@Autowired
	MemberDAO memberDao;

	@Override
	public MemberBean selectMemberInfo(String email) {
		return memberDao.selectByEmail(email);
	}

	@Override
	public boolean updateMemberInfo(MemberBean bean) {
		if (bean != null) {
			memberDao.update(bean);
			return true;
		} else {
			return false;
		}
	}
}

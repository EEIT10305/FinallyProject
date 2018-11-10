package model.service.login.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CartBean;
import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.service.login.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    
	@Autowired  
	MemberDAO memberDao;
    
	public LoginServiceImpl() {}

	public CartBean loginInsertCartId() {
		return null;
	}
	
	@Override
	public MemberBean checkEmailPwd(String email, String password) {
		MemberBean mb = memberDao.checkEmailPwd(email, password);
		if(mb!=null) {
			if(password!=null && password.length()!=0) {
				String inputPwd = password ; 
				String memeberPwd = mb.getmemberpassword();
				if(memeberPwd.equals(inputPwd)) {
					return mb;
				}else {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public MemberBean checkEmail(String email) {
//		MemberBean mb = memberDao.selectByEmail(email);
		return memberDao.selectByEmail(email);
	}

	@Override
	public MemberBean selectById(Integer memberId) {
		return memberDao.selectById(memberId);
	}

		
	
	
	
}

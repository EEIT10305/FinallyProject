package model.service.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.service.login.LoginIService;

@Service
public class LoginService implements LoginIService {
    @Autowired  
	MemberDAO memberDao;
    
	public LoginService() {}

	@Override
	public MemberBean checkEmailPwd(String email, String password) {
		MemberBean mb = memberDao.checkEmailPwd(email, password);
		if(mb!=null) {
			if(password!=null && password.length()!=0) {
				String inputPwd = password ; 
				String memeberPwd = mb.getPassword();
				if(memeberPwd.equals(inputPwd)) {
					return mb;
				}
			}
		}
		return null;
	}
		
	
	
	
}

package model.service.login;

import model.bean.MemberBean;

public interface LoginIService {

	public MemberBean checkEmailPwd(String email, String password); 
	
	
	
}

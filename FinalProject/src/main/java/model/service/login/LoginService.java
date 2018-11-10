package model.service.login;

import model.bean.MemberBean;

public interface LoginService {

	public MemberBean checkEmailPwd(String email, String password); 
	
	public MemberBean checkEmail(String email);
	
	public MemberBean selectById(Integer memberId);
}

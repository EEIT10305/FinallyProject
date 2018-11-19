package model.service.login;

import java.util.List;

import model.bean.MemberBean;

public interface LoginService {

	public MemberBean checkEmailPwd(String email, String password); 
	
	public MemberBean checkEmail(String email);
	
	public MemberBean selectById(Integer memberId);
	
	public List<MemberBean> selectAll();
	
	public List<MemberBean> checkEamilList(String email);
}

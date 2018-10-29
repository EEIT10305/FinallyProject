package model.service.register;

import model.bean.MemberBean;

public interface RegisterService {

	MemberBean idExists(int id);
	
	MemberBean saveMember(MemberBean mb);
	
	MemberBean userExists(String email);
	
	
}
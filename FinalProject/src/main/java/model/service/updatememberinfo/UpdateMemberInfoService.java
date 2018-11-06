package model.service.updatememberinfo;

import model.bean.MemberBean;

public interface UpdateMemberInfoService {

	public MemberBean selectMemberInfo(String email);
	
	public boolean updateMemberInfo(MemberBean bean);
}

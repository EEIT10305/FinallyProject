package model.service.staff;

import model.bean.StaffBean;

public interface StaffService {

	StaffBean checkByUseridPwd(String userId, String password);
	
	
	
}
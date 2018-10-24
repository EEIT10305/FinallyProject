package model.dao;

import java.util.List;

import member.model.MemberBean;

public interface MemberDAO {
	 List<MemberBean> selectAll();
	    MemberBean selectById(int id);
	    MemberBean insert(MemberBean bean);
	    boolean update(MemberBean bean);
}

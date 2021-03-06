package model.dao;

import java.util.List;

import model.bean.MessageBean;

public interface MessageDAO {
	 List<MessageBean> selectAll();
	    MessageBean selectById(int id);
	    MessageBean insert(MessageBean bean);
	    boolean update(MessageBean bean);
	    List<MessageBean> selectByMemberB(Integer member);
		List<MessageBean> selectByMemberBAll(Integer member);
}

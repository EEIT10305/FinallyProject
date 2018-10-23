package model.dao;

import java.util.List;

import model.MessageBean;

public interface MessageDAO {
	 List<MessageBean> selectAll();
	    MessageBean selectById(int id);
	    MessageBean insert(MessageBean bean);
	    boolean update(MessageBean bean);
}

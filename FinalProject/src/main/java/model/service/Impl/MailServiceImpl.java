package model.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.MemberBean;
import model.bean.MessageBean;
import model.dao.MemberDAO;
import model.dao.MessageDAO;
import model.dao.StaffDAO;
import model.service.MailService;

@Service
@Transactional
public class MailServiceImpl implements MailService {
	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private StaffDAO staffDao;
	@Autowired
	private MessageDAO messageDao;

	@Override
	public List<HashMap<String,Object>> getMailForMe(String email) {
		List<HashMap<String,Object>> list = null;
		MemberBean member = memberDao.selectByEmail(email);	
		List<MessageBean> result = messageDao.selectByMemberB(member.getMemberid());
		if(result != null && !result.isEmpty()) {
			list = new ArrayList<>();
		for(MessageBean bean : result) {
			HashMap<String,Object> hm = new HashMap<>();
			hm.put("message_id" , bean.getMessage_id());
			hm.put("memberidA", staffDao.selectById(bean.getMemberidA()));
			hm.put("memberidB", memberDao.selectById(bean.getMemberidB()));
			hm.put("date", bean.getDate());
			hm.put("message", bean.getMessage());
			hm.put("title", bean.getTitle());
			hm.put("readstatu", bean.getReadstatu());
			list.add(hm);
		}
		}
		return list;
	}
    
	@Override
	public List<HashMap<String, Object>> readMailAll(String email) {
		List<HashMap<String,Object>> list = null;
		MemberBean member = memberDao.selectByEmail(email);	
		List<MessageBean> result = messageDao.selectByMemberBAll(member.getMemberid());
		if(result != null && !result.isEmpty()) {
			list = new ArrayList<>();
			for(MessageBean bean : result) {
				HashMap<String,Object> hm = new HashMap<>();
				hm.put("message_id" , bean.getMessage_id());
				hm.put("memberidA", staffDao.selectById(bean.getMemberidA()));
				hm.put("memberidB", memberDao.selectById(bean.getMemberidB()));
				hm.put("date", bean.getDate());
				hm.put("message", bean.getMessage());
				hm.put("title", bean.getTitle());
				hm.put("readstatu", bean.getReadstatu());
				list.add(hm);
			}			
		}
		return list;
	}

	@Override
	public boolean readMail(String id) {
		MessageBean bean = messageDao.selectById(Integer.parseInt(id));
		bean.setReadstatu("yet");
		if(messageDao.update(bean)) {
			return true;
		}
		return false;
	}
	
	

}

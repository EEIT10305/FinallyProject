package model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import model.bean.CartBean;
import model.dao.CartDAO;
import model.service.CartService;
@Service
@Transactional
public class CartServiceimpl implements CartService {
	@Autowired 
	CartDAO Dao;
	
	public CartServiceimpl() {
		
	}
	
	@Override
	public List<CartBean> selectAll() {
		return Dao.selectAll();
	}

	@Override
	public CartBean selectById(int id) {
		return Dao.selectById(id);
	}

	@Override
	public CartBean insert(CartBean bean) {
		return Dao.insert(bean);
	}

	@Override
	public boolean update(CartBean bean) {
		return Dao.update(bean);
	}

	@Override
	public boolean delete(CartBean bean) {
		return Dao.delete(bean);
	}

	@Override
	public Integer getMemberId() {
		return Dao.getMemberId();
	}

	@Override
	public void setMemberId(Integer memberid) {
		Dao.setMemberId(memberid);
		
	}

}

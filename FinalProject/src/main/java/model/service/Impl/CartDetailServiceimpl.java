package model.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import model.bean.CartDetailBean;
import model.dao.CartDetailDAO;
import model.service.CartDetailService;


@Service
@Transactional
public class CartDetailServiceimpl implements CartDetailService {
	
	
	@Autowired
	CartDetailDAO Dao;
	
	private Integer memberid = null;
	
	public CartDetailServiceimpl() {
		
	}

	@Override
	public List<CartDetailBean> selectAll() {
		return Dao.selectAll();
	}

	@Override
	public CartDetailBean selectById(int id) {
		return Dao.selectById(id);
	}

	@Override
	public CartDetailBean insert(CartDetailBean bean) {
		return Dao.insert(bean);
	}

	@Override
	public boolean update(CartDetailBean bean) {
		return Dao.update(bean);
	}

	@Override
	public boolean delete(CartDetailBean bean) {
		return Dao.delete(bean);
	}

	@Override
	public Integer getMemberId() {
		return memberid;
	}

	@Override
	public void setMemberId(Integer memberid) {
		this.memberid = memberid;
		
	}

}

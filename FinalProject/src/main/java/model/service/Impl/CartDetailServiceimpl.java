package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.CartDetailBean;
import model.dao.CartDetailDAO;
import model.service.CartDetailService;


@Service
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
	public CartDetailBean selectById(Integer cartid) {
//		dao.insert
//		dao.eXXX
		return Dao.selectById(cartid);
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
	public boolean deletebycartId(int cartid){
		return Dao.deletebycartId(cartid);
	}

	@Override
	public Integer getMemberId() {
		return memberid;
	}

	@Override
	public void setMemberId(Integer memberid) {
		this.memberid = memberid;
		
	}

//	@Override
//	public CartDetailBean selectCartId(int cartid) {
//		return null;
//	}

	@Override
	public List<CartDetailBean> selectbycartId(int cartid) {
		return Dao.selectbycartId(cartid);
	}



}

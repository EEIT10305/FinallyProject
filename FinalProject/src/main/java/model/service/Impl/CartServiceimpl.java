package model.service.Impl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.MemberBean;
import model.bean.ProductBean;
import model.dao.CartDAO;
import model.dao.CartDetailDAO;
import model.dao.impl.ProductDAOImpl;
import model.service.CartService;
@Service
@Transactional
public class CartServiceimpl implements CartService {
	@Autowired 
	CartDAO Dao;
	
	@Autowired 
	CartDetailDAO  cartDetailDao;
	@Autowired
	ProductDAOImpl produtDAOImpl;
	
	
	public CartServiceimpl() {
		
	}
	
	@Override
	public List<CartBean> selectAll() {
		return Dao.selectAll();
	}

	@Override
	public CartBean selectById(int cartid) {		
		return Dao.selectById(cartid);
	}

	@Override
	public void insert(String model , Integer CartId) {
		
//		String hql = "from ProductBean where model=: model";
//		ProductBean productbean = produtDAOImpl.getSession().
//				createQuery(hql,ProductBean.class).setParameter("model", model).getSingleResult();		//利用model這個條件去得到productbean
//		System.out.println("================================");
//		System.out.println(model);
//		System.out.println("================================");
		ProductBean productbean = Dao.insertmodelfromProduct(model);
		CartBean cartbean = new CartBean();			//開啟一個bean讓後面可以直接完整的insert進去
		cartbean.setDate("2018-11-03");
		cartbean.setMemberid(2);		
		cartbean.setStatus("noPay");
		Dao.insert(cartbean);
		System.out.println("進入購物車");
		
		CartDetailBean CartDetailbean = new CartDetailBean();    	//開啟一個bean讓後面可以直接完整的insert進去
		CartDetailbean.setCartid(CartId);
		CartDetailbean.setProid(productbean.getProid());
		CartDetailbean.setAmount(1);
		cartDetailDao.insert(CartDetailbean);
		
	//	return Dao.insert(bean);
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
	public MemberBean getMemberId() {
		return Dao.getMemberId();
	}

	@Override
	public void setMemberId(Integer memberid) {
		Dao.setMemberId(memberid);
		
	}

	@Override
	public boolean checkMember(int memberId) {
	
		return Dao.checkMember(memberId);
	}

	@Override
	public CartBean selectByMemberId(int memberid) {
		return Dao.selectByMemberId(memberid);
	}

	@Override
	public ProductBean insertmodelfromProduct(String model) {
		return Dao.insertmodelfromProduct(model);
	}

	@Override
	public boolean deletebycartId(int cartid) {
		return Dao.deletebyCartId(cartid);
	}

	@Override
	public boolean updatestatus(int cartid) {
		return Dao.updatestatus(cartid);
	}
	
	
	

}

package model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.MemberBean;
import model.bean.ProductBean;
import model.dao.CartDetailDAO;
import model.service.CartDAO;
import model.service.CartService;
@Service
@Transactional
public class CartServiceimpl implements CartService {
	@Autowired 
	CartDAO Dao;
	
	@Autowired 
	CartDetailDAO  cartDetailDao;

	
	
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
	public void insert(String model , Integer CartId) {		//之後再這裡傳入MemberId
		
//		String hql = "from ProductBean where model=: model";
//		ProductBean productbean = produtDAOImpl.getSession().
//				createQuery(hql,ProductBean.class).setParameter("model", model).getSingleResult();		//利用model這個條件去得到productbean
//		System.out.println("================================");
//		System.out.println(model);
//		System.out.println("================================");
		ProductBean productbean = Dao.insertmodelfromProduct(model);
//		CartBean cartbean = new CartBean();			//開啟一個bean讓後面可以直接完整的insert進去
//		cartbean.setDate("2018/11/06");				//關於cart的部分先不看 會以登入之後給CartId為主，之後都會以CartID來判斷
//		cartbean.setMemberid(1);					//之後會再以拿到的CartBean get MemberID出來
//		cartbean.setStatus("nopay");		
//		Dao.insert(cartbean);
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

	@Override
	public List<CartBean> selectMemberId(Integer memberid) {
		Dao.selectByMemberId(memberid);
		return null;
	}

	@Override
	public CartBean saveCartBean(CartBean bean) {
		return Dao.insert(bean);
	}

	@Override
	public List<CartBean> selectMemberIdList(Integer memberid) {
		
		return Dao.selectByMemberIdList(memberid);
	}
	
	
	

}

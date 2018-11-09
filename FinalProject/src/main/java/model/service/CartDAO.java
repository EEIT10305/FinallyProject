package model.service;

import java.util.List;

import model.bean.CartBean;
import model.bean.MemberBean;
import model.bean.ProductBean;

public interface CartDAO {
	List<CartBean> selectAll();

	List<CartBean> selectByMemberIdList(Integer memberId);
	
	CartBean selectById(int cartid);

	CartBean insert(CartBean bean);

	boolean update(CartBean bean);

	boolean delete(CartBean bean);

	MemberBean getMemberId();

	void setMemberId(int memberId);

	boolean checkMember(int memberid);

	CartBean selectByMemberId(int memberid);

	void getCartId();

	public ProductBean insertmodelfromProduct(String model);

	boolean deletebyCartId(int cartid);

	boolean updatestatus(int cartid);

}

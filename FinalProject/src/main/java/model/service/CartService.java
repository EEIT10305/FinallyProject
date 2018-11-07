package model.service;

import java.util.List;

import model.bean.CartBean;
import model.bean.MemberBean;
import model.bean.ProductBean;

public interface CartService {

	List<CartBean> selectAll();

	CartBean selectById(int cartid);

	boolean update(CartBean bean);

	boolean delete(CartBean bean);

	MemberBean getMemberId();

	void setMemberId(Integer memberid);

	List<CartBean> selectMemberId(Integer memberid);

	void insert(String model, Integer CartId);

	boolean checkMember(int memberid);

	public CartBean selectByMemberId(int memberid);

	public ProductBean insertmodelfromProduct(String model);

	public boolean deletebycartId(int cartid);

	boolean updatestatus(int cartid);

	
	public CartBean saveCartBean(CartBean bean);
}

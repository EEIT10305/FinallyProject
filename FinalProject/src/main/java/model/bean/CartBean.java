package model.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="cart")
public class CartBean {
	@Id
	private Integer cartid;
	@Column(nullable=false)
	private Integer memberid;
	@Column(nullable=false)
	private String date;
	@Column(nullable=false)
	private String status;
	@ManyToOne
	@JoinColumn(name="memberid",insertable=false,updatable=false)
	private MemberBean memberBean;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="cartBean")
	private Set<CartDetailBean> cartDetailBean ;
	public CartBean() {
		super();
	}
	public CartBean(Integer cartid, Integer memberid, String date, String status, MemberBean memberBean,
			Set<CartDetailBean> cartDetailBean) {
		super();
		this.cartid = cartid;
		this.memberid = memberid;
		this.date = date;
		this.status = status;
		this.memberBean = memberBean;
		this.cartDetailBean = cartDetailBean;
	}
	public CartBean(Integer cartid, Integer memberid, String date, String status) {
		super();
		this.cartid = cartid;
		this.memberid = memberid;
		this.date = date;
		this.status = status;
	}
	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	public Set<CartDetailBean> getCartDetailBean() {
		return cartDetailBean;
	}
	public void setCartDetailBean(Set<CartDetailBean> cartDetailBean) {
		this.cartDetailBean = cartDetailBean;
	}
	
	
	
}

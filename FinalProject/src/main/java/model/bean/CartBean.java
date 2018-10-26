package model.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="cart")
public class CartBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cartid;
	@Column(nullable=false)
	private Integer memberid;
	@Column(nullable=false)
	private String date;
	@Column(nullable=false)
	private String statu;
	@ManyToOne
	@JoinColumn(name="memberid",insertable=false,updatable=false)
	private MemberBean memberBean;
	public CartBean() {
		super();
	}
	public CartBean(Integer cartid,String date , Integer memberid, String statu, MemberBean memberBean) {
		super();
		this.cartid = cartid;
		this.memberid = memberid;
		this.date = date;
		this.statu = statu;
		this.memberBean = memberBean;
	}
	public CartBean(Integer cartid, String date, Integer memberid, String statu) {
		super();
		this.cartid = cartid;
		this.memberid = memberid;
		this.date = date;
		this.statu = statu;
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
		return statu;
	}
	public void setStatus(String statu) {
		this.statu = statu;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

}

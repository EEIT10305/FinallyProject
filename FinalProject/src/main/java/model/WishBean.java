package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.bean.MemberBean;
@Entity
@Table(name="wish")
public class WishBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer wishid;
	@Column(nullable=false)
	private Integer memberid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private Integer tracked;
	@ManyToOne
	@JoinColumn(name="memberid",insertable=false,updatable=false)
	private MemberBean memberBean;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public WishBean() {
		super();
	}
	public WishBean(Integer wishid, Integer memberid, Integer proid, Integer tracked, MemberBean memberBean,
			ProductBean productBean) {
		super();
		this.wishid = wishid;
		this.memberid = memberid;
		this.proid = proid;
		this.tracked = tracked;
		this.memberBean = memberBean;
		this.productBean = productBean;
	}
	public WishBean(Integer wishid, Integer memberid, Integer proid, Integer tracked) {
		super();
		this.wishid = wishid;
		this.memberid = memberid;
		this.proid = proid;
		this.tracked = tracked;
	}
	public Integer getWishid() {
		return wishid;
	}
	public void setWishid(Integer wishid) {
		this.wishid = wishid;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Integer getTracked() {
		return tracked;
	}
	public void setTracked(Integer tracked) {
		this.tracked = tracked;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	
	
	
}

package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class BranchBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer branchid;
	@Column(nullable=false)
	private String shopname;
	@Column(nullable=false)
	private String shopaddress;
	@Column(nullable=false)
	private String phone;
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getAddress() {
		return shopaddress;
	}
	public void setAddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public BranchBean(Integer branchid, String shopname, String shopaddress, String phone) {
		super();
		this.branchid = branchid;
		this.shopname = shopname;
		this.shopaddress = shopaddress;
		this.phone = phone;
	}
	
	public BranchBean() {
		super();
	}
	
}

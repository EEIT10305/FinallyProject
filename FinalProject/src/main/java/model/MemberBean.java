package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MemberBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String permission;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String phone;
	@Column(nullable=false)
	private String gender;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="memberBean")
	private Set<OrderListBean> orderListBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="memberBean")
	private Set<WishBean> wishBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="memberBean")
	private Set<CartBean> cartBean ;
	public MemberBean() {
		super();
	}
	public MemberBean(Integer memberid, String name, String email, String password, String permission, String address,
			String phone, String gender, Set<OrderListBean> orderListBean, Set<WishBean> wishBean,
			Set<CartBean> cartBean) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permission = permission;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.orderListBean = orderListBean;
		this.wishBean = wishBean;
		this.cartBean = cartBean;
	}
	public MemberBean(Integer memberid, String name, String email, String password, String permission, String address,
			String phone, String gender) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permission = permission;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<OrderListBean> getOrderListBean() {
		return orderListBean;
	}
	public void setOrderListBean(Set<OrderListBean> orderListBean) {
		this.orderListBean = orderListBean;
	}
	public Set<WishBean> getWishBean() {
		return wishBean;
	}
	public void setWishBean(Set<WishBean> wishBean) {
		this.wishBean = wishBean;
	}
	public Set<CartBean> getCartBean() {
		return cartBean;
	}
	public void setCartBean(Set<CartBean> cartBean) {
		this.cartBean = cartBean;
	}

	
}

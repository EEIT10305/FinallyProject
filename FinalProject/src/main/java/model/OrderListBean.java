package model;

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
@Table(name="order_list")
public class OrderListBean {
	@Id
	private Integer orderid;
	@Column(nullable=false)
	private String date;
	@Column(nullable=false)
	private Integer memberid;
	@Column(nullable=false)
	private Integer total;
	@Column(nullable=false)
	private String shipping;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="orderListBean")
	private Set<OrderDetailBean> orderDetailBean ;
	@ManyToOne
	@JoinColumn(name="memberid",insertable=false,updatable=false)
	private MemberBean memberBean;
	
	public OrderListBean() {
		super();
	}
	public OrderListBean(Integer orderid, String date, Integer memberid, Integer total, String shipping,
			Set<OrderDetailBean> orderDetailBean, MemberBean memberBean) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.memberid = memberid;
		this.total = total;
		this.shipping = shipping;
		this.orderDetailBean = orderDetailBean;
		this.memberBean = memberBean;
	}
	public OrderListBean(Integer orderid, String date, Integer memberid, Integer total, String shipping) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.memberid = memberid;
		this.total = total;
		this.shipping = shipping;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public Set<OrderDetailBean> getOrderDetailBean() {
		return orderDetailBean;
	}
	public void setOrderDetailBean(Set<OrderDetailBean> orderDetailBean) {
		this.orderDetailBean = orderDetailBean;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	
	
	
}

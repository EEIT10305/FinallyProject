package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="order_list")
public class OrderListBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderid;
	@Column(nullable=false)
	private String date;
	@Column(nullable=false)
	private Integer memberid;
	@Column(nullable=false)
	private Integer total;
	@Column(nullable=false)
	private String shipping;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String statu;
	@Column(nullable=false)
	private String arrive;
	@ManyToOne
	@JoinColumn(name="memberid",insertable=false,updatable=false)
	private MemberBean memberBean;
	
	public OrderListBean() {
		super();
	}
	public OrderListBean(Integer orderid, String date, Integer memberid, Integer total, String shipping,
			String arrive,String statu,String address,MemberBean memberBean) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.memberid = memberid;
		this.total = total;
		this.shipping = shipping;
		this.address = address;
		this.arrive = arrive;
		this.statu = statu;
		this.memberBean = memberBean;
	}
	public OrderListBean(Integer orderid,String address,String arrive, String date, Integer memberid, String shipping, Integer total,String statu) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.memberid = memberid;
		this.total = total;
		this.shipping = shipping;
		this.statu = statu;
		this.address = address;
		this.arrive = arrive;
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
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	@Override
	public String toString() {
		return "OrderListBean [orderid=" + orderid + ", date=" + date + ", memberid=" + memberid + ", total=" + total
				+ ", shipping=" + shipping + ", address=" + address + ", statu=" + statu + ", arrive=" + arrive + "]";
	}

	
	
	
}

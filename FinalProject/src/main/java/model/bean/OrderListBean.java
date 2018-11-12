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
	private String dat;
	@Column(nullable=false)
	private Integer memberid;
	@Column(nullable=false)
	private Integer total;
	@Column(nullable=false)
	private String shipping;
	@Column(nullable=false)
	private String addres;
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
	public OrderListBean(Integer orderid, String dat, Integer memberid, Integer total, String shipping,
			String arrive,String statu,String addres,MemberBean memberBean) {
		super();
		this.orderid = orderid;
		this.dat = dat;
		this.memberid = memberid;
		this.total = total;
		this.shipping = shipping;
		this.addres = addres;
		this.arrive = arrive;
		this.statu = statu;
		this.memberBean = memberBean;
	}
	public OrderListBean(Integer orderid,String addres,String arrive, String dat, Integer memberid, String shipping, Integer total,String statu) {
		super();
		this.orderid = orderid;
		this.dat = dat;
		this.memberid = memberid;
		this.total = total;
		this.shipping = shipping;
		this.statu = statu;
		this.addres = addres;
		this.arrive = arrive;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
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
	
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
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
		return "OrderListBean [orderid=" + orderid + ", date=" + dat + ", memberid=" + memberid + ", total=" + total
				+ ", shipping=" + shipping + ", address=" + addres + ", statu=" + statu + ", arrive=" + arrive + "]";
	}

	
	
	
}

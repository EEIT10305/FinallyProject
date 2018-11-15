package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetailBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer order_detail_id;
	@Column(nullable=false)
	private Integer orderid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private String brand;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private String model;
	@Column(nullable=false)
	private Integer amount;
	@Column(nullable=false)
	private Integer price;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="orderid",insertable=false,updatable=false)
	private OrderListBean orderListBean ;
	public OrderDetailBean() {
		super();
	}
	public OrderDetailBean(Integer order_detail_id, Integer orderid, Integer proid, String brand, String category,
			String model, Integer amount, Integer price, OrderListBean orderListBean) {
		super();
		this.order_detail_id = order_detail_id;
		this.orderid = orderid;
		this.proid = proid;
		this.brand = brand;
		this.category = category;
		this.model = model;
		this.amount = amount;
		this.price = price;
		this.orderListBean = orderListBean;
	}
	public OrderDetailBean(Integer order_detail_id, Integer orderid, Integer proid, String brand, String category,
			String model, Integer amount, Integer price) {
		super();
		this.order_detail_id = order_detail_id;
		this.orderid = orderid;
		this.proid = proid;
		this.brand = brand;
		this.category = category;
		this.model = model;
		this.amount = amount;
		this.price = price;
	}
	public Integer getOrder_detail_id() {
		return order_detail_id;
	}
	public void setOrder_detail_id(Integer order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public OrderListBean getOrderListBean() {
		return orderListBean;
	}
	public void setOrderListBean(OrderListBean orderListBean) {
		this.orderListBean = orderListBean;
	}
	@Override
	public String toString() {
		return "OrderDetailBean [order_detail_id=" + order_detail_id + ", orderid=" + orderid + ", proid=" + proid
				+ ", brand=" + brand + ", category=" + category + ", model=" + model + ", amount=" + amount + ", price="
				+ price + "]";
	}
	
	
}

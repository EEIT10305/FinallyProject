package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="cart_detail")
public class CartDetailBean {
	@Id
	private Integer id;
	@Column(nullable=false)
	private Integer cartid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private Integer amount;
	@ManyToOne
	@JoinColumn(name="cartid",insertable=false,updatable=false)
	private CartBean cartBean;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public CartDetailBean() {
		super();
	}
	public CartDetailBean(Integer id, Integer cartid, Integer proid, Integer amount, CartBean cartBean,
			ProductBean productBean) {
		super();
		this.id = id;
		this.cartid = cartid;
		this.proid = proid;
		this.amount = amount;
		this.cartBean = cartBean;
		this.productBean = productBean;
	}
	public CartDetailBean(Integer id, Integer cartid, Integer proid, Integer amount) {
		super();
		this.id = id;
		this.cartid = cartid;
		this.proid = proid;
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCartid() {
		return cartid;
	}
	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public CartBean getCartBean() {
		return cartBean;
	}
	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	
	
}

package model.bean;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pingin")
public class PinginBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pinginid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Integer price;
	@Column(nullable=false)
	private String status;
	
	private Blob picture;
	
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="pinginBean")
	private Set<PinginDetailBean> pinginDetail ;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public PinginBean() {
		super();
	}
	public PinginBean(Integer pinginid, Integer proid, String name, Integer price, String status, Blob picture,
			Set<PinginDetailBean> pinginDetail, ProductBean productBean) {
		super();
		this.pinginid = pinginid;
		this.proid = proid;
		this.name = name;
		this.price = price;
		this.status = status;
		this.picture = picture;
		this.pinginDetail = pinginDetail;
		this.productBean = productBean;
	}
	public PinginBean(Integer pinginid, Integer proid, String name, Integer price, String status, Blob picture) {
		super();
		this.pinginid = pinginid;
		this.proid = proid;
		this.name = name;
		this.price = price;
		this.status = status;
		this.picture = picture;
	}
	public Integer getPinginid() {
		return pinginid;
	}
	public void setPinginid(Integer pinginid) {
		this.pinginid = pinginid;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public Set<PinginDetailBean> getPinginDetail() {
		return pinginDetail;
	}
	public void setPinginDetail(Set<PinginDetailBean> pinginDetail) {
		this.pinginDetail = pinginDetail;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	
	
	
}

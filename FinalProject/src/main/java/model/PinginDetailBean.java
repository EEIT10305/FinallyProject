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

@Entity
@Table(name="pingin_detail")
public class PinginDetailBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pingin_detail_id;
	@Column(nullable=false)
	private Integer pinginid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String brand;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private String model;
	@Column(nullable=false)
	private Integer price;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="pinginid",insertable=false,updatable=false)
	private PinginBean pinginBean ;
	public PinginDetailBean() {
		super();
	}
	public PinginDetailBean(Integer pingin_detail_id, Integer pinginid, String name, String brand, String category,
			String model, Integer price, PinginBean pinginBean) {
		super();
		this.pingin_detail_id = pingin_detail_id;
		this.pinginid = pinginid;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.model = model;
		this.price = price;
		this.pinginBean = pinginBean;
	}
	public PinginDetailBean(Integer pingin_detail_id, Integer pinginid, String name, String brand, String category,
			String model, Integer price) {
		super();
		this.pingin_detail_id = pingin_detail_id;
		this.pinginid = pinginid;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.model = model;
		this.price = price;
	}
	public Integer getPingin_detail_id() {
		return pingin_detail_id;
	}
	public void setPingin_detail_id(Integer pingin_detail_id) {
		this.pingin_detail_id = pingin_detail_id;
	}
	public Integer getPinginid() {
		return pinginid;
	}
	public void setPinginid(Integer pinginid) {
		this.pinginid = pinginid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public PinginBean getPinginBean() {
		return pinginBean;
	}
	public void setPinginBean(PinginBean pinginBean) {
		this.pinginBean = pinginBean;
	}
	
}

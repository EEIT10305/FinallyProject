package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mb")
public class MbBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer mb_id;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private String brand;
	@Column(nullable=false)
	private Integer categoryid;
	@Column(nullable=false)
	private String model;
	@Column(nullable=false)
	private Integer price;
	@Column(nullable=false)
	private String statu;
	@Column(nullable=false)
	private String feet;
	@Column(nullable=false)
	private String ddr;
	@Column(nullable=false)
	private Integer psu;
	@Column(nullable=false)
	private String size;
	@ManyToOne
	@JoinColumn(name="categoryid",insertable=false,updatable=false)
	private CategoryBean categoryBean;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public MbBean() {
		super();
	}
	public MbBean(Integer mb_id, Integer proid, String brand, Integer categoryid, String model, Integer price,
			String statu, String feet, String ddr, Integer psu, String size, CategoryBean categoryBean,
			ProductBean productBean) {
		super();
		this.mb_id = mb_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.statu = statu;
		this.feet = feet;
		this.ddr = ddr;
		this.psu = psu;
		this.size = size;
		this.categoryBean = categoryBean;
		this.productBean = productBean;
	}
	public MbBean(Integer mb_id,  String brand, Integer categoryid, String ddr,String feet,String model, Integer price,Integer proid,
			Integer psu, String size,String statu) {
		super();
		this.mb_id = mb_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.statu = statu;
		this.feet = feet;
		this.ddr = ddr;
		this.psu = psu;
		this.size = size;
	}
	public Integer getMb_id() {
		return mb_id;
	}
	public void setMb_id(Integer mb_id) {
		this.mb_id = mb_id;
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
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
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
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getFeet() {
		return feet;
	}
	public void setFeet(String feet) {
		this.feet = feet;
	}
	public String getDdr() {
		return ddr;
	}
	public void setDdr(String ddr) {
		this.ddr = ddr;
	}
	public Integer getPsu() {
		return psu;
	}
	public void setPsu(Integer psu) {
		this.psu = psu;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	
}

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
@Table(name="vga")
public class VgaBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vga_id;
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
	private Integer psu;
	@ManyToOne
	@JoinColumn(name="categoryid",insertable=false,updatable=false)
	private CategoryBean categoryBean;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public VgaBean() {
		super();
	}
	public VgaBean(Integer vga_id, Integer proid, String brand, Integer categoryid, String model, Integer price,
			String statu, Integer psu, CategoryBean categoryBean, ProductBean productBean) {
		super();
		this.vga_id = vga_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.statu = statu;
		this.psu = psu;
		this.categoryBean = categoryBean;
		this.productBean = productBean;
	}
	public VgaBean(Integer vga_id,  String brand, Integer categoryid, String model, Integer price,Integer proid,
			Integer psu,String statu ) {
		super();
		this.vga_id = vga_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.statu = statu;
		this.psu = psu;
	}
	public Integer getVga_id() {
		return vga_id;
	}
	public void setVga_id(Integer vga_id) {
		this.vga_id = vga_id;
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
	public Integer getPsu() {
		return psu;
	}
	public void setPsu(Integer psu) {
		this.psu = psu;
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

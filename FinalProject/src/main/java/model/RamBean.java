package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ram")
public class RamBean {
	@Id
	private Integer ram_id;
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
	private String status;
	@Column(nullable=false)
	private String ddr;
	@Column(nullable=false)
	private Integer psu;
	@ManyToOne
	@JoinColumn(name="categoryid",insertable=false,updatable=false)
	private CategoryBean categoryBean;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public RamBean() {
		super();
	}
	public RamBean(Integer ram_id, Integer proid, String brand, Integer categoryid, String model, Integer price,
			String status, String ddr, Integer psu, CategoryBean categoryBean, ProductBean productBean) {
		super();
		this.ram_id = ram_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.status = status;
		this.ddr = ddr;
		this.psu = psu;
		this.categoryBean = categoryBean;
		this.productBean = productBean;
	}
	public RamBean(Integer ram_id, Integer proid, String brand, Integer categoryid, String model, Integer price,
			String status, String ddr, Integer psu) {
		super();
		this.ram_id = ram_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.status = status;
		this.ddr = ddr;
		this.psu = psu;
	}
	public Integer getRam_id() {
		return ram_id;
	}
	public void setRam_id(Integer ram_id) {
		this.ram_id = ram_id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

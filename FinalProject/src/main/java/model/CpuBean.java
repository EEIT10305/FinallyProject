package model;

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

import model.bean.CategoryBean;

@Entity
@Table(name="cpu")
public class CpuBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cpu_id;
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
	private String feet;
	@Column(nullable=false)
	private Integer psu;
	@ManyToOne
	@JoinColumn(name="categoryid",insertable=false,updatable=false)
	private CategoryBean categoryBean;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	
	public CpuBean() {
		super();
	}
	
	public CpuBean(Integer cpu_id, Integer proid, String brand, Integer categoryid, String model, Integer price,
			String status, String feet, Integer psu, CategoryBean categoryBean, ProductBean productBean) {
		super();
		this.cpu_id = cpu_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.status = status;
		this.feet = feet;
		this.psu = psu;
		this.categoryBean = categoryBean;
		this.productBean = productBean;
	}
	
	public CpuBean(Integer cpu_id,String brand, Integer categoryid,String feet,String model, Integer price,Integer proid,
			Integer psu,String status ) {
		super();
		this.cpu_id = cpu_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.status = status;
		this.feet = feet;
		this.psu = psu;
	}
	public Integer getCpu_id() {
		return cpu_id;
	}
	public void setCpu_id(Integer cpu_id) {
		this.cpu_id = cpu_id;
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
	public String getFeet() {
		return feet;
	}
	public void setFeet(String feet) {
		this.feet = feet;
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

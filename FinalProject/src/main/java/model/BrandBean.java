package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class BrandBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer brandid;
	@Column(nullable=false)
	private String brand;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="brandBean")
	private Set<ProductBean> productBean ;
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Set<ProductBean> getProductBean() {
		return productBean;
	}
	public void setProductBean(Set<ProductBean> productBean) {
		this.productBean = productBean;
	}
	public BrandBean(Integer brandid, String brand, Set<ProductBean> productBean) {
		super();
		this.brandid = brandid;
		this.brand = brand;
		this.productBean = productBean;
	}
	@Override
	public String toString() {
		return "BrandBean [brandid=" + brandid + ", brand=" + brand + ", productBean=" + productBean + "]";
	}
	public BrandBean(Integer brandid, String brand) {
		super();
		this.brandid = brandid;
		this.brand = brand;
	}
	
	public BrandBean() {
		super();
	}
}

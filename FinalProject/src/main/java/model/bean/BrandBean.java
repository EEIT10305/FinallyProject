package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class BrandBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer brandid;
	@Column(nullable=false)
	private String brand;
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
	
	public BrandBean(Integer brandid, String brand) {
		super();
		this.brandid = brandid;
		this.brand = brand;
		
	}
	@Override
	public String toString() {
		return "BrandBean [brandid=" + brandid + ", brand=" + brand + " + ";
	}

	public BrandBean() {
		super();
	}
	
}

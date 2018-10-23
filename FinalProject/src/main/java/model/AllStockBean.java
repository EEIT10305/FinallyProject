package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="all_stock")
public class AllStockBean {
	@Id
	private Integer all_stock_id;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private String brand;
	@Column(nullable=false)
	private Integer categoryid;
	@Column(nullable=false)
	private String model;
	@Column(nullable=false)
	private Integer unitprice;
	@Column(nullable=false)
	private Integer stock;
	@Column(nullable=false)
	private String status;
	
	public Integer getAll_stock_id() {
		return all_stock_id;
	}
	public void setAll_stock_id(Integer all_stock_id) {
		this.all_stock_id = all_stock_id;
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
	public Integer getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AllStockBean(Integer all_stock_id, Integer proid, String brand, Integer categoryid, String model,
			Integer unitprice, Integer stock, String status) {
		super();
		this.all_stock_id = all_stock_id;
		this.proid = proid;
		this.brand = brand;
		this.categoryid = categoryid;
		this.model = model;
		this.unitprice = unitprice;
		this.stock = stock;
		this.status = status;
	}
	
	
	
	public AllStockBean() {
		super();
	}
	
	
}

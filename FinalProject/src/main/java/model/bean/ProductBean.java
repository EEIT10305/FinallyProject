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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer proid;
	@Column(nullable=false)
	private Integer brandid;
	@Column(nullable=false)
	private Integer categoryid;
	@Column(nullable=false)
	private String model;
	@Column(nullable=false)
	private Integer price;
	@Column(nullable=false)
	private Integer hot;
	
	private Blob picture;
	@Column(nullable=false)
	private String statu;
	@ManyToOne
	@JoinColumn(name="categoryid",insertable=false,updatable=false)
	private CategoryBean categoryBean;
	@ManyToOne
	@JoinColumn(name="brandid",insertable=false,updatable=false)
	private BrandBean brandBean;
	
	public ProductBean() {
		super();
	}
	public ProductBean(Integer proid, Integer brandid, Integer categoryid, String model, Integer price,Integer hot, Blob picture,
			String statu,CategoryBean categoryBean, BrandBean brandBean) {
		super();
		this.proid = proid;
		this.brandid = brandid;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.picture = picture;
		this.hot = hot ;
		this.statu = statu;
		this.categoryBean = categoryBean;
		this.brandBean = brandBean;
	}
	public ProductBean(Integer proid, Integer brandid, Integer categoryid,Integer hot, String model, Integer price ,Blob picture,
			String statu) {
		super();
		this.proid = proid;
		this.brandid = brandid;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.picture = picture;
		this.hot = hot ;
		this.statu = statu;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
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
	public Blob getPicture() {
		return picture;
	}
	public Integer getHot() {
		return hot;
	}
	public void setHot(Integer hot) {
		this.hot = hot;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	public BrandBean getBrandBean() {
		return brandBean;
	}
	public void setBrandBean(BrandBean brandBean) {
		this.brandBean = brandBean;
	}
	
	
}

package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class ImportDetailBean {
	@Id
	private Integer improt_detailid;
	@Column(nullable=false)
	private Integer improtid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private Integer amount;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public ImportDetailBean() {
		super();
	}
	public ImportDetailBean(Integer improt_detailid, Integer improtid, Integer proid, Integer amount,
			ProductBean productBean) {
		super();
		this.improt_detailid = improt_detailid;
		this.improtid = improtid;
		this.proid = proid;
		this.amount = amount;
		this.productBean = productBean;
	}
	public ImportDetailBean(Integer improt_detailid, Integer improtid, Integer proid, Integer amount) {
		super();
		this.improt_detailid = improt_detailid;
		this.improtid = improtid;
		this.proid = proid;
		this.amount = amount;
	}
	public Integer getImprot_detailid() {
		return improt_detailid;
	}
	public void setImprot_detailid(Integer improt_detailid) {
		this.improt_detailid = improt_detailid;
	}
	public Integer getImprotid() {
		return improtid;
	}
	public void setImprotid(Integer improtid) {
		this.improtid = improtid;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	
	
	
}

package model.bean;

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
@Table(name="importdetail")
public class ImportDetailBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer improt_detailid;
	@Column(nullable=false)
	private Integer improtid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private Integer amount;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="improtid",insertable=false,updatable=false)
	private ImportBean importBean ;
	public ImportDetailBean() {
		super();
	}
	public ImportDetailBean(Integer improt_detailid, Integer improtid, Integer proid, Integer amount,
			ProductBean productBean,ImportBean importBean) {
		super();
		this.improt_detailid = improt_detailid;
		this.improtid = improtid;
		this.proid = proid;
		this.amount = amount;
		this.productBean = productBean;
		this.importBean = importBean;
	}
	public ImportDetailBean(Integer improt_detailid, Integer amount, Integer improtid, Integer proid) {
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

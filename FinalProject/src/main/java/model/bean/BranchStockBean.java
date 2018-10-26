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
@Table(name="branch_stock")
public class BranchStockBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer branch_stock_id;
	@Column(nullable=false)
	private Integer branchid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private Integer amount;
	@Column(nullable=false)
	private String statu;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="branchid",insertable=false,updatable=false)
	private BranchBean branchBean ;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="proid",insertable=false,updatable=false)
	private ProductBean productBean ;
	public Integer getBranch_stock_id() {
		return branch_stock_id;
	}
	public void setBranch_stock_id(Integer branch_stock_id) {
		this.branch_stock_id = branch_stock_id;
	}
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
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
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public BranchBean getBranchBean() {
		return branchBean;
	}
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public BranchStockBean(Integer branch_stock_id, Integer branchid, Integer proid, Integer amount, String statu,
			BranchBean branchBean, ProductBean productBean) {
		super();
		this.branch_stock_id = branch_stock_id;
		this.branchid = branchid;
		this.proid = proid;
		this.amount = amount;
		this.statu = statu;
		this.branchBean = branchBean;
		this.productBean = productBean;
	}
	
	public BranchStockBean(Integer branch_stock_id, Integer amount, Integer branchid, Integer proid, String statu) {
		super();
		this.branch_stock_id = branch_stock_id;
		this.branchid = branchid;
		this.proid = proid;
		this.amount = amount;
		this.statu = statu;
	}
	public BranchStockBean() {
		super();
	}
	
	
	
}

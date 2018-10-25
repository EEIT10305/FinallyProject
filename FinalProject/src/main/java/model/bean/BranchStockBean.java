package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="branch_stock")
public class BranchStockBean {
	
	@Id
	private Integer branch_stock_id;
	@Column(nullable=false)
	private Integer branchid;
	@Column(nullable=false)
	private Integer proid;
	@Column(nullable=false)
	private Integer amount;
	@Column(nullable=false)
	private String status;
	@OneToOne(cascade=CascadeType.MERGE)
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public BranchStockBean(Integer branch_stock_id, Integer branchid, Integer proid, Integer amount, String status,
			BranchBean branchBean, ProductBean productBean) {
		super();
		this.branch_stock_id = branch_stock_id;
		this.branchid = branchid;
		this.proid = proid;
		this.amount = amount;
		this.status = status;
		this.branchBean = branchBean;
		this.productBean = productBean;
	}
	
	public BranchStockBean(Integer branch_stock_id, Integer branchid, Integer proid, Integer amount, String status) {
		super();
		this.branch_stock_id = branch_stock_id;
		this.branchid = branchid;
		this.proid = proid;
		this.amount = amount;
		this.status = status;
	}
	public BranchStockBean() {
		super();
	}
	
	
	
}

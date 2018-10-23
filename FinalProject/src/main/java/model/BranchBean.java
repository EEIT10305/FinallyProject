package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class BranchBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer branchid;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String phone;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="branchBean")
	private BranchStockBean branchStockBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="branchBeanin")
	private TransferBean transferBeanin ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="branchBeanout")
	private TransferBean transferBeanout ;
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BranchStockBean getBranchStockBean() {
		return branchStockBean;
	}
	public void setBranchStockBean(BranchStockBean branchStockBean) {
		this.branchStockBean = branchStockBean;
	}
	public TransferBean getTransferBeanin() {
		return transferBeanin;
	}
	public void setTransferBeanin(TransferBean transferBeanin) {
		this.transferBeanin = transferBeanin;
	}
	public TransferBean getTransferBeanout() {
		return transferBeanout;
	}
	public void setTransferBeanout(TransferBean transferBeanout) {
		this.transferBeanout = transferBeanout;
	}
	public BranchBean(Integer branchid, String name, String address, String phone, BranchStockBean branchStockBean,
			TransferBean transferBeanin, TransferBean transferBeanout) {
		super();
		this.branchid = branchid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.branchStockBean = branchStockBean;
		this.transferBeanin = transferBeanin;
		this.transferBeanout = transferBeanout;
	}
	
	public BranchBean(Integer branchid, String name, String address, String phone) {
		super();
		this.branchid = branchid;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public BranchBean() {
		super();
	}
	
}

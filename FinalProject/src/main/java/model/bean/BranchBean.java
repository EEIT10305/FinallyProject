package model.bean;

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
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="branchBean")
	private Set<BranchStockBean> branchStockBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="branchBeanin")
	private Set<TransferBean> transferBeanin ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="branchBeanout")
	private Set<TransferBean> transferBeanout ;
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
	public Set<BranchStockBean> getBranchStockBean() {
		return branchStockBean;
	}
	public void setBranchStockBean(Set<BranchStockBean> branchStockBean) {
		this.branchStockBean = branchStockBean;
	}
	public Set<TransferBean> getTransferBeanin() {
		return transferBeanin;
	}
	public void setTransferBeanin(Set<TransferBean> transferBeanin) {
		this.transferBeanin = transferBeanin;
	}
	public Set<TransferBean> getTransferBeanout() {
		return transferBeanout;
	}
	public void setTransferBeanout(Set<TransferBean> transferBeanout) {
		this.transferBeanout = transferBeanout;
	}
	public BranchBean(Integer branchid, String name, String address, String phone, Set<BranchStockBean> branchStockBean,
			Set<TransferBean> transferBeanin, Set<TransferBean> transferBeanout) {
		super();
		this.branchid = branchid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.branchStockBean = branchStockBean;
		this.transferBeanin = transferBeanin;
		this.transferBeanout = transferBeanout;
	}
	
	public BranchBean(Integer branchid, String address, String name, String phone) {
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

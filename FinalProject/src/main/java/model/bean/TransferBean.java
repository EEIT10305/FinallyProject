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
@Table(name = "transfer")
public class TransferBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transferid;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private Integer proid;
	@Column(nullable = false)
	private Integer amount;
	@Column(nullable = false)
	private Integer staff_id;
	@Column(nullable = false)
	private Integer branchidin;
	@Column(nullable = false)
	private Integer branchidout;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "branchidin", insertable = false, updatable = false)
	private BranchBean branchBeanin;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "branchidout", insertable = false, updatable = false)
	private BranchBean branchBeanout;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "proid", insertable = false, updatable = false)
	private ProductBean productBean;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="staff_id",insertable=false,updatable=false)
	private StaffBean staffBean ;

	public TransferBean() {
		super();
	}

	public TransferBean(Integer transferid, String date, Integer proid, Integer amount, Integer staff_id,Integer branchidin,
			Integer branchidout, BranchBean branchBeanin, BranchBean branchBeanout, ProductBean productBean,StaffBean staffBean) {
		super();
		this.transferid = transferid;
		this.date = date;
		this.proid = proid;
		this.amount = amount;
		this.staff_id = staff_id;
		this.branchidin = branchidin;
		this.branchidout = branchidout;
		this.branchBeanin = branchBeanin;
		this.branchBeanout = branchBeanout;
		this.productBean = productBean;
		this.staffBean = staffBean;
	}

	

	public TransferBean(Integer transferid, Integer amount, Integer branchidin, Integer branchidout, String date,
			Integer proid,Integer staff_id) {
		super();
		this.transferid = transferid;
		this.date = date;
		this.proid = proid;
		this.amount = amount;
		this.branchidin = branchidin;
		this.branchidout = branchidout;
		this.staff_id = staff_id;
	}

	public Integer getTransferid() {
		return transferid;
	}

	public void setTransferid(Integer transferid) {
		this.transferid = transferid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}

	public Integer getBranchidin() {
		return branchidin;
	}

	public void setBranchidin(Integer branchidin) {
		this.branchidin = branchidin;
	}

	public Integer getBranchidout() {
		return branchidout;
	}

	public void setBranchidout(Integer branchidout) {
		this.branchidout = branchidout;
	}

	public BranchBean getBranchBeanin() {
		return branchBeanin;
	}

	public void setBranchBeanin(BranchBean branchBeanin) {
		this.branchBeanin = branchBeanin;
	}

	public BranchBean getBranchBeanout() {
		return branchBeanout;
	}

	public void setBranchBeanout(BranchBean branchBeanout) {
		this.branchBeanout = branchBeanout;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public StaffBean getStaffBean() {
		return staffBean;
	}

	public void setStaffBean(StaffBean staffBean) {
		this.staffBean = staffBean;
	}

}

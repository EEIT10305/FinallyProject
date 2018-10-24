package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="import")
public class ImportBean {
	@Id
	private Integer improtid;
	@Column(nullable=false)
	private String orderdate;
	@Column(nullable=false)
	private Integer arrivedate;
	@Column(nullable=false)
	private String status;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="improt_detailid")
	private Set<ImportDetailBean> importDetailBean ;
	public ImportBean() {
		super();
	}
	public ImportBean(Integer improtid, String orderdate, Integer arrivedate, String status,
			Set<ImportDetailBean> importDetailBean) {
		super();
		this.improtid = improtid;
		this.orderdate = orderdate;
		this.arrivedate = arrivedate;
		this.status = status;
		this.importDetailBean = importDetailBean;
	}
	public ImportBean(Integer improtid, String orderdate, Integer arrivedate, String status) {
		super();
		this.improtid = improtid;
		this.orderdate = orderdate;
		this.arrivedate = arrivedate;
		this.status = status;
	}
	public Integer getImprotid() {
		return improtid;
	}
	public void setImprotid(Integer improtid) {
		this.improtid = improtid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public Integer getArrivedate() {
		return arrivedate;
	}
	public void setArrivedate(Integer arrivedate) {
		this.arrivedate = arrivedate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<ImportDetailBean> getImportDetailBean() {
		return importDetailBean;
	}
	public void setImportDetailBean(Set<ImportDetailBean> importDetailBean) {
		this.importDetailBean = importDetailBean;
	}

}

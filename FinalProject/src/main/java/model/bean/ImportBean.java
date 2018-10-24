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
@Table(name="import")
public class ImportBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer improtid;
	@Column(nullable=false)
	private String orderdate;
	@Column(nullable=false)
	private String arrivedate;
	@Column(nullable=false)
	private String status;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="improt_detailid")
	private Set<ImportDetailBean> importDetailBean ;
	public ImportBean() {
		super();
	}
	public ImportBean(Integer improtid, String orderdate, String arrivedate, String status,
			Set<ImportDetailBean> importDetailBean) {
		super();
		this.improtid = improtid;
		this.orderdate = orderdate;
		this.arrivedate = arrivedate;
		this.status = status;
		this.importDetailBean = importDetailBean;
	}
	public ImportBean(Integer improtid, String orderdate, String arrivedate, String status) {
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
	public String getArrivedate() {
		return arrivedate;
	}
	public void setArrivedate(String arrivedate) {

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

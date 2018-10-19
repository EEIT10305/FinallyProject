package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryBean {
	@Id
	private Integer categoryid;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private String code;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<MbBean> mbBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<CpuBean> cpuBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<StorageBean> storageBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<VgaBean> vgaBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<CabinetBean> cabinetBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<PowerSupplierBean> powerSupplierBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<RamBean> ramBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="categoryBean")
	private Set<ProductBean> productBean ;
	public CategoryBean() {
		super();
	}
	public CategoryBean(Integer categoryid, String category, String code, Set<MbBean> mbBean, Set<CpuBean> cpuBean,
			Set<StorageBean> storageBean, Set<VgaBean> vgaBean, Set<CabinetBean> cabinetBean,
			Set<PowerSupplierBean> powerSupplierBean, Set<RamBean> ramBean, Set<ProductBean> productBean) {
		super();
		this.categoryid = categoryid;
		this.category = category;
		this.code = code;
		this.mbBean = mbBean;
		this.cpuBean = cpuBean;
		this.storageBean = storageBean;
		this.vgaBean = vgaBean;
		this.cabinetBean = cabinetBean;
		this.powerSupplierBean = powerSupplierBean;
		this.ramBean = ramBean;
		this.productBean = productBean;
	}
	public CategoryBean(Integer categoryid, String category, String code) {
		super();
		this.categoryid = categoryid;
		this.category = category;
		this.code = code;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Set<MbBean> getMbBean() {
		return mbBean;
	}
	public void setMbBean(Set<MbBean> mbBean) {
		this.mbBean = mbBean;
	}
	public Set<CpuBean> getCpuBean() {
		return cpuBean;
	}
	public void setCpuBean(Set<CpuBean> cpuBean) {
		this.cpuBean = cpuBean;
	}
	public Set<StorageBean> getStorageBean() {
		return storageBean;
	}
	public void setStorageBean(Set<StorageBean> storageBean) {
		this.storageBean = storageBean;
	}
	public Set<VgaBean> getVgaBean() {
		return vgaBean;
	}
	public void setVgaBean(Set<VgaBean> vgaBean) {
		this.vgaBean = vgaBean;
	}
	public Set<CabinetBean> getCabinetBean() {
		return cabinetBean;
	}
	public void setCabinetBean(Set<CabinetBean> cabinetBean) {
		this.cabinetBean = cabinetBean;
	}
	public Set<PowerSupplierBean> getPowerSupplierBean() {
		return powerSupplierBean;
	}
	public void setPowerSupplierBean(Set<PowerSupplierBean> powerSupplierBean) {
		this.powerSupplierBean = powerSupplierBean;
	}
	public Set<RamBean> getRamBean() {
		return ramBean;
	}
	public void setRamBean(Set<RamBean> ramBean) {
		this.ramBean = ramBean;
	}
	public Set<ProductBean> getProductBean() {
		return productBean;
	}
	public void setProductBean(Set<ProductBean> productBean) {
		this.productBean = productBean;
	}
	
	
	
}

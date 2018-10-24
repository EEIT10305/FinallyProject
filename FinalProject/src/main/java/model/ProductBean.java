package model;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer proid;
	@Column(nullable=false)
	private Integer brandid;
	@Column(nullable=false)
	private Integer categoryid;
	@Column(nullable=false)
	private String model;
	@Column(nullable=false)
	private Integer price;
	private Blob picture;
	@Column(nullable=false)
	private String status;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private PinginBean pinginBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="productBean")
	private Set<TransferBean> transferBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private BranchStockBean branchStockBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="productBean")
	private Set<CartDetailBean> cartDetailBean ;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="productBean")
	private Set<WishBean> wishBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private MbBean mbBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private CpuBean cpuBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private StorageBean storageBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private VgaBean vgaBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private CabinetBean cabinetBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private PowerSupplierBean powerSupplierBean ;
	@OneToOne(cascade=CascadeType.MERGE,mappedBy="productBean")
	private RamBean ramBean ;
	@ManyToOne
	@JoinColumn(name="categoryid",insertable=false,updatable=false)
	private CategoryBean categoryBean;
	@ManyToOne
	@JoinColumn(name="brandid",insertable=false,updatable=false)
	private BrandBean brandBean;
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="productBean")
	private Set<ImportDetailBean> importDetailBean ;
	public ProductBean() {
		super();
	}
	public ProductBean(Integer proid, Integer brandid, Integer categoryid, String model, Integer price, Blob picture,
			String status, PinginBean pinginBean, Set<TransferBean> transferBean, BranchStockBean branchStockBean,
			Set<CartDetailBean> cartDetailBean, Set<WishBean> wishBean, MbBean mbBean, CpuBean cpuBean, StorageBean storageBean,
			VgaBean vgaBean, CabinetBean cabinetBean, PowerSupplierBean powerSupplierBean, RamBean ramBean,
			CategoryBean categoryBean, BrandBean brandBean, Set<ImportDetailBean> importDetailBean) {
		super();
		this.proid = proid;
		this.brandid = brandid;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.picture = picture;
		this.status = status;
		this.pinginBean = pinginBean;
		this.transferBean = transferBean;
		this.branchStockBean = branchStockBean;
		this.cartDetailBean = cartDetailBean;
		this.wishBean = wishBean;
		this.mbBean = mbBean;
		this.cpuBean = cpuBean;
		this.storageBean = storageBean;
		this.vgaBean = vgaBean;
		this.cabinetBean = cabinetBean;
		this.powerSupplierBean = powerSupplierBean;
		this.ramBean = ramBean;
		this.categoryBean = categoryBean;
		this.brandBean = brandBean;
		this.importDetailBean = importDetailBean;
	}
	public ProductBean(Integer proid, Integer brandid, Integer categoryid, String model, Integer price, Blob picture,
			String status) {
		super();
		this.proid = proid;
		this.brandid = brandid;
		this.categoryid = categoryid;
		this.model = model;
		this.price = price;
		this.picture = picture;
		this.status = status;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Integer getBrandid() {
		return brandid;
	}
	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PinginBean getPinginBean() {
		return pinginBean;
	}
	public void setPinginBean(PinginBean pinginBean) {
		this.pinginBean = pinginBean;
	}
	public Set<TransferBean> getTransferBean() {
		return transferBean;
	}
	public void setTransferBean(Set<TransferBean> transferBean) {
		this.transferBean = transferBean;
	}
	public BranchStockBean getBranchStockBean() {
		return branchStockBean;
	}
	public void setBranchStockBean(BranchStockBean branchStockBean) {
		this.branchStockBean = branchStockBean;
	}
	public Set<CartDetailBean> getCartDetailBean() {
		return cartDetailBean;
	}
	public void setCartDetailBean(Set<CartDetailBean> cartDetailBean) {
		this.cartDetailBean = cartDetailBean;
	}
	public Set<WishBean> getWishBean() {
		return wishBean;
	}
	public void setWishBean(Set<WishBean> wishBean) {
		this.wishBean = wishBean;
	}
	public MbBean getMbBean() {
		return mbBean;
	}
	public void setMbBean(MbBean mbBean) {
		this.mbBean = mbBean;
	}
	public CpuBean getCpuBean() {
		return cpuBean;
	}
	public void setCpuBean(CpuBean cpuBean) {
		this.cpuBean = cpuBean;
	}
	public StorageBean getStorageBean() {
		return storageBean;
	}
	public void setStorageBean(StorageBean storageBean) {
		this.storageBean = storageBean;
	}
	public VgaBean getVgaBean() {
		return vgaBean;
	}
	public void setVgaBean(VgaBean vgaBean) {
		this.vgaBean = vgaBean;
	}
	public CabinetBean getCabinetBean() {
		return cabinetBean;
	}
	public void setCabinetBean(CabinetBean cabinetBean) {
		this.cabinetBean = cabinetBean;
	}
	public PowerSupplierBean getPowerSupplierBean() {
		return powerSupplierBean;
	}
	public void setPowerSupplierBean(PowerSupplierBean powerSupplierBean) {
		this.powerSupplierBean = powerSupplierBean;
	}
	public RamBean getRamBean() {
		return ramBean;
	}
	public void setRamBean(RamBean ramBean) {
		this.ramBean = ramBean;
	}
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	public BrandBean getBrandBean() {
		return brandBean;
	}
	public void setBrandBean(BrandBean brandBean) {
		this.brandBean = brandBean;
	}
	public Set<ImportDetailBean> getImportDetailBean() {
		return importDetailBean;
	}
	public void setImportDetailBean(Set<ImportDetailBean> importDetailBean) {
		this.importDetailBean = importDetailBean;
	}
	
	
}

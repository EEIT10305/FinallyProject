package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class StaffBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer staff_id;
	@Column(nullable=false)
	private String empname;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String emppassword;
	@Column(nullable=false)
	private String permission;
	@Column(nullable=false)
	private String empaddress;
	@Column(nullable=false)
	private String phone;
	
	public StaffBean() {
		super();
	}
	public StaffBean(Integer staff_id, String empaddress, String email, String empname, String emppassword, String permission, String phone) {
		super();
		this.staff_id = staff_id;
		this.empname = empname;
		this.email = email;
		this.emppassword = emppassword;
		this.permission = permission;
		this.empaddress = empaddress;
		this.phone = phone;
	}
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	public String getName() {
		return empname;
	}
	public void setName(String empname) {
		this.empname = empname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return emppassword;
	}
	public void setPassword(String emppassword) {
		this.emppassword = emppassword;
	}
	public String getAddress() {
		return empaddress;
	}
	public void setAddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}

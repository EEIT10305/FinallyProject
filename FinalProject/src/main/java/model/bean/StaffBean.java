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
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String permission;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String phone;
	
	public StaffBean() {
		super();
	}
	public StaffBean(Integer staff_id, String address, String email, String name, String password, String permission, String phone) {
		super();
		this.staff_id = staff_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permission = permission;
		this.address = address;
		this.phone = phone;
	}
	public Integer getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}

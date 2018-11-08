package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MemberBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer memberid;//流水號
	
	@Column(nullable=false)
	private String membername;//真實姓名
	
	@Column(nullable=false)
	private String email;//email
	
	@Column(nullable=false)
	private String memberpassword;
	
	@Column(nullable=false)
	private String permission;
	
	@Column(nullable=false)
	private String memberaddress;
	
	@Column(nullable=false)
	private String phone;
	
	@Column(nullable=false)
	private String gender;
	
	public MemberBean() {}
	
	public MemberBean(Integer memberid, String membername, String email, String memberpassword, String permission, String memberaddress,
			String phone, String gender) {
		this.memberid = memberid;
		this.membername = membername;
		this.email = email;
		this.memberpassword = memberpassword;
		this.permission = permission;
		this.memberaddress = memberaddress;
		this.phone = phone;
		this.gender = gender;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getmembername() {
		return membername;
	}
	public void setmembername(String membername) {
		this.membername = membername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getmemberpassword() {
		return memberpassword;
	}
	public void setmemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getmemberaddress() {
		return memberaddress;
	}
	public void setmemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberBean [memberid=" + memberid + ", membername=" + membername + ", email=" + email + ", memberpassword=" + memberpassword
				+ ", permission=" + permission + ", memberaddress=" + memberaddress + ", phone=" + phone + ", gender=" + gender
				+ "]";
	}
		
}

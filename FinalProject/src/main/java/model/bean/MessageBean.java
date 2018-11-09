package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="message")
public class MessageBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer message_id;
	@Column(nullable=false)
	private Integer memberidA;
	@Column(nullable=false)
	private Integer memberidB;
	@Column(nullable=false)
	private String dat;
	@Column(nullable=false)
	private String messag;
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String readstatu;
	public MessageBean() {
		super();
	}
	
	public MessageBean(Integer message_id, Integer memberidA, Integer memberidB, String dat, String messag,
			String title, String readstatu) {
		super();
		this.message_id = message_id;
		this.memberidA = memberidA;
		this.memberidB = memberidB;
		this.dat = dat;
		this.messag = messag;
		this.title = title;
		this.readstatu = readstatu;
	}

	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public Integer getMemberidA() {
		return memberidA;
	}
	public void setMemberidA(Integer memberidA) {
		this.memberidA = memberidA;
	}
	public Integer getMemberidB() {
		return memberidB;
	}
	public void setMemberidB(Integer memberidB) {
		this.memberidB = memberidB;
	}
	public String getDat() {
		return dat;
	}
	public void setDat(String dat) {
		this.dat = dat;
	}
	public String getMessag() {
		return messag;
	}
	public void setMessag(String messag) {
		this.messag = messag;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReadstatu() {
		return readstatu;
	}
	public void setReadstatu(String readstatu) {
		this.readstatu = readstatu;
	}
	
	
}

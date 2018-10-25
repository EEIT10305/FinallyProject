package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="message")
public class MessageBean {
	@Id
	private Integer message_id;
	@Column(nullable=false)
	private Integer memberidA;
	@Column(nullable=false)
	private Integer memberidB;
	@Column(nullable=false)
	private String date;
	@Column(nullable=false)
	private String message;
	public MessageBean() {
		super();
	}
	public MessageBean(Integer message_id, Integer memberidA, Integer memberidB, String date, String message) {
		super();
		this.message_id = message_id;
		this.memberidA = memberidA;
		this.memberidB = memberidB;
		this.date = date;
		this.message = message;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

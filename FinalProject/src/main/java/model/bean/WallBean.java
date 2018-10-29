package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wall")
public class WallBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer wallid;
	@Column(nullable=false)
	private String photoname;
	private Integer seq;
	@Column(nullable=false)
	private String status;
	
	public WallBean(Integer wallid, String photoname, Integer seq, String status) {
		super();
		this.wallid = wallid;
		this.photoname = photoname;
		this.seq = seq;
		this.status = status;
	}
	public Integer getWallid() {
		return wallid;
	}
	public void setWallid(Integer wallid) {
		this.wallid = wallid;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

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
	@Override
	public String toString() {
		return "wallid:" + wallid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer wallid;
	@Column(nullable=false)
	private String photosrc;
	private Integer seq;
	@Column(nullable=false)
	private String statu;
	
	public WallBean() {}
	public WallBean(Integer wallid, String photosrc, Integer seq, String statu) {
		super();
		this.wallid = wallid;
		this.photosrc = photosrc;
		this.seq = seq;
		this.statu = statu;
	}
	public Integer getWallid() {
		return wallid;
	}
	public void setWallid(Integer wallid) {
		this.wallid = wallid;
	}
	public String getPhotosrc() {
		return photosrc;
	}
	public void setPhotosrc(String photoname) {
		this.photosrc = photoname;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	
	
}

package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryid;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private String code;
	public CategoryBean() {
		super();
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

}

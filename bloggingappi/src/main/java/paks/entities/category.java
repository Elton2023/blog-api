package paks.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;
	//@Column(length=100,nullable=false)
	private String CatagoryTitle;
	@Column( length=500,nullable=false)
	private String catagoryDescription;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Post> posts =new ArrayList<>();
	
	public category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public category(Integer categoryId, String catagoryTitle, String catagoryDescription) {
		super();
		this.categoryId = categoryId;
		this.CatagoryTitle = catagoryTitle;
		this.catagoryDescription = catagoryDescription;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCatagoryTitle() {
		return CatagoryTitle;
	}


	public void setCatagoryTitle(String catagoryTitle) {
		CatagoryTitle = catagoryTitle;
	}


	public String getCatagoryDescription() {
		return catagoryDescription;
	}


	public void setCatagoryDescription(String catagoryDescription) {
		this.catagoryDescription = catagoryDescription;
	}

 
	
}

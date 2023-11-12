package paks.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class categoryDto {
 
	private Integer categoryId;
	@NotBlank
	@Size(min=4,max=20)
 	private String CatagoryTitle;
	@NotBlank
	@Size(min=4,max=100)
     private String catagoryDescription;
	
	
	public categoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public categoryDto(Integer categoryId, String catagoryTitle, String catagoryDescription) {
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


	@Override
	public String toString() {
		return "categoryDto [categoryId=" + categoryId + ", CatagoryTitle=" + CatagoryTitle + ", catagoryDescription="
				+ catagoryDescription + "]";
	}

 
	
}

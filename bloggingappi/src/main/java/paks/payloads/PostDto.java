package paks.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import paks.entities.Comment;
import paks.entities.User;
import paks.entities.category;

public class PostDto {
 
	private Integer postId;
  	private String	title;
 	private String content;
	private String imageName;
	private Date addedDate;
	 
private categoryDto category;
 
	private UserDto user;

	
	//private Set<Comment> comments ;
	private Set<CommentDto> comments =new HashSet<>();

	
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostDto(String title, String content, String imageName, Date addedDate, categoryDto category, UserDto user,
			Set<CommentDto> comments) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}


	public PostDto(String title, String content, String imageName, Date addedDate, categoryDto category, UserDto user) {
		super();
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}


	public Integer getPostId() {
		return postId;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public Date getAddedDate() {
		return addedDate;
	}


	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}


	public categoryDto getCategory() {
		return category;
	}


	public void setCategory(categoryDto category) {
		this.category = category;
	}


	public UserDto getUser() {
		return user;
	}


	public void setUser(UserDto user) {
		this.user = user;
	}


	public Set<CommentDto> getComments() {
		return comments;
	}


	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}
 

 
 
}

package paks.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import paks.entities.category;
import paks.entities.User;

import javax.persistence.*;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postId;
	@Column(length=19,nullable=false)
	private String	title;
	@Column(length=1000)
	private String content;
	private String imageName;
	private Date addedDate;
	@ManyToOne
	@JoinColumn(name="categoryID")
private category category;
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

@OneToMany(mappedBy ="post",cascade=CascadeType.ALL)
 private Set<Comment> comments =new HashSet<>();
//	private Set<Comment> comments;
	public Post(){
		super();
	}

	public Post(Integer postId, String title, String content, String imageName, Date addedDate,
			paks.entities.category category, User user, Set<Comment> comments) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
		this.comments = comments;
	}

	
	
	public Post(Integer postId, String title, String content, String imageName, Date addedDate,
			paks.entities.category category, User user) {
		super();
		this.postId = postId;
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

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
 
}

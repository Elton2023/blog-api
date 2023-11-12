package paks.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( catalog="bloggingappapi")
public class Comment {//implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 	private int  id;
	private String content;
	@ManyToOne
	private Post post;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comment(String content, Post post) {
		super();
		this.content = content;
		this.post = post;
	}


	public Comment(int id, String content, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
	}


	public int getId() {
		return id;
	}

//
//	public void setId(int id) {
//		this.id = id;
//	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}

 

}

package paks.payloads;

 

import paks.entities.Post;

public class CommentDto {
 
	private int id;
	private String content;
 	 
 	
 	
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CommentDto(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}



	public CommentDto(String content) {
		super();
		this.content = content;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}

 
	
}

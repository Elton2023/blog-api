package paks.services;

import paks.payloads.CommentDto;

public interface CommentServices {

public	CommentDto newComment (CommentDto commentDto,Integer PostId);
	
public	void deleteComment(Integer CommentId);
	
	
public	CommentDto ChangeComment (CommentDto commentDto,Integer CommentId);

	
 	
}

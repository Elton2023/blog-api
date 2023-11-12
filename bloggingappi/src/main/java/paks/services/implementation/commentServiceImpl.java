package paks.services.implementation;

import paks.entities.Comment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paks.entities.Post;
import paks.exceptions.ResourceNotFoundException;
import paks.payloads.CommentDto;
import paks.repository.CommentRepository;
import paks.repository.PostRepository;
import paks.services.CommentServices;
@Service
public class commentServiceImpl  implements CommentServices{
    @Autowired
	private PostRepository pr;
	
    @Autowired
	private CommentRepository cr;
    
    
    @Autowired	
     private ModelMapper mm;

	@Override
	public CommentDto newComment(CommentDto commentDto,Integer PostId) {
		System.out.println("error is here mateeeeeeeeeee");
    Post post =this.pr.findById(PostId).orElseThrow(()->new ResourceNotFoundException("comment","PostId on comment",PostId));
    
    Comment comment =this.mm.map(commentDto,Comment.class);
   comment.setContent(commentDto.getContent());
    comment.setPost(post);
    System.out.println("so her we go brrrrrrrrrrrrrrrr"+post.getContent()+"22222222"+comment.getPost()+"33333333"+commentDto.getContent());

Comment savedComment=     this.cr.save(comment);
   //  this.pr.save(post);
		return  this.mm.map(comment,CommentDto.class);
	}

	@Override
	public void deleteComment(Integer CommentId) {
		System.out.println("deleting comment ..!");
	Comment c =	this.cr.findById(CommentId).orElseThrow(()->new ResourceNotFoundException("comment","CommentId",CommentId));
 this.cr.delete(c);
	System.out.println("deleting process done ..!");

	}

	@Override
	public CommentDto ChangeComment(CommentDto commentDto, Integer CommentId) {
		Comment c =	this.cr.findById(CommentId).orElseThrow(()->new ResourceNotFoundException("comment","CommentId",CommentId));
		CommentDto comment =this.mm.map(c, CommentDto.class);
		    comment.setId(commentDto.getId());
		    comment.setContent(commentDto.getContent());
		    Comment  changedComment =this.mm.map(comment, Comment.class);
		    this.cr.save(changedComment);
 				return comment;
	}

 

}

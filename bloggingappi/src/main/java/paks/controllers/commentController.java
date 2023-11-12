package paks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paks.payloads.CommentDto;
import paks.payloads.apiResponse;
import paks.services.CommentServices;

@RestController
@RequestMapping("comment")
public class commentController {
	
	
	@Autowired
	private CommentServices CommentServices; 
	
	 
	

	
@PostMapping("/addComment/{PostId}")
	public ResponseEntity<CommentDto> newComment(@RequestBody CommentDto CommentDto,@PathVariable("PostId") Integer PostId){
	System.out.println("poi haaaaaaaaaaaaaaaaaaaaaaa "+CommentDto.getContent() + "  post id is "+PostId);
	CommentDto cd=	this.CommentServices.newComment(CommentDto,PostId);

	 
	return  ResponseEntity.status(HttpStatus.CREATED).body(cd);
	}
	

@DeleteMapping("/delete/{CommentId}")
public ResponseEntity<apiResponse>deleteComment ( Integer CommentId ){
	try {
	this.CommentServices.deleteComment(CommentId);
	System.out.println("suscessuflly deleted comment !chill mate");

}catch(Exception e) 
	{
		e.printStackTrace();
		System.out.println("faild to delete comment beacause of "+e);
		String msg ="faild to delete comment beacause of "+e;
		boolean s =false;

	}
 
	String msg ="suscessuflly deleted comment !chill mate";
	boolean s =true;
	return  new ResponseEntity<apiResponse>(new apiResponse(msg,s),HttpStatus.GONE);
}





}

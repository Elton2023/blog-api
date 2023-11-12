package paks.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import paks.config.AppConstants;
import paks.entities.Post;
import paks.payloads.PostDto;
import paks.payloads.PostResponse;
import paks.payloads.apiResponse;
import paks.services.PostServices;
import paks.services.categoryServices;

@RestController
@RequestMapping("/post")

public class PostController {
	
	@Autowired
	private PostServices ps;
	
	@Autowired
	private categoryServices cs;
	
	@Autowired
	private ModelMapper mm;
	
	@PostMapping("/user/{userId}/category/{categoryId}/createpost")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto pd,@PathVariable("userId")Integer userId,@PathVariable("categoryId")Integer categoryId){
	PostDto newPost =this.ps.createPost(pd, userId, categoryId);
 		return  ResponseEntity.status(HttpStatus.CREATED).body(newPost) ;
	}

	
	@GetMapping("/user/{userID}/{Pagesize}/findbyuser")
	public ResponseEntity < PostResponse >  findByUser(@PathVariable("userID") Integer UserID,@PathVariable("Pagesize")Integer Pagesize){
		/*List<PostDto> foundPostu =		this.ps.getPostsByUser(UserID);
		return  new  ResponseEntity<List<PostDto>>(foundPostu,HttpStatus.FOUND);*/
		
		PostResponse foundPostu =		this.ps.getPostsByUser(UserID,Pagesize);
		return  new  ResponseEntity<PostResponse>(foundPostu,HttpStatus.FOUND);
	}
	
	@GetMapping("/Category/{CategoryID}/{Pagesize}/findbyCategory")
	public ResponseEntity <PostResponse> findByCategory(@PathVariable("CategoryID") Integer CategoryID,@PathVariable("Pagesize")Integer Pagesize){
		PostResponse foundPostc =		this.ps.getPostsByCategory(CategoryID,Pagesize);
	 
		 
 		return  new  ResponseEntity<PostResponse>(foundPostc,HttpStatus.FOUND);
}
	@GetMapping("/getAllPosts")
	public ResponseEntity<PostResponse>  getAllPosts(
			@RequestParam(value="PageNumber",defaultValue=AppConstants.PageNumber,required=false)Integer PageNumber,
			@RequestParam(value="PageSize",defaultValue=AppConstants.PageSize,required=false)Integer PageSize,
			@RequestParam(value="sortBy",defaultValue=AppConstants.sortBy,required=false)String sortBy){//the sort by arranges in either assending or decndig order
		PostResponse  AllPosts=	this.ps.getAllPost(PageNumber,PageSize,sortBy);
		return ResponseEntity.status(HttpStatus.FOUND).body(AllPosts);
	}
	
	@GetMapping("/getAPosts/{postID}")
	public ResponseEntity <PostDto>  Getpost (@PathVariable("postID") Integer p){
		 PostDto   Post  =	this.ps.getPost(p);
		return ResponseEntity.status(HttpStatus.FOUND).body(Post);
	}
	
	
	@DeleteMapping("/deletePost/{pid}")
	public apiResponse deletePost(@PathVariable("pid") Integer p) {
		this.ps.deletePost(p);
		return new  apiResponse("post deleted suscessfully ",true);
}

	@PutMapping("updatepost/{pid}")
	public ResponseEntity<PostDto>UpdatePost(@PathVariable("pid") Integer p,@RequestBody PostDto PostBody){
PostDto pd=this.ps.UpdatePost(PostBody, p)	;
return ResponseEntity.status(HttpStatus.OK).body(pd);
	}
	
	
@GetMapping("/search/{keyword}")
public ResponseEntity<List<PostDto>> searchByTitle(@PathVariable("keyword") String Keyword){
	List<PostDto> pd=	this.ps.searchPost(Keyword);
	return ResponseEntity.ok(pd);
}


	
	
	//----------------------------------------------------------------------------------------------------------------------------
}

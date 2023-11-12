package paks.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import paks.entities.Post;
import paks.entities.User;
import paks.entities.category;
import paks.exceptions.ResourceNotFoundException;
import paks.payloads.PostDto;
import paks.payloads.PostResponse;
import paks.repository.PostRepository;
import paks.repository.UserDB;
import paks.repository.categortyRepository;
import paks.services.PostServices;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostServiceImpl implements PostServices {


    @Autowired
    private PostRepository pr;
    @Autowired
    private ModelMapper mm;
    @Autowired
    private UserDB udb;
    @Autowired
    private categortyRepository cr;
    
    
    @Override
    public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
        User user = this.udb.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId",userId));
        category category =this.cr.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","categoryId",categoryId));
        Post post=   this.mm.map(postDto,Post.class);
          post.setImageName("default.png");
          post.setAddedDate(new Date());
post.setUser(user);
post.setCategory(category);
Post     newpost= this.pr.save(post);
        return this.mm.map(newpost, PostDto.class);
    }
    
    

	@Override
	public PostDto getPost(Integer postId) {
 Post post =this.pr.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","POstID",postId));
 PostDto postDto =this.mm.map(post, PostDto.class);
		return postDto;
	}
	
	
	
	@Override
	public  PostResponse getAllPost(Integer PageNumber,Integer PageSize, String sortBy) {
	//	Pageable pg=PageRequest.of(PageNumber,PageSize, Sort.by(sortBy).descending());//the descending gives all the results sorted in decenting order or else it give in assending order 
		Pageable pg=PageRequest.of(PageNumber,PageSize, Sort.by(sortBy));
		Page<Post>PagePosts=this.pr.findAll(pg);
		List<Post> allPosts=PagePosts.getContent();
 
 List<PostDto> allPostsDtos= allPosts.stream().map((p)->this.mm.map(p, PostDto.class)).collect(Collectors.toList());
 
 
 PostResponse PostResponse =new PostResponse();
 PostResponse.setContent(allPostsDtos);
 PostResponse.setPageNumber(PagePosts.getNumber());
 PostResponse.setPageSize(PagePosts.getSize());
 PostResponse.setTotalElements(PagePosts.getTotalElements());
 PostResponse.setTotalPage(PagePosts.getTotalPages());
 PostResponse.setLastPage(PagePosts.isLast());
		return  PostResponse;
	}
	
	
	@Override
	public  PostResponse getPostsByUser(Integer UserID,Integer Pagesize) {
	 User user =this.udb.findById(UserID).orElseThrow(()-> new ResourceNotFoundException("user","ID",UserID));
		 Pageable pg=PageRequest.of( UserID, Pagesize);

			Page<Post>PagePosts=  this.pr.findByUser(UserID, pg);
			PagePosts.forEach(c->System.out.println(" sooooooooooooo digged up"+c.getUser()+c.getTitle()));

			if(PagePosts.isEmpty()||PagePosts==null) {
				System.out.println("inputs are "+PagePosts.getContent()+pg+user.getEmail());
			}
			
			List<Post> allPosts=PagePosts.getContent();
			System.out.println("Page post resazzzzzzzzzzzzzzz"+allPosts);
  List<PostDto> allPostsDtos= allPosts.stream().map((p)->this.mm.map(p, PostDto.class)).collect(Collectors.toList());
	 PostResponse PostResponse =new PostResponse();
 PostResponse.setContent(allPostsDtos);
		 PostResponse.setPageNumber(PagePosts.getNumber());
		 PostResponse.setPageSize(PagePosts.getSize());
		 PostResponse.setTotalElements(PagePosts.getTotalElements());
		 PostResponse.setTotalPage(PagePosts.getTotalPages());
		 PostResponse.setLastPage(PagePosts.isLast());
				return  PostResponse; 
 	}
	
	
	@Override
 	public PostResponse getPostsByCategory(Integer categoryID,Integer Pagesize) {
	category c=	this.cr.findById(categoryID).orElseThrow(()->new ResourceNotFoundException("Category","category Id",categoryID));
	 Pageable pg=PageRequest.of( categoryID, Pagesize);

	
 Page<Post> categoryposts=this.pr.findByCategory(categoryID,pg);
 
 List<PostDto> PostDtos= categoryposts.stream().map((pp)->this.mm.map(pp, PostDto.class)).collect(Collectors.toList());
 
 PostResponse PostResponse =new PostResponse();
 PostResponse.setContent(PostDtos);
 PostResponse.setPageNumber(categoryposts.getNumber());
 PostResponse.setPageSize(categoryposts.getSize());
 PostResponse.setTotalElements(categoryposts.getTotalElements());
 PostResponse.setTotalPage(categoryposts.getTotalPages());
 PostResponse.setLastPage(categoryposts.isLast() );
 
 return PostResponse;
	}
	
	
	
	
	
	@Override
	public List<PostDto> searchPost(String Keyword) {
	//	 List<Post> result =this.pr.findByTitleContaining("%"+Keyword"%"); ...this would have been used if v had used manual query ,v should use % in parameter

 List<Post> result =this.pr.findByTitleContaining(Keyword);
 List<PostDto> found =result.stream().map((f)->this.mm.map(f, PostDto.class)).collect(Collectors.toList());

// List<PostDto> found= result.stream().map((pp)->this.mm.map(pp, PostDto.class)).collect(Collectors.toList());

		return found;
	}
	
	
	@Override
	public PostDto UpdatePost(PostDto postDto, Integer postId) {
 Post PostUpdates =this.mm.map(postDto, Post.class);
		Post postToUpdate =this.pr.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
		postToUpdate.setTitle(PostUpdates.getTitle());
		postToUpdate.setContent(PostUpdates.getContent());
		postToUpdate.setImageName(PostUpdates.getImageName());
		this.pr.save(postToUpdate);
		return this.mm.map(postToUpdate, PostDto.class);
	}
	
	
	
	@Override
	public void deletePost(Integer postId) {
this.pr.deleteById(postId);
System.out.println("|______________________________________________|" );
System.out.println("|-----suscessfully-----------------------------|" );
System.out.println("|-------------------deleted -------------------|" );
System.out.println("|------------------------ post-----------------|");
System.out.println("|---------------------------- by------------ --|" );
System.out.println("|------------------------------ id:"+postId+"---");
System.out.println("|______________________________________________|" );

	}



 
}

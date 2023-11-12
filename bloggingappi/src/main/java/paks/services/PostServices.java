package paks.services;

 import paks.payloads.PostDto;
import paks.payloads.PostResponse;

import java.util.List;

public interface PostServices {

    public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    public  PostDto getPost(Integer postId);

    public  PostResponse  getAllPost(Integer PageNumber,Integer PageSize,String sortBy);

public PostResponse getPostsByCategory(Integer categoryID,Integer Pagesize);
//--
public  PostResponse getPostsByUser(Integer UserID,Integer Pagesize);


    public List<PostDto>searchPost(String Keyword);



    public PostDto UpdatePost(PostDto postDto,Integer postId);

    public void deletePost(Integer postId);


}

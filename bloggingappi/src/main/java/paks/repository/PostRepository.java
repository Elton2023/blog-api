package paks.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import paks.entities.Post;
import paks.entities.User;
import paks.entities.category;
import paks.payloads.PostResponse;

import java.util.List;
//-------
public interface PostRepository extends JpaRepository<Post,Integer> {
/*	 @Query("select p from post as p where p.userid.id=:UserID")       

public Page<Post> findByUser(@Param("id")Integer UserID,Pageable Pageable);
*/
	
 	// public List<Post> findByUser(Pageable Pageable);
	                 
	  @Query(value="SELECT * FROM post  WHERE post.UserID=:UserID",nativeQuery=true)
	  public Page<Post> findByUser(@Param("UserID")Integer UserID,Pageable Pageable);
	 
 //   public List<Post> findByCategory(category category);

	  @Query(value="SELECT * FROM post  WHERE post.CategoryID=:CategoryID",nativeQuery=true)
	  public Page<Post> findByCategory(@Param("CategoryID")Integer CategoryID,Pageable Pageable);
	  // this is to search by Query ......... select p from post p where p.title  like =:title
	  List<Post> findByTitleContaining(String title);//this is used for searching specialy the key word 'Containing'
	  
    public Post save(Post Post);
}
package paks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paks.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
public Comment save (Comment Comment);
public void delete (Comment Comment);
}

package paks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import paks.entities.User;

public interface UserDB  extends JpaRepository<User,Integer>{
public User findById(int id);

Optional<User> findByEmail(String email);
}

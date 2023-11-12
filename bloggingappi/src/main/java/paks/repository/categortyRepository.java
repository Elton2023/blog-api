package paks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paks.entities.category;


public interface categortyRepository extends JpaRepository<category,Integer>{
	public category findById(int id);
	
	public category save(category category);
	}

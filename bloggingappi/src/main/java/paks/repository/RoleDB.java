package paks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paks.entities.role;

public interface RoleDB extends JpaRepository<role,Integer>{
 }

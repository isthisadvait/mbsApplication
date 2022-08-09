package com.raman.mbs.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{
	
	 public Optional<User> findByUsername(String username);

}

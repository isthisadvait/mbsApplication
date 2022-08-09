package com.raman.mbs.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.UserType;

public interface UserTypeDao extends JpaRepository<UserType,Integer> {
	 public Optional<UserType> findByUserTypeName(String userTypeName);
}

package com.raman.mbs.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.Status;

public interface StatusDao extends JpaRepository<Status,Integer>{
	  public Status findByStatusName(String statusName);

}

package com.raman.mbs.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.Theatre;

public interface TheatreDao extends JpaRepository<Theatre,Integer>{
	public List<Theatre> findByTheatreName(String theatreName);
    public List<Theatre> findByTicketPriceLessThan(float price);
    public List<Theatre> findByTheatreNameContaining(String theatreName);

}

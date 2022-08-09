package com.raman.mbs.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.City;

public interface CityDao extends JpaRepository<City,Integer> {
	 public City findByCityName(String cityName);

}

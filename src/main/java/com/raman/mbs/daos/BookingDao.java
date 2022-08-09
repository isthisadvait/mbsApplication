package com.raman.mbs.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raman.mbs.entities.Booking;

public interface BookingDao extends JpaRepository<Booking,Integer> {}

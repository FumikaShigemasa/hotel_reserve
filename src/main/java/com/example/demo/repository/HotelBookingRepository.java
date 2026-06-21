package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelBooking;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer> {

}

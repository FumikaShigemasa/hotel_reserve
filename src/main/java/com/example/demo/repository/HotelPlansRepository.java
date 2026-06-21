package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HotelPlan;

public interface HotelPlansRepository extends JpaRepository<HotelPlan, Integer> {

}

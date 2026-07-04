package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Prefecture;

public interface PrefectureRepository extends JpaRepository<Prefecture, Integer> {

	public Prefecture findByName(String name);

}

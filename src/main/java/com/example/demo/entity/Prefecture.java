package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prefecture")

public class Prefecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//都道府県ID

	private String name;

	@ManyToOne
	@JoinColumn(name = "region")
	private Region region;//会員FK

}

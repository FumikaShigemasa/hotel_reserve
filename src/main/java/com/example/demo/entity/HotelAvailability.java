package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_availabilities")

public class HotelAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//宿空き状況ID

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;//宿FK

	@ManyToOne
	@JoinColumn(name = "plan_id")
	private HotelPlan hotelPlan;//プランFK

	private Integer availabilities;//プラン空き数
	private LocalDate date;//空き状況日にち

	//コンストラクタ
	public HotelAvailability() {
	}

	public HotelAvailability(Hotel hotel, HotelPlan hotelPlan, Integer availabilities, LocalDate date) {
		this.hotel = hotel;
		this.hotelPlan = hotelPlan;
		this.availabilities = availabilities;
		this.date = date;
	}

	//ゲッターとセッター
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public HotelPlan getHotelPlan() {
		return hotelPlan;
	}

	public void setHotelPlan(HotelPlan hotelPlan) {
		this.hotelPlan = hotelPlan;
	}

	public Integer getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(Integer availabilities) {
		this.availabilities = availabilities;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

}

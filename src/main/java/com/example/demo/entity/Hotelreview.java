package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_reviews")

public class Hotelreview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//口コミID

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;//宿FK

	@ManyToOne
	@JoinColumn(name = "plan_id")
	private HotelPlan hotelPlan;//プランFK

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User uesr;//会員FK

	@Column(name = "written_date")
	private LocalDate writtenDate;

	private String content;

	@Column(name = "star_rating")
	private Integer starLating;

	//コンストラクタ
	public Hotelreview() {
	}

	public Hotelreview(Hotel hotel, HotelPlan hotelPlan, User uesr, LocalDate writtenDate, String content,
			Integer starLating) {
		this.hotel = hotel;
		this.hotelPlan = hotelPlan;
		this.uesr = uesr;
		this.writtenDate = writtenDate;
		this.content = content;
		this.starLating = starLating;
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

	public User getUesr() {
		return uesr;
	}

	public void setUesr(User uesr) {
		this.uesr = uesr;
	}

	public LocalDate getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(LocalDate writtenDate) {
		this.writtenDate = writtenDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStarLating() {
		return starLating;
	}

	public void setStarLating(Integer starLating) {
		this.starLating = starLating;
	}

	public Integer getId() {
		return id;
	}

}

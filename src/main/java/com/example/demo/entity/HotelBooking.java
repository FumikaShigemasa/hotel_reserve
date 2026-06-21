package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_bookings")

public class HotelBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//宿予約ID

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;//宿FK

	@ManyToOne
	@JoinColumn(name = "plan_id")
	private HotelPlan hotelPlan;//プランFK

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User uesr;//会員FK

	private Integer men;//男性の人数
	private Integer women;//女性の人数
	private Integer ohter;//その他の人数

	@Column(name = "is_family")
	private boolean idFamily;//子供連れ判定

	@Column(name = "checkin_date")
	private LocalDate checkInDate;//チェックイン日

	@Column(name = "checkout_date")
	private LocalDate checkOutDate;//チェックアウト日

	@Column(name = "checkin_time")
	private LocalTime checkInTime;//チェックイン時間

	//コンストラクタ
	public HotelBooking() {
	}

	public HotelBooking(Hotel hotel, HotelPlan hotelPlan, User uesr, Integer men, Integer women, Integer ohter,
			boolean idFamily, LocalDate checkInDate, LocalDate checkOutDate, LocalTime checkInTime) {
		this.hotel = hotel;
		this.hotelPlan = hotelPlan;
		this.uesr = uesr;
		this.men = men;
		this.women = women;
		this.ohter = ohter;
		this.idFamily = idFamily;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.checkInTime = checkInTime;
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

	public Integer getMen() {
		return men;
	}

	public void setMen(Integer men) {
		this.men = men;
	}

	public Integer getWomen() {
		return women;
	}

	public void setWomen(Integer women) {
		this.women = women;
	}

	public Integer getOhter() {
		return ohter;
	}

	public void setOhter(Integer ohter) {
		this.ohter = ohter;
	}

	public boolean isIdFamily() {
		return idFamily;
	}

	public void setIdFamily(boolean idFamily) {
		this.idFamily = idFamily;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Integer getId() {
		return id;
	}

}

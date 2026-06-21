package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel_plans")

public class HotelPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//プランID

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	private String name;
	private String cost;
	private String capacity;
	private String provision;
	private String explanation;

	@Column(name = "is_moening")
	private boolean isMorning;

	@Column(name = "id_dinner")
	private String isDinner;

	//コンストラクタ
	public HotelPlan() {
		super();
	}

	public HotelPlan(Hotel hotel, String name, String cost, String capacity, String provision, String explanation,
			boolean isMorning, String isDinner) {
		super();
		this.hotel = hotel;
		this.name = name;
		this.cost = cost;
		this.capacity = capacity;
		this.provision = provision;
		this.explanation = explanation;
		this.isMorning = isMorning;
		this.isDinner = isDinner;
	}

	//ゲッターとセッター
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getProvision() {
		return provision;
	}

	public void setProvision(String provision) {
		this.provision = provision;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public boolean isMorning() {
		return isMorning;
	}

	public void setMorning(boolean isMorning) {
		this.isMorning = isMorning;
	}

	public String getIsDinner() {
		return isDinner;
	}

	public void setIsDinner(String isDinner) {
		this.isDinner = isDinner;
	}

	public Integer getId() {
		return id;
	}

}

package com.example.demo.form.hotel;

import java.time.LocalDate;

import lombok.Data;

@Data

public class HotelSearchForm {

	private LocalDate checkIn;

	private LocalDate checkOut;

	private Integer room;

	private Integer person;

	private Integer prefectureId;

}

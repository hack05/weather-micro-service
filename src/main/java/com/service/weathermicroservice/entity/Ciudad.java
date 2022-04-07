package com.service.weathermicroservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Double lat;
	private Double lon;
	private String cityName;
	
	private Double temp;
	
	private int userId;
	private String genero;
	
	private static final long serialVersionUID = 6333509815317049060L;
}

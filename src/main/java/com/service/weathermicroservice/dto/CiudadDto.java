package com.service.weathermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDto {

	private Double lat;
	private Double lon;
	private String cityName;
	private Double temp;
	
	private int userId;
	private String genero;
}

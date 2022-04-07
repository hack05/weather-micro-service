package com.service.weathermicroservice.weather.model;


import java.awt.geom.Point2D;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

	private Point2D coord;
	private String name;
	private Double temp;
}

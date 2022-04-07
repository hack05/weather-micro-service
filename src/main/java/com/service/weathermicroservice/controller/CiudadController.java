package com.service.weathermicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.weathermicroservice.entity.Ciudad;
import com.service.weathermicroservice.service.CiudadService;
import com.service.weathermicroservice.weather.model.City;


@RestController
@RequestMapping("/ciudad")
@CrossOrigin(origins = "*")
public class CiudadController {

	@Autowired
	CiudadService ciudadService;

	@GetMapping("/lista")
	public ResponseEntity<List<Ciudad>> getAll() {
		List<Ciudad> ciudades = ciudadService.getAll();
		if (ciudades.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(ciudades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ciudad> getById(@PathVariable("id") int id) {
		Ciudad ciudad = ciudadService.getCiudadById(id);
		if (ciudad == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(ciudad);
	}

	@PostMapping("/crear")
	public ResponseEntity<Ciudad> save(@RequestBody Ciudad ciudad) {
		Ciudad cityNew = ciudadService.save(ciudad);
		return ResponseEntity.ok(cityNew);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Ciudad>> getByUserId(@PathVariable("userId") int userId) {
		List<Ciudad> ciudades = ciudadService.byUserId(userId);
		if (ciudades.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(ciudades);
	}
	
	@GetMapping("/{cityName}")
	public ResponseEntity<Optional<City>> getCityName(@PathVariable("cityName") String cityName){
		Optional<Ciudad> ciudades = ciudadService.getByCityName(cityName);
		if(ciudades == null)
			ResponseEntity.notFound().build();
		Optional<City> city = ciudadService.getName(cityName);
		return ResponseEntity.ok(city);
	}
}


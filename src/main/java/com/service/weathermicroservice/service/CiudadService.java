package com.service.weathermicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.weathermicroservice.entity.Ciudad;
import com.service.weathermicroservice.repository.ICiudadRepository;
import com.service.weathermicroservice.weather.model.City;
import com.service.weathermicroservice.weather.model.Categories;


@Service
public class CiudadService {

	@Autowired
	ICiudadRepository ciudadRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Ciudad> getAll(){
		return ciudadRepository.findAll();
	}
	
	public Ciudad getCiudadById(int id) {
		return ciudadRepository.findById(id).orElse(null);
	}
	
	public Optional<Ciudad> getByCityName(String cityName){
		return ciudadRepository.findByCityName(cityName);
	}

	public Ciudad save(Ciudad ciudad) {
		Ciudad cityNew = ciudadRepository.save(ciudad);
		return cityNew;
	}
	
	public List<Ciudad> byUserId(int userId){
		return ciudadRepository.findByUserId(userId);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Categories> getAllTracksByGenre(String genero){
		Optional<Categories> category = restTemplate.getForObject("https://api.spotify.com/v1/browse/categories/"+genero+"/playlists", Optional.class);
		return category;
	}
	
	@SuppressWarnings("unchecked")
	public Optional<City> getName(String cityName){
		Optional<City> city = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=dc3efb030f8eca89ffdf7f379b630afd", Optional.class);
		return city;
	}
}

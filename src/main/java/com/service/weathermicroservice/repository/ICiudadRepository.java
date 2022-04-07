package com.service.weathermicroservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.weathermicroservice.entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer>{

	List<Ciudad> findByUserId(int userId);
	Optional<Ciudad>findByCityName(String cityName);
	Optional<Ciudad>findByGenero(String genero);
	boolean existsByCityName(String cityName);
}

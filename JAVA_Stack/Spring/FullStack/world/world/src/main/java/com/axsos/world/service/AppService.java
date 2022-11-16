package com.axsos.world.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.world.repositories.CountryRepositories;

@Service
public class AppService {
	private final CountryRepositories countryRepo;

	public AppService(CountryRepositories countryRepo) {
		this.countryRepo = countryRepo;
	}
	// retrieve
	public List<Object[]> findNameForSolvene() {
		return countryRepo.findCountryByName();
	}
	public List<Object[]> findCount() {
		return countryRepo.findCounterOfCities();
	}
	public List<Object[]> findCityPop() {
		return countryRepo.findCityPop();
	}
	public List<Object[]> findLang() {
		return countryRepo.findLanguage();
	}
	public List<Object[]> findBySurface() {
		return countryRepo.findSurfacArea();
	}
	public List<Object[]> findByGov() {
		return countryRepo.findGov();
	}
	public List<Object[]> findInArg() {
		return countryRepo.findArg();
	}
	public List<Object[]> findRegion() {
		return countryRepo.findReg();
	}
	
	
	
}

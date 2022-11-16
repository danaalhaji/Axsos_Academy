package com.axsos.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.world.models.countrey;


@Repository
public interface CountryRepositories extends CrudRepository<countrey, Long>{
	@Modifying
	@Query("SELECT c FROM countrey c")
    List<countrey> findAll();
    @Query(value="SELECT name,language,percentage FROM countries JOIN languages ON countries.id=languages.country_id WHERE language =\"Slovene\" ORDER BY percentage DESC ", nativeQuery=true)
    List<Object[]> findCountryByName();
    @Query(value="SELECT countries.name, sum((case when countries.id = cities.country_id then 1 else 0 end)) as 'cities' FROM countries JOIN cities ON countries.id = cities.country_id GROUP BY countries.id ORDER BY sum((case when countries.id = cities.country_id then 1 else 0 end)) DESC",nativeQuery=true )
    List<Object[]> findCounterOfCities();
    @Query(value="SELECT cities.name , cities.population FROM countries JOIN cities ON countries.id=cities.country_id WHERE cities.population > 500000 AND  countries.name = \"Mexico\" ORDER BY cities.population DESC", nativeQuery=true)
    List<Object[]> findCityPop();
    @Query(value="SELECT languages.language, languages.percentage FROM countries JOIN languages ON countries.id=languages.country_id WHERE languages.percentage > 89 ORDER BY languages.percentage DESC",nativeQuery=true)
    List<Object[]> findLanguage();
    @Query(value="SELECT * FROM countries WHERE countries.surface_area < 501 AND countries.population > 100000",nativeQuery=true)
    List<Object[]> findSurfacArea();
    @Query(value="SELECT name, government_form, surface_area, life_expectancy FROM countries WHERE government_form = 'Constitutional Monarchy' AND surface_area > 200 AND life_expectancy > 75", nativeQuery=true)
    List<Object[]> findGov();
    @Query(value="SELECT cities.name, cities.district, cities.population FROM countries INNER JOIN cities ON countries.id = cities.country_id WHERE countries.name = 'Argentina' AND district = 'Buenos Aires' AND cities.population > 500000 ORDER BY cities.population DESC", nativeQuery=true)
    List<Object[]> findArg();
    @Query(value="region, sum((case when region = region then 1 else 0 end)) as 'countries' FROM countries GROUP BY region ORDER BY sum((case when region = region then 1 else 0 end)) DESC", nativeQuery=true)
    List<Object[]> findReg();
}

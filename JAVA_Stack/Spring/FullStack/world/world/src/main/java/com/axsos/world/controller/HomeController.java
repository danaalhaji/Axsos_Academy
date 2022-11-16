package com.axsos.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.world.service.AppService;
@Controller
public class HomeController {
	private final AppService appService;

	public HomeController(AppService appService) {
		this.appService = appService;
	}
	@RequestMapping("/")
	public String app() {
		List<Object[]> objects = appService.findNameForSolvene();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		System.out.println(countryName3);
		return "country";
			
	}
	@RequestMapping("/count")
	public String app1() {
		List<Object[]> objects = appService.findCount();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		Object countrycount3 = country3[1];
		System.out.println(countryName3);
		System.out.println(countrycount3);
		return "country";
			
	}
	@RequestMapping("/pop")
	public String app2() {
		List<Object[]> objects = appService.findCityPop();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		Object countrypopulation = country3[1];
		System.out.println(countryName3);
		System.out.println(countrypopulation);
		return "country";
			
	}
	@RequestMapping("/lng")
	public String app3() {
		List<Object[]> objects = appService.findLang();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		Object countrypopulation = country3[1];
		System.out.println(countryName3);
		System.out.println(countrypopulation);
		return "country";
			
	}
	
	@RequestMapping("/surface")
	public String app4() {
		List<Object[]> objects = appService.findBySurface();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		Object countrypopulation = country3[1];
		System.out.println(countryName3);
		System.out.println(countrypopulation);
		return "country";
			
	}
	@RequestMapping("/gov")
	public String app5() {
		List<Object[]> objects = appService.findByGov();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		Object countrypopulation = country3[1];
		System.out.println(countryName3);
		System.out.println(countrypopulation);
		return "country";
	}
	@RequestMapping("/arg")
	public String app7() {
		List<Object[]> objects = appService.findInArg();
		Object[] country = objects.get(0);
		Object countrylang = country[1];
		Object countryName = country[0];
		System.out.println(countryName);
		Object[] country3 = objects.get(3);
		Object countryName3 = country3[0];
		Object countrypopulation = country3[1];
		System.out.println(countryName3);
		System.out.println(countrypopulation);
		return "country";
	}
	@RequestMapping("/reg")
	public String app8() {
		List<Object[]> objects = appService.findRegion();
		Object[] country = objects.get(0);
		Object countryName = country[0];
		System.out.println(countryName);
		return "country";
	}
}

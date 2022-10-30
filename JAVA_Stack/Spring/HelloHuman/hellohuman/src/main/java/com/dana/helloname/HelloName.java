package com.dana.helloname;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class HelloName {
	@RequestMapping("")
	public String helloHuman(@RequestParam(value="name", required = false)String quereyname ,@RequestParam(value="last_name", required = false)String quereyLastName, @RequestParam(value="times", required = false)int timesRep) {
		if(quereyname == null && quereyLastName == null) {
			return "Hello Human";
		}
		else if (quereyname != null && quereyLastName == null) {
			return "Hello " + quereyname;
		}
		else if (quereyname != null && quereyLastName != null) {
			return "Hello " + quereyname + " " +quereyLastName;
		}
		else {
			return "Hello Human";
		}
	}
}

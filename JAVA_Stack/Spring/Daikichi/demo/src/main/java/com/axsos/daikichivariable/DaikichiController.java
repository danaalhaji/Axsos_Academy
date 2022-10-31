package com.axsos.daikichivariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	@RequestMapping("/tarvel/{city}")
	public String travelPath(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city;
	}
	@RequestMapping("/lotto/{num}")
	public String lottoPath(@PathVariable("num") Integer num) {
		if (num %2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}

}

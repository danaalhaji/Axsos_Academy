package com.axsos.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class DataController {
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
	@RequestMapping("/datetemplate")
	public String DateTemplate(Model model) {
		LocalDate myObj = LocalDate.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE, 'the' dd 'of' MMMM yyyy");
	    String formattedDate = myObj.format(myFormatObj);
		model.addAttribute("date", formattedDate);
		return "DateTemplate.jsp";
	}
	@RequestMapping("/timetemplate")
	public String TimeTemplate(Model model) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm  a");
	    String formattedDate = myDateObj.format(myFormatObj);
		model.addAttribute("date", formattedDate);
		return "TimeTemplate.jsp";
	}
}

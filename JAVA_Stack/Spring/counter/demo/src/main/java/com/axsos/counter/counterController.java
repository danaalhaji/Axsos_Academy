package com.axsos.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {
@RequestMapping("/")
public String index(HttpSession session) {
	if(session.getAttribute("count")== null) {
		session.setAttribute("count", 1);
	}
	else {
		Integer x = (Integer)session.getAttribute("count");
		x++;
		session.setAttribute("count", x);
	}
	return "index.jsp";
}
@RequestMapping("/count")
public String counter (HttpSession session) {
	session.getAttribute("count");
	return "index2.jsp";
}
}

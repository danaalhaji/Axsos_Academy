package com.axsos.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/submit")
	public String submit(@RequestParam(value="num") Integer  num,
			@RequestParam(value="cityame") String cityame,
			@RequestParam(value="pame") String pame,
			@RequestParam(value="profname") String profname,
			@RequestParam(value="thingname") String thingname,
			@RequestParam(value="message") String message,
			Model model,
			HttpSession session) {
		session.setAttribute("num", num);
		session.setAttribute("pame", pame);
		session.setAttribute("cityame", cityame);
		session.setAttribute("pame", pame);
		session.setAttribute("profname", profname);
		session.setAttribute("thingname", thingname);
		session.setAttribute("message", message);
		
		return "redirect:/submitdata";

	}
	@RequestMapping("/submitdata")
	public String submit(HttpSession session) {
		session.getAttribute("num");
		session.getAttribute("pame");
		session.getAttribute("cityame");
		session.getAttribute("pame");
		session.getAttribute("profname");
		session.getAttribute("thingname");
		session.getAttribute("message");
		return "submit.jsp";
	}
}

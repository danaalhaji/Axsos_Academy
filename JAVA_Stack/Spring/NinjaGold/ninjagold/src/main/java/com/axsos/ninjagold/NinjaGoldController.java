package com.axsos.ninjagold;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class NinjaGoldController {

	@RequestMapping("/")
public String indexNinja(HttpSession session) {
		
		if(session.getAttribute("total")==null) {
			session.setAttribute("total", 0);
		}
		return "index.jsp";
	}
	@PostMapping("/form")
	public String formGold(HttpSession session, @RequestParam(value="formType") String formType , Model model) {
		Random randomForm = new Random();
		String generalMessage = "you have earned ";
		List<String> active = new ArrayList<String>();
	if(formType.equals("form")) {
		
		if(session.getAttribute("form")==null) {	
			int r = randomForm.nextInt(20-10)+10;
			session.setAttribute("form", r);
			active.add(generalMessage + r);
		}
		else {
			int r = randomForm.nextInt(20-10)+10;
			session.setAttribute("form", r);
			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("form");
			session.setAttribute("total",f);
			active.add(generalMessage + r);
		}
	
	}
	if(formType.equals("cave")) {
		if(session.getAttribute("cave")==null) {
			int r = randomForm.nextInt(20-10)+10;
			session.setAttribute("cave", r);
			active.add(generalMessage + r);
		}
		else {
			int r = randomForm.nextInt(20-10)+10;
			session.setAttribute("cave", r);
			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("cave");
			session.setAttribute("total",f);
			active.add(generalMessage + r);
		}
	
	}
	
	if(formType.equals("house")) {
		if(session.getAttribute("house")==null) {	
			int r = randomForm.nextInt(20-10)+10;
			session.setAttribute("house", r);
			active.add(generalMessage + r);
		}
		else {
			int r = randomForm.nextInt(20-10)+10;
			session.setAttribute("house", randomForm.nextInt(20-10)+10);
			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("house");
			session.setAttribute("total",f);
			active.add(generalMessage + r);
		}
	
	}
	
	if(formType.equals("quest")) {
		if(session.getAttribute("quest")==null) {	
			int r = randomForm.nextInt(50+50)-50;
			session.setAttribute("quest", r);
			if (r < 0) {
				active.add("you have lost " + r);
			}
			else {
				active.add(generalMessage + r);
			}
		}
		else {
			int r = randomForm.nextInt(50+50)-50;
			session.setAttribute("quest", r);
			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("quest");
			session.setAttribute("total",f);
			if (r < 0) {
				active.add("you have lost " + r);
			}
			else {
				active.add(generalMessage + r);
			
		}
	
	}

	}
	model.addAttribute("active",active);
	System.out.println(active);
	return "redirect:/";
	}
}
	
//		Random randomCave = new Random();
//		if(session.getAttribute("cave")==null) {	
//			session.setAttribute("cave", randomCave.nextInt(20-10)+10);
//		}
//		else {
//			session.setAttribute("cave", randomCave.nextInt(20-10)+10);
//			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("cave");
//			session.setAttribute("total",f);
//		}
//		return "redirect:/";
//	}
//		Random randomCave = new Random();
//		if(session.getAttribute("house")==null) {	
//			session.setAttribute("house", randomCave.nextInt(20-10)+10);
//		}
//		else {
//			session.setAttribute("house", randomCave.nextInt(20-10)+10);
//			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("house");
//			session.setAttribute("total",f);
//		}
//		return "redirect:/";
//	}
//		if(session.getAttribute("quest")==null) {	
//			session.setAttribute("quest", randomCave.nextInt(50+50)-50);
//		}
//		else {
//			session.setAttribute("quest", randomCave.nextInt(50+50)-50);
//			System.out.println(session.getAttribute("quest"));
//			Integer f = (Integer) session.getAttribute("total")+ (Integer) session.getAttribute("quest");
//			session.setAttribute("total",f);
//		}
//		return "redirect:/";
//	}
//	


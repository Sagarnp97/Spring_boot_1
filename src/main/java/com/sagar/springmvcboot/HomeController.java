package com.sagar.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sagar.springmvcboot.model.Alien;

@Controller
public class HomeController {
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name", "Aliens");
	}
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	/*
	 * @RequestMapping("add") public String add(@RequestParam("num1") int
	 * i, @RequestParam("num2") int j, ModelMap m) { int num3 = i+j;
	 * m.addAttribute("num3", num3); return "result"; }
	 */
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		List<Alien> aliens = Arrays.asList(new Alien(101,"Ganesh"), new Alien(102,"Mary"));
		m.addAttribute("result",aliens);
		return "showAliens";
	}
	
	@PostMapping(value = "addAlien")
	public String addAlien(@ModelAttribute Alien a)
	{
		return "result";
	}
	
	/*
	 * @RequestMapping("addAlien") public String addAlien(@ModelAttribute Alien a) {
	 * return "result"; }
	 */
}

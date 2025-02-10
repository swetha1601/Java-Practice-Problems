package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller

public class mycontroller {
	@RequestMapping("/")
	public String home(){
		return "index.jsp";
	}
	
	@PostMapping("/processForm")
    public String processForm(@RequestParam String username,
                              @RequestParam String email,
                              Model model) {
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        return "details.jsp"; // Maps to user-details.jsp
    }
	
	

}

package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")        //parent mapping
public class HelloWorldController {

	//need a controller method to show the initial HTML page
	
	@RequestMapping("/showForm")     //Sub mapping (relative)
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	
	@RequestMapping("/processForm")     //Sub mapping (relative)
	public String processForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter form the HTmL form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create message to the model
		String result = "Yo! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create message to the model
		String result = "Hey my friend from v3! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}

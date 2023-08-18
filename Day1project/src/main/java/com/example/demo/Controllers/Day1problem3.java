package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day1problem3 {
	@Value("${color}")
	private String favcolor;
	@GetMapping("/disp2")
	
	public String getMyFav()
	{
		return "My favorite color is "+favcolor;
	}

}

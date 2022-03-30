package com.AleGla.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phone")
public class PhoneController {

	@GetMapping
	public String allPhones() {
		 return "{Greeting : Hi Dude, Welcome to Phones Repository}";
	}
}

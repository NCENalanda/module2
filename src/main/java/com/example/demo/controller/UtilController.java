package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IWriteDataService;

@RestController
@RequestMapping("/util")
public class UtilController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UtilController.class);
    @Autowired
	private IWriteDataService service;
	@GetMapping("writeAll")
	public String writeData() {
		log.info("Inside Class :: "+ this.getClass().getName(), " Inside Method :: ", " public String writeData()  ");
		return service.writeIntoFile();
	}

}

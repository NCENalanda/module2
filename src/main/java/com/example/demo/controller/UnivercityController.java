package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Univercity;
import com.example.demo.service.IUniversityService;

@RestController
@RequestMapping("univercity")
public class UnivercityController {

	@Autowired
	private IUniversityService service;
	
	@GetMapping("getAll")
	public List<Univercity> getAllUnivercity(){
		return service.getAllUnivercity();
	}
	
	@GetMapping("get/{id}")
	public Univercity getUnivercity(@PathVariable("id") int id){
		//University u1 =  new University(); u1.setName("Default");
		return service.getUnivercity(id);
	}
	
	@GetMapping("search/s_")
	public List<Univercity> serarch(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("country") String country){
		//University u1 =  new University(); u1.setName("Default");
		if(id!=null) {   int id1 = Integer.valueOf(id);  return Arrays.asList(service.getUnivercity(id1)); }
		if(name!=null) {return Arrays.asList(service.getUnivercityByName(name));}
		if(country!= null) {return service.getUnivercityByCountry(country);}
		return Arrays.asList(new Univercity());
	}
	
	@PostMapping("addAll")
	public List<Univercity> addAllUnivercity(@RequestBody List<Univercity> uList){
		return service.addAllUnivercity(uList);
	}
	
	@PostMapping("add")
	public Univercity addUnivercity(@RequestBody Univercity univercity){
		return service.addUnivercity(univercity);
	}
}

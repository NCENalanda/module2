package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUnivercityRepository;
import com.example.demo.model.Univercity;

@Service 
public class UnivercityImpl implements IUniversityService {

	@Autowired
	private IUnivercityRepository repository;
	
	@Override
	public List<Univercity> getAllUnivercity(){
		return repository.findAll();
	}
	
	@Override
	public List<Univercity> addAllUnivercity(List<Univercity> uList){
		//uList.forEach(univercity ->{ univercity.setName(univercity.getName()+"  UNIVERSITY");});
		return repository.saveAll(uList);
	}
	
	@Override
	public Univercity addUnivercity(Univercity univercity){
		//univercity.setName(univercity.getName()+"  UNIVERSITY");
		return repository.save(univercity);
	}
	
	@Override
	public Univercity getUnivercity(Integer id){
		return (repository.findById(id)).get();
	}
	
	@Override
	public Univercity getUnivercityByName(String name){
		return repository.findByName(name);
	}
	
	@Override
	public List<Univercity> getUnivercityByCountry(String country){
		return repository.findByCountry(country);
	}
	
	
}

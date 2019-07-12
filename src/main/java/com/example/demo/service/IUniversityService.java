package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Univercity;

public interface IUniversityService {

	List<Univercity> getAllUnivercity();

	List<Univercity> addAllUnivercity(List<Univercity> uList);

	Univercity addUnivercity(Univercity univercity);

	Univercity getUnivercity(Integer id);

	Univercity getUnivercityByName(String name);

	List<Univercity> getUnivercityByCountry(String country);

}

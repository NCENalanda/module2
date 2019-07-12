package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Univercity;

public interface IUnivercityRepository extends JpaRepository<Univercity, Integer> {

	Univercity findByName(String name);

	List<Univercity> findByCountry(String country);

}

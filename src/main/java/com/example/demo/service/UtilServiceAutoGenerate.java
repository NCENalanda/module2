package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

import net.bytebuddy.utility.RandomString;
@Service
public class UtilServiceAutoGenerate {

	
	public List<Student> getStudents(int num){
		List<Student>  stList = new ArrayList<>();
		 
		for (int i = 0; i <num; i++) {
			Student st = new Student(i, "Ayush_"+i+"_"+getRamdomString(2));
			stList.add(st);
		}
		return stList;
	}
	
	public String getRamdomString(int len) {
		return RandomString.make(len);
	}
}

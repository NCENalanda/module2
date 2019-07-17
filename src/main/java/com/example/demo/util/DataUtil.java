package com.example.demo.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

import net.bytebuddy.utility.RandomString;


@Service
public class DataUtil {
	
	public  List<String>  getData(){
		
		List<String> strList = new ArrayList<>();
		
		for(int i =0;i<10;i++) {
			strList.add("AYUSH    "+i);
		}
		return strList;
	}
	
public  List<String>  getData(String text){
		
		List<String> strList = new ArrayList<>();
		
		for(int i =0;i<10;i++) {
			strList.add(text+"  "+i);
		}
		return strList;
	}
	
	public String  getRandomString(int length){
		
		return RandomString.make(length);
	}
	
	public String  getPath(){
		String fileName =  this.getRandomString(7)+".txt";
		 return "/home/ist/Documents/consoleFile/"+fileName;
	}
	
	public String  getStaticPath(String fileName ){
		
		 return "/home/ist/Documents/consoleFile/"+fileName+".txt";
	}
	
	public void printFile(List<Student> stList, String file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			
			stList.forEach(action ->{
				writer.println(action);
			});
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String setName(String str) {
		return str+"_"+RandomString.make(2);
	}
	
	public Integer setAge() {
		return (int) RandomString.make(1).charAt(0);
	}
	
	public Integer setRank() {
		return (int) RandomString.make(1).charAt(0);
	}
	
	public String setCollegeName(String str) {
		return str+"_"+RandomString.make(2);
	}
	
	public List<Student> getStudents(int num){
		List<Student>  stList = new ArrayList<>();
		Student st = null;
		for (int i = 0; i <num; i++) {
			 st = new Student(i, this.setName("Ayus_"+i+"_"));
			
			if(i>80 && i<110) { st = new Student(i, this.setName("Ayus_"+i+"_"), i, 123, this.setCollegeName("BHAGALPUR_"));}
			if(i%6==0) { st = new Student(i, this.setName("Ayus_"+i+"_"), i, 100, this.setCollegeName("INDORE_"));}
			if(i%7==0) { st = new Student(i, this.setName("Ayus_"+i+"_"), i, 49, this.setCollegeName("BHOPAL_"));}
			if(i%11==0) { st = new Student(i, this.setName("Ayus_"+i+"_"), i, 123, this.setCollegeName("HYD_"));}
			stList.add(st);
		}
		return stList;
	}
	
	public String getRamdomString(int len) {
		return RandomString.make(len);
	}
	

	

}

package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteDataServiceImpl implements IWriteDataService {
	
	private static final Logger log = LoggerFactory.getLogger(WriteDataServiceImpl.class);

	@Autowired
	private IUniversityService service;
	
	@Override
	public String writeIntoFile() {
		
		final String  filePath = "home/ist/learnimgworkspace/Data/POJODATA/WriteDATA/UNIVERSITY.txt";
		
		log.info("Inside Class :: "+ this.getClass().getName(), " Inside Method :: ", " public String writeData()  ");
		PrintWriter writer  = null;
		try {
			
			 writer = new PrintWriter(filePath);
			writer.write(service.getAllUnivercity().toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Error In Inside  Class :: ", this.getClass().getName(), " Reason : ", e.getMessage());
		}
		
		writer.close();
		return filePath;
	}

}

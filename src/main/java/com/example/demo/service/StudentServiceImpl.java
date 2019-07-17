package com.example.demo.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.util.DataUtil;

@Service
public class StudentServiceImpl {

	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	List<Student>  students = new CopyOnWriteArrayList<>();
	@Autowired
	private  UtilServiceAutoGenerate generate ;
	
	@Autowired
	private DataUtil dataUtil;
	
	private AtomicInteger atomicInteger;
	private volatile int i = 100;
	private ReentrantLock lock;
	
	public void printStudent() {
		List<Student> stList = dataUtil.getStudents(1000);
		System.out.println(stList.toString());
		String str = dataUtil.getStaticPath("DATAINPUT_5");
		System.out.println(" File Name "+str);
		dataUtil.printFile(stList, str);
		str = dataUtil.getStaticPath("OUTPUT_5");
		System.out.println(" File Name "+str);
		dataUtil.printFile(testThread(stList), str);
		
	}
	
	public List<Student>  testThread(List<Student> stList) {
		atomicInteger = new AtomicInteger(10);
		
		
		List<Student> students = new ArrayList<>();
		List<Future<String>> futures = new ArrayList<>();
		final ExecutorService pool = Executors.newFixedThreadPool(10);
		final CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);

		     stList.forEach(st ->{
			Runnable runnable = ()->{
				
				
				synchronized (st) {
					
				st.setName(dataUtil.setName("SUD__"+atomicInteger.get()+"__"));
				if(st.getAge()==null) {st.setAge(dataUtil.setAge());}
				if(st.getCollegename()==null) {st.setCollegename(dataUtil.setCollegeName("NALANDA "));}
				if(st.getRank()==null) {st.setRank(dataUtil.setRank());}
				st.setRank(i);
				i++;
				}
				
				students.add(st);
			};
			Future<String> future =completionService.submit(runnable,"abc");
		    futures.add(future);
		});

		futures.forEach(f->{
			try {  f.get(); f=null;} 
			catch (InterruptedException | ExecutionException e)  { e.printStackTrace();}
		});
		pool.shutdown();
		return students;
	}
    
	public void  divideList(List<Student> stList) {
		List<List<Student>>  lists = null;
		
		lists = new ArrayList<>();
		int totalObj = stList.size();
		int pageObj = 10;
		
		int noOFPage = totalObj/pageObj;
		int mod = totalObj%pageObj;
		System.out.println(stList.size());
		System.out.println("MoD : "+mod);
		System.out.println(stList.toString());
		if(mod>0) {noOFPage++;}
		
		for(int i =0;i<noOFPage; i++ ) {
			if((i+1)==noOFPage && mod>0) {
				System.out.println("Last Condition ");
				
				List<Student> list = new ArrayList<>(stList.subList(i*10, (i*10)+mod));
			    lists.add(list);
				continue;
			}
		    List<Student> list = new ArrayList<>(stList.subList(i*10, (i*10)+9));
		    lists.add(list);
		}
		
		System.out.println(lists.size());
		
		lists.forEach(l ->{
			System.out.println(l.toString());
			System.out.println();
		});
		
	}
    
	public List<Deque<Student>>   generateListOfQueue(List<Student> stList) {
		
		List<Deque<Student>>  deques  = null;
		deques = new ArrayList<>();
		
		
		int totalObj = stList.size();
		int pageObj = 10;
		int noOFPage = totalObj/pageObj;
		int mod = totalObj%pageObj;
		if(mod>0) {noOFPage++;}
		
		for(int i =0;i<noOFPage; i++ ) {
			if((i+1)==noOFPage && mod>0) {
				
				Deque<Student> deque = new  ArrayDeque<>(stList.subList(i*10, (i*10)+mod));
				deques.add(deque);
				continue;
			}
			Deque<Student> deque = new  ArrayDeque<>(stList.subList(i*10, (i*10)+pageObj-1));
			deques.add(deque);
		}
		return deques;
		
	}
	
 public void   processDeques(List<Deque<Student>> deques) {
	 
	 final ExecutorService pool = Executors.newFixedThreadPool(10);
	 final CompletionService<Deque<Student>> completionService = new ExecutorCompletionService<>(pool);
	 List<Future<Deque<Student>>> futures = new ArrayList<>();
	 
	 deques.forEach(d ->{
		 Callable<Deque<Student>> callable =  ()->{
			 try {
				 log.info("DEQUE Process");
				return d;
			} catch (Exception e) {  log.error("CAUSE : ",e.getMessage()); return null;}
		 };
		 
		 futures.add(completionService.submit(callable));
		 
	 });
	 
	 futures.forEach(f->{
		 try {
			log.info(f.get().toString());
			this.processDeque(f.get());
		} catch (InterruptedException | ExecutionException e) {
			log.error("CAUSE : ",e.getMessage());
		}
	 });
	 
	 pool.shutdown();
 }
 
public void   processDeque(Deque<Student> deque) {
	 List<Student>  students = new ArrayList<>();
	 final ExecutorService pool = Executors.newFixedThreadPool(10);
	 final CompletionService<Student> completionService = new ExecutorCompletionService<>(pool);
	 List<Future<Student>> futures = new ArrayList<>();
	 
	deque.forEach(st ->{
		Callable<Student> callable = ()->{
			try {
				 log.info("DEQUE Process");
				 students.add(st);
				return st;
			} catch (Exception e) {  log.error("CAUSE : ",e.getMessage()); return null;}
		 };
		 
		 futures.add(completionService.submit(callable));
	});
	 
	 futures.forEach(f->{
		/* try {
			//log.info("IN Future : "+f.get().toString());
			f.isDone();
		} catch (InterruptedException | ExecutionException e) {
			log.error("CAUSE : ",e.getMessage());
		}*/
	 });
	 
	 pool.shutdown();
	 
	 log.info("Size : "+students.size());
	 log.info(students.toString());
 }
    
}

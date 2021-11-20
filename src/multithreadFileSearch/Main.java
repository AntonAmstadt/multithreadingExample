package multithreadFileSearch;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//set this to process files encoded in UTF-8
		//System.setProperty("file.encoding", "UTF-8");
		
		//START NOTES
//		Runnable r = new MyRunnable("ant");
//		Runnable r2 = new MyRunnable("john");
		
		//Running threads by creating thread objects and moving them into start portion of thread life cycle
		//Java Thread life cycle: New, Active, Blocked/Waiting, Timed Waiting, Terminated
//		Thread t = new Thread(r);
//		Thread t2 = new Thread(r2);
//		t.start();
//		t2.start();
		
		//Thread Pools should be used when there are potentially a large number of threads that could
		//run simultaneously. Used especially in database and web servers
//		int maxThreads = 5;
//		ExecutorService pool = Executors.newFixedThreadPool(maxThreads);
//		pool.execute(r);
//		pool.execute(r2);
		
		//what the code below looks like without the arraylists 
//		MyRunnable r = new MyRunnable("lukas.txt", args[0]);
//		MyRunnable r1 = new MyRunnable("book2.txt", args[0]);
//		MyRunnable r2 = new MyRunnable("book3.txt", args[0]);
//		Thread t = new Thread(r);
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		t.start();
//		t2.start();
//		t1.start();
		//END NOTES
		
		ArrayList<MyRunnable> runs  = new ArrayList<MyRunnable>();
		ArrayList<Thread> ts = new ArrayList<Thread>();
		for(int i = 1; i < args.length; i++) {
			runs.add(new MyRunnable(args[i], args[0]));
		}
		for(int i = 0; i < runs.size(); i++) {
			ts.add(new Thread(runs.get(i)));
		}
		for(int i = 0; i < ts.size(); i++) {
			ts.get(i).start();
		}
		

		
	}

}
package multithreadFileSearch;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//set this to process files encoded in UTF-8
		//System.setProperty("file.encoding", "UTF-8");
		
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

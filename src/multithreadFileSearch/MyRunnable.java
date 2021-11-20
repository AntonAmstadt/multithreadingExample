package multithreadFileSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyRunnable implements Runnable{

	private String myFile; 
	private String searchTerm;
	private int stLen;
	
	public MyRunnable(String myFile, String searchTerm) {
		this.myFile = myFile;
		this.searchTerm = searchTerm;
		stLen = searchTerm.length();
	}
	
	public void run() {
//			for (int i = 0; i < 10; i++) {
//				Date now = new Date();
//				System.out.println(now + " " + msg);
//				Thread.sleep(1000);
//			}
			File inputFile = new File(myFile);
			try (Scanner in = new Scanner(inputFile)){
				System.out.println("thread executing");
				in.useDelimiter("");
				String line;
				int lineNum = 0;
				
				while(in.hasNext()) {
					if(in.hasNextLine()) {
						line = in.nextLine();
						int len = line.length();
						if(len > stLen) {
							int matchCounter = 0;
							int index = 0;
							while (matchCounter < stLen && index < len) {
								if(searchTerm.charAt(matchCounter) == line.charAt(index)) {
									matchCounter++;
								}
								else {
									matchCounter = 0;
								}
								
								index++;
							}
							if (matchCounter == stLen) { //match found
								System.out.println(myFile + ": line num: " + lineNum + " " + line);
							}
							//System.out.println(line);
						}
					}
					
					lineNum++;
				}
				
			}catch(FileNotFoundException fnf) {
				fnf.printStackTrace();
			}
			
		
	}
	
	
}

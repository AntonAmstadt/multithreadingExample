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
						}
					}
					
					lineNum++;
				}
				
			}catch(FileNotFoundException fnf) {
				fnf.printStackTrace();
			}
			
		
	}
	
	
}

package hibernateDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWrite {
	
	private String path;
	Scanner sc=new Scanner(System.in);
	
	public void writtingFile(Store s,String id) throws FileNotFoundException {
		
		System.out.println("Which file you want to write this data");
		System.out.println("1. Adidas");
		System.out.println("2. Nike");
		System.out.println("3. Puma");
		System.out.println("4. Want to create a new File");
		int ch = sc.nextInt();
		switch(ch) {
		    case 1: path="src/main/resources/Adidas.csv";
		    		writeFile(s,id,path);
					break;
			case 2:	path="src/main/resources/Nike.csv";
					writeFile(s,id,path);
					break;
			case 3:	path="src/main/resources/Puma.csv";
					writeFile(s,id,path);
					break;
			case 4:	createNewFile();
					path="NewFile.csv";
					writeFile(s,id,path);
					break;
			default :
				System.out.println("Invalid Choice");
				break;
		}
		
	}

	private void writeFile(Store s, String id,String path) throws FileNotFoundException {
		
		FileOutputStream fos= new FileOutputStream(path,true);
		PrintWriter pw=new PrintWriter(fos);
		pw.println(id+"|"+s.getName()+"|"+s.getColor()+"|"+s.getGender()+"|"+s.getSize()+"|"+s.getPrice()+"|"+s.getRating()+"|"+s.getAvailability());
		pw.close();
		System.out.println("File is created and written something in that");
		
	}

	private void createNewFile() throws FileNotFoundException {
		FileOutputStream fos= new FileOutputStream("NewFile.csv",true);
		PrintWriter pw=new PrintWriter(fos);
		pw.println("ID|NAME|COLOUR|GENDER_RECOMMENDATION|SIZE|PRICE|RATING|AVAILABILITY");
		pw.close();
		System.out.println("File is created and written something in that");
		
		
	}

}

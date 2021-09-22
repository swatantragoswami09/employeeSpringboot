package hibernateDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.transaction.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;

public class App {
	
	private static String settingID(String name, Store s) {
		
		// create instance of Random class
        Random rand = new Random();
       	String v = s.getName().charAt(0)+""+s.getName().charAt(1)+rand.nextInt(1000000)+s.getName().charAt(s.getName().length()-1)+""+s.getName().charAt(s.getName().length()-2);
//		System.out.println(v);
		return v;
		
	}
		
	public static void main(String[] args) throws FileNotFoundException {
		
		Store s=new Store();
		FileWrite fw=new FileWrite();
		UserInput ui=new UserInput();
		DBController dbController=new DBController();
		Scanner sc=new Scanner(System.in);
		
		
				
		System.out.println("Project Started");
		System.out.println("1. Want to Write data in File");
		System.out.println("2. Want to Store same data in DB");
		System.out.println("3. View Data From DB");
		System.out.println("4. Search Product from DB");
		try {
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			ui.takeInput(s);
			String id=settingID(s.getName(),s);
			fw.writtingFile(s,id);
			break;
		case 2:
//			String id1=settingID(s.getName(),s);
			ui.takeInput(s);
			dbController.StoreDataInDB(s);
			break;
		case 3:
			System.out.print("Enter primary id:");
			int id2=sc.nextInt();
			dbController.viewDatafromDB(s,id2);
			break;
		case 4:
			dbController.searchProduct();
			break;
		default :
			System.out.println("Invalid Choice");
			break;
			
		}
	} catch (NullPointerException e) {
		System.out.println("Enter Correct value!");
	} catch (Exception e) {
		System.out.println("Enter Correct value!");
	}
	
   }
}

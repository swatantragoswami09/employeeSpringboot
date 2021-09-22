package hibernateDemo;

import java.util.Random;
import java.util.Scanner;

public class UserInput {
	
	Scanner sc=new Scanner(System.in);
	
	public static boolean validtaeString(String str) {
	      str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!(ch >= 'a' && ch <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	   }
	
	
	public void takeInput(Store s) {
		
		System.out.print("Please Enter a Brand Name:");
		String name = sc.nextLine().toUpperCase();
		boolean boolName=validtaeString(name);
		if(!boolName) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		s.setName(name);
		
		

		
		System.out.print("Please Enter a Color:");
		String color = sc.nextLine().toUpperCase();
		boolean boolColor=validtaeString(color);
		if(!boolColor) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		s.setColor(color);
		
		System.out.print("Please Enter a Gender:");
		String gender = sc.nextLine().toUpperCase();
		boolean boolGender=validtaeString(gender);
		if(!boolGender) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		s.setGender(gender);
		
		System.out.print("Please Enter a Price:");
		Double price = sc.nextDouble();
		s.setPrice(price);
		
		System.out.print("Please Enter a Size:");
		String size = sc.next().toUpperCase();
		boolean boolSize=validtaeString(size);
		if(!boolSize) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		s.setSize(size);
		
		System.out.print("Please Enter a Rating:");
		Double rating = sc.nextDouble();
		s.setRating(rating);
		
		System.out.print("Please Enter a Availability:");
		String avaiable = sc.next().toUpperCase();
		s.setAvailability(avaiable);

	}

}

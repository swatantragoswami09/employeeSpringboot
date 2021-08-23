
//Solution of Assignment-1

import java.util.InputMismatchException;
import java.util.Scanner;

public class FatGramCal {
	
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

	public static void main(String[] args) {
//		System.out.println("hello");
		Scanner sc=new Scanner(System.in);
		StringBuffer sb=new StringBuffer(); 
		FatGramCalc fgc= new FatGramCalc();
		try {
			
			System.out.println("Enter the name of a food item: ");
			String food= sc.nextLine();
			
			boolean bool = validtaeString(food);
			
			if(!bool) {
		         System.out.println("Given String is invalid");
		         System.exit(0);
		      }
			
		System.out.println("Enter the number of calories: ");
		fgc.totalNumberOfCalories = sc.nextDouble();

		System.out.println("Enter the grams of fat: ");
		fgc.fatGrams = sc.nextDouble();
		
		fgc.caloriesFromFat = fgc.fatGrams*9;
//		System.out.println(fgc.caloriesFromFat);
		fgc.percentageOfCaloriesFromFat = fgc.caloriesFromFat/fgc.totalNumberOfCalories;
		
		if(fgc.caloriesFromFat > fgc.totalNumberOfCalories) {
			System.out.println("The input is invalid ");
		}else {
			
			if(fgc.caloriesFromFat < 0.30 * fgc.totalNumberOfCalories) {
				System.out.println("The food is low in fat");
							
			}
			System.out.printf("The percentage of calories that come from fat is %.2f%%",fgc.percentageOfCaloriesFromFat);
//			fgc.toString();
		}
		
		
		} catch (Exception  e) {
			  System.out.println("Please Enter Correct Value");
		}

		
		
	}

	
}

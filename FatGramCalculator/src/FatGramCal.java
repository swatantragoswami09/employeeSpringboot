
//Solution of Assignment-1

import java.util.Scanner;

public class FatGramCal {

	public static void main(String[] args) {
//		System.out.println("hello");
		Scanner sc=new Scanner(System.in);
		FatGramCalc fgc= new FatGramCalc();
		try {
		System.out.println("Please Enter the number of calories");
		fgc.totalNumberOfCalories = sc.nextDouble();

		System.out.println("Please Enter the number of fat Gram in the food");
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
		
		
		}catch(Exception e) {
			System.out.println("Please Enter Correct Value");
		}
		
		
	}
}

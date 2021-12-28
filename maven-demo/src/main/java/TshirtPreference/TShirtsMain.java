package TshirtPreference;
import java.io.FileNotFoundException;
import java.util.*;

public class TShirtsMain {
	
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

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc=new Scanner(System.in);
		
		TShirt tshirt= new TShirt("Black","L","U","N");
		try {
		
		System.out.print("Enter Color:");
		String color =sc.nextLine().toLowerCase();
		boolean boolColor=validtaeString(color);
		if(!boolColor) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		tshirt.setcolor(color);
		
		System.out.print("Enter Gender (Male = M or m Female = F or f):");
		String gender=sc.nextLine().toLowerCase();
		boolean boolGender = validtaeString(gender);
		if(!boolGender) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		tshirt.setgender(gender);
		
		System.out.print("Enter Size (M,L,S):");
		String size= sc.nextLine().toLowerCase();
		boolean boolSize= validtaeString(size);
		if(!boolSize) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		tshirt.setsize(size);
		
		System.out.print("Enter Output Preference Price or Rating or Both:");
		String o_p=sc.nextLine().toLowerCase();
		boolean boolOp=validtaeString(o_p);
		if(!boolOp) {
	         System.out.println("Given String is invalid");
	         System.exit(0);
	      }
		tshirt.setoutput_Preference(o_p);
		
		
		TShirtController tshirtController =new TShirtController();
		tshirtController.searchTShirt("src/main/resources/Adidas.csv",tshirt);
		tshirtController.searchTShirt("src/main/resources/Nike.csv",tshirt);
		tshirtController.searchTShirt("src/main/resources/Puma.csv",tshirt);
		
		}catch(Exception e){
			System.out.println("T-Shirt is Not Present");
			e.printStackTrace();
		}
		
		

	}

}

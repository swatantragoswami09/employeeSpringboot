/* 
  Class name : LinkedListMain
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.LinkedList;

import java.util.Scanner;

/**
 * LinkedListMain class is a tester/caller class.
 * @author Swatantra
 *
 */
public class LinkedListMain {

	public static void main(String[] args) {
		
		try {

			Scanner sc=new Scanner(System.in);
			LinkedList<Integer> listObject = new LinkedList<Integer>();
			
			boolean flag=true;
			while(flag) {
				System.out.println(" ");
				System.out.println("1. Insert");
				System.out.println("2. Insert at Position");
				System.out.println("3. Delete");
				System.out.println("4. Delete at Position");
				System.out.println("5. Center");
				System.out.println("6. Reverse");
				System.out.println("7. Size");
				System.out.println("8. Iterator");
				System.out.println("9. Traverse/Print");
				System.out.println("10. Exit");
				System.out.println("Enter your choice");
				int ch=sc.nextInt();
				int data,index,value,position;
				
				switch(ch) {
				case 1:
					System.out.println("Enter data");
					data=sc.nextInt();
					listObject.insert(data);
					break;
					
				case 2:System.out.println("Enter data");
				       data=sc.nextInt();
				       System.out.println("Enter position");
					   position=sc.nextInt();
					   listObject.insertAt(position, data);
					  break;
				case 3:
					System.out.println("Deleted index 0");
					listObject.delete();
					break;
				case 4:
				     System.out.println("Enter Index");
				     index=sc.nextInt();
				     listObject.deleteAt(index);     //0 1 2 
				     break;  
				case 5:
					listObject.center();
					break;
				case 6:
					listObject.reverse();
					 break;
				case 7:
					listObject.size();
					break;
				case 8:
					listObject.iteratorFunction();
				     break;		
				case 9:
					listObject.traverse();
					break;
				case 10:
					flag=false;
					break;
				default :
					System.out.println("Invalid Choice");
					break;
					
				}
			}
		

		} catch (NullPointerException e) {
			System.out.println("LinkedList is empty!");
		} catch (Exception e) {
			System.out.println("Some Other Exception occured!");
		}
		
		
	}

}
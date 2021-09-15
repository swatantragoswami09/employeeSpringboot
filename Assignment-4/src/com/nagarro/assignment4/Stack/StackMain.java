/* 
  Class name : StackMain
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.Stack;

import java.util.Scanner;

import com.nagarro.assignment4.AllExceptionContainer.UnderFlowException;

//import datastructure.java.stack.Test;
/**
 * StackMain class is a tester/caller class.
 * @author Swatantra
 *
 */
public class StackMain {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int ch,entry,value,n;
		
		try {
			System.out.println("Enter Capacity");
			n=sc.nextInt();
			
			// object of stack class
			Stack<Integer> stackObject = new Stack<Integer>();

			while(true) {
				System.out.println("1.Push");
				System.out.println("2.Pop");
				System.out.println("3.Peek");
				System.out.println("4.Contains");
				System.out.println("5.Size");
				System.out.println("6.Reverse");
				System.out.println("7.Iterator");
				System.out.println("8.Traverse");
				System.out.println("9.Quit");
				
				System.out.print("Enter your choice:");
				ch=sc.nextInt();
				
				switch(ch)
				{
				case 1:System.out.print("Enter Element :");
					   entry=sc.nextInt();
					   stackObject.pushElement(entry);
				       break;
				case 2:
					stackObject.popElement();
				       break;
				case 3:
					stackObject.peekElement();
				       break;
				case 4:
					System.out.print("Enter value :");
					   value=sc.nextInt();
					   stackObject.contain(20);				   
					   break;
				case 5:
					stackObject.size();
			           break;
				case 6:
					stackObject.reverseElement();
					   break;
				case 7:
					stackObject.iterator();
					 break;
				case 8:
					stackObject.traverseElements();
					   break;
			    case 9: System.exit(1);
			
			   default: System.out.println("Invalid choice");
			        
			
			}
			
			}
		}catch(UnderFlowException e) {
			System.out.println("Stack is Empty!");
		}catch(Exception e) {
			System.out.println("Some Other Exception occured!");
		}
	}

}
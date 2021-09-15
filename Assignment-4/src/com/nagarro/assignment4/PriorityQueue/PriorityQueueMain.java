/* 
  Class name : PriorityQueueMain
 * 
 */
package com.nagarro.assignment4.PriorityQueue;

import com.nagarro.assignment4.AllExceptionContainer.UnderFlowException;

/**
 * LinkedListMain class is a tester/caller class.
 * @author Swatantra
 *
 */
public class PriorityQueueMain {
	
	public static void main(String[] args) {
		try {
			
		
		
		PriorityQueue<Integer> PriorityQueueObject = new PriorityQueue<Integer>();
		
		
		PriorityQueueObject.Insert(45);
		PriorityQueueObject.Insert(20);
		PriorityQueueObject.Insert(14);
		
		PriorityQueueObject.display();
		
		System.out.println("Delete method is called");
		PriorityQueueObject.delete();
		
		System.out.println("After deletion Priority Queue Will be Look like: ");
		PriorityQueueObject.display();
		
		System.out.println("Reverse is called");
		PriorityQueueObject.reverse();
		
		System.out.println("Size of Priority Queue: ");
		PriorityQueueObject.sizeFunction();

		System.out.println("Peek Element of Priority Queue: ");
		PriorityQueueObject.peekElement();
		
//		System.out.println("PQ Contains 14: ");
//		PriorityQueueObject.contain(14);
//		
		}catch(UnderFlowException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println("Some Other Exception occured!");
		}
	}

}
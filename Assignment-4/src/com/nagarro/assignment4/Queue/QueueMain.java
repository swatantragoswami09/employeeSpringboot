/* 
  Class name : QueueMain
 * 
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.Queue;

import com.nagarro.assignment4.AllExceptionContainer.UnderFlowException;

/**
 * QueueMain class is a tester/caller class.
 * @author Swatantra
 *
 */
public class QueueMain {
	public static void main(String[] args) {
		
		try {
		
		//object of queue class
		Queue<String> queueObject = new Queue<String>();
		queueObject.enqueueFunction("SKG");
		queueObject.enqueueFunction("Goswami");
		queueObject.enqueueFunction("hello");
		queueObject.enqueueFunction("ok");
		queueObject.dequeueFunction();
		System.out.println("Displaying Queue using iterator :");
		queueObject.iterator();
		System.out.println("Displaying Queue using traverse function :");
		queueObject.traverseFunction();
//		System.out.println(" :");
		System.out.println("Display peek value in queue : ");
		queueObject.peekFunction();
		System.out.println("Displaying size of the queue :");
		queueObject.sizeFunction();
		System.out.println("Reversing queue :");
		queueObject.reverseFunction();
		System.out.println("Contains method :");
		queueObject.containFunction("Goswami");		
		
	}catch(UnderFlowException e) {
		System.out.println("Queue is Empty!");
	}
		catch(Exception e) {
		System.out.println("Some Other Exception occured!");
	}
		
	
	}
}
/* 
  Class name : Queue
 * 
 */
package com.nagarro.assignment4.Queue;

import com.nagarro.assignment4.AllExceptionContainer.UnderFlowException;


/**
 * 
 * @author Swatantra
 *
 * @param <T> Generic Queue class which contains all implementation.
 */
public class Queue<T> {
	
	QNode<T> front = null;
	QNode<T> rear = null;

	
	/**
	 *  The Below function is to enqueue the element in the queue.
	 * @param data is the value that will be enqueued.
	 */
	public void enqueueFunction(T data) {
		
		QNode<T> node = new QNode<T>();
		node.setData(data);
		node.next = null;
		
		if(front == null && rear == null) {
			front = rear = node;
		}
		else {
			rear.next = node;
			rear = node;
		}
	}

	/**
	 * The Below function is to dequeue the element in the queue.
	 * @throws UnderFlowException
	 */
	public void dequeueFunction() throws UnderFlowException {
		
		if(front == null && rear == null) {
			throw new UnderFlowException();
		}
		else {
			System.out.println("Dequeued element is: "+ front.getData());
			front = front.next;
		}
		
		
	}

	/**
	 * The below function is to traverse the queue.
	 * @throws UnderFlowException
	 */
	public void traverseFunction() throws UnderFlowException {
		QNode<T> tempNode = front;
		
		if(front == null && rear == null) {
			throw new UnderFlowException();
		}
		else {
			while(tempNode!=null) {
				System.out.println(tempNode.getData());
				tempNode = tempNode.next;
			}
		}
		
	}

	/**
	 * The below function is to get the peek element in the queue.
	 * @throws UnderFlowException
	 */
	public void peekFunction() throws UnderFlowException{

		if (front == null && rear == null) {
			throw new UnderFlowException();
		} else {
			System.out.println("Peek value is: "+front.getData());
		}
	}
	
	/**
	 * The Below function is to check whether the item is present or not.
	 * @param item the element to be searched.
	 * @return
	 */
	public int containFunction(T item) {
		int position = 0;
		QNode<T> tempNode = front;
		
		while(tempNode != null) {
			position++;
			if (tempNode.getData() == item) {
				System.out.println("Found at position:" + position);
				return 0;
			}
			tempNode = tempNode.next;
	}
		System.out.println("not found");
		return 0;
		
	}
	
	/**
	 * Get the number of element in the queue.
	 */
	public void sizeFunction() {
		int count = 0;
		QNode<T> tempNode = front;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.next;
		}
		System.out.println("Size of Queue: "+ count);
		
		
	}
	
	/**
	 * The below function reverse the queue.
	 * @throws UnderFlowException
	 */
	public void reverseFunction() throws UnderFlowException {
		if (front == null && rear == null) {
			throw new UnderFlowException();
		}
		
		QNode<T> previousNode = null;
		QNode<T> currentNode = front;
		QNode<T> nextNode = front;
		
		while(nextNode != null) {
			nextNode = nextNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		front = previousNode;
		traverseFunction();
		
		}
		
	
	/**
	 *  the below iterator function is for iterating the queue using iterator class using
	 *   functions{hasNext(),next()}.
	 */
	public void iterator() {
		QIterator<T> iterator = new QIterator<>(front);
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+ " ");
		}
		System.out.println();
		
	}

}
/* 
  Class name : Stack
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.Stack;

import com.nagarro.assignment4.AllExceptionContainer.UnderFlowException;


/**
 * 
 * @author Swatantra
 */
public class Stack<T> {

	SNode<T> top = null;

	// push function
	public void pushElement(T data){

		SNode<T> node = new SNode<T>();
		node.setData(data);
		node.next = top;
		top = node;

	}
	
	// pop function
	public void popElement() throws UnderFlowException {

		if (top == null) {
			throw new UnderFlowException();

		} else {

			System.out.println("Pop element is:" + top.getData());
			top = top.next;

		}
	}

	// peek element
	public void peekElement() throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException();

		} else {
			System.out.println("Peek value is: " + top.getData());
		}
	}

	
	/**
	 * The Below function is to check whether the item is present or not.
	 * @param item is the value that is to searched
	 * 
	 * @throws UnderFlowException
	 */
	public int contain(T item) throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException();

		}

		int position = 0;
		SNode<T> tempNode = top;

		while (tempNode != null) {
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
	 * Get the number of element in the stack.
	 */
	public void size() {
		int count = 0;
		SNode<T> tempNode = top;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.next;
		}
		System.out.println("Size of Stack: " + count);
	}

	
	/**
	 * The below function reverse the stack.
	 * @throws UnderFlowException
	 */
	public void reverseElement() throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException();

		}

		SNode<T> previousNode = null;
		SNode<T> currentNode = top;
		SNode<T> nextNode = top;

		while (nextNode != null) {
			nextNode = nextNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		top = previousNode;
		traverseElements();

	}

	/**
	 * the below iterator function is for iterating the queue using iterator class using
	 * functions{hasNext(),next()}.
	 */
public void iterator() {
		
		SIterator<T> iterator = new SIterator<>(top);
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+ " ");
		}
		System.out.println();

	}


/**
 * The below function is to traverse the Stack.
 * @throws UnderFlowException
 */
	public void traverseElements() throws UnderFlowException {
		if (top == null) {
			throw new UnderFlowException();

		}

		SNode<T> tempNode = top;
		while (tempNode != null) {

			if (top == null) {
				System.out.println("Stack is empty");
			} else {
				System.out.println(tempNode.getData());
				tempNode = tempNode.next;

			}

		}

	}

}
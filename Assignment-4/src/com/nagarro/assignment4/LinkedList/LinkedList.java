/* 
  Class name : LinkedList
  
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.LinkedList;

/**
 * 
 * @author Swatantra
 *
 */
public class LinkedList<T> {

	LLNode<T> head;

	//	insert data at the end
	public void insert(T data) {

		LLNode<T> node = new LLNode<T>();
		node.setData(data);
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			LLNode<T> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}

	}

	//	insert at start
	public void insertAtStart(T data) {
		LLNode<T> node = new LLNode<T>();
		node.setData(data);
		node.next = null;
		node.next = head;
		head = node;
	}

	//	insert at given index
	public void insertAt(int index, T data) {

		LLNode<T> node = new LLNode<T>();
		node.setData(data);
		node.next = null;

		if (index == 0) {
			insertAtStart(data);
		} else {
			LLNode<T> tempNode = head;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;

			}
			node.next = tempNode.next;
			tempNode.next = node;
		}
	}

	//delete node at start
	public void delete() {
		LLNode<T> tempNode = null;
		tempNode = head;
		head = tempNode.next;
		tempNode = null;
	}

	// delete at given index
	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			LLNode<T> tempNode = head;
			LLNode<T> tempNode2 = null;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode2 = tempNode.next;
			tempNode.next = tempNode2.next;
			System.out.println("element deleted is :" + tempNode2.getData());
			tempNode2 = null;
		}
	}

	// to find centered of list
	public void center() throws NullPointerException {
		if (head == null) {
			throw new NullPointerException();
		}

		LLNode<T> fastNode = head;
		LLNode<T> slowNode = head;
		if (head != null) {

			while (fastNode.next != null && fastNode.next.next != null) {
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}
			System.out.println("center is:" + slowNode.getData());

		}
	}

	// Reverse linked list
	public void reverse() throws NullPointerException {
		if (head == null) {
			throw new NullPointerException();
		}
		LLNode<T> previousNode = null;
		LLNode<T> currentNode = head;
		LLNode<T> nextNode = head;

		while (nextNode != null) {
			nextNode = nextNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		head = previousNode;
		traverse();

	}

	// number of nodes in the linked list
	public void size() {
		int count = 0;
		LLNode<T> tempNode = head;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.next;
		}
		System.out.println(count);

	}

	/**
	 * iterator is for iterating the list using iterator class functions{hasNext(),
	 * next()}
	 */
	public void iteratorFunction() {
		LLIterator<T> iterator = new LLIterator<>(head);
		System.out.print("Linked List =>" );
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();

	}

	// traversing the linked list
	public void traverse() throws NullPointerException {
		if (head == null) {
			throw new NullPointerException();
		}

		LLNode<T> tempNode = head;

		System.out.print("Linked List => ");
		while (tempNode.next != null) {

			System.out.print(" "+tempNode.getData()+" ");
			tempNode = tempNode.next;
		}
		System.out.print(" "+tempNode.getData());

	}

}
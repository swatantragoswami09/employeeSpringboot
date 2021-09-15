/* 
  Class name : PriorityQueue
 * 
 */
package com.nagarro.assignment4.PriorityQueue;

import java.util.ArrayList;

import com.nagarro.assignment4.AllExceptionContainer.UnderFlowException;

/**
 *
 * @param <T> the below class is of generic type.
 */
public class PriorityQueue<T extends Comparable<T>> {

	ArrayList<T> data;

	public PriorityQueue() {

		data = new ArrayList<T>(10);
	}

	
	/**
	 *The below function insert the value in the heap.
	 * @param value
	 */
	public void Insert(T value) {
		data.add(value);
		upheapify(data.size() - 1);
	}

	/**
	 * Upheapify method to move the node in upward direction according to it's priority.
	 * @param childIndex is the index of child.
	 */
	private void upheapify(int childIndex) {
		if (childIndex == 0) {
			return;
		}
		int parentIndex = (childIndex - 1) / 2;
		if (data.get(childIndex).compareTo(data.get(parentIndex)) < 0) {
			swap(childIndex, parentIndex);
			upheapify(parentIndex);
		}
	}

	/**
	 *  swap function is to swap the value .
	 * @param childIndex is index of child.
	 * @param parentIndex is index of parent.
	 */
	private void swap(int childIndex, int parentIndex) {
		T smallValuve = data.get(childIndex);
		T largeValue = data.get(parentIndex);
		data.set(childIndex, largeValue);
		data.set(parentIndex, smallValuve);
	}

	/**
	 * The below function delete the element of highest priority.
	 * @throws UnderFlowException
	 */
	public void delete() throws UnderFlowException {
		if (data.size() == 0) {
			throw new UnderFlowException();

		}
		swap(0, data.size() - 1);
		T deletedValue = data.remove(data.size() - 1);
		downheapify(0);
		System.out.println("Root item Deleted: " + deletedValue);

	}

	/**
	 * downheapify method to move the node in downward direction according to it's priority.
	 * @param parentIndex
	 */
	private void downheapify(int parentIndex) {

		int minIndex = parentIndex;

		int leftIndex = 2 * parentIndex + 1;
		if (leftIndex < data.size() && data.get(leftIndex).compareTo(data.get(minIndex)) < 0) {
			minIndex = leftIndex;
		}

		int rightIndex = 2 * parentIndex + 2;
		if (rightIndex < data.size() && data.get(rightIndex).compareTo(data.get(minIndex)) < 0) {
			minIndex = rightIndex;
		}
		if (minIndex != parentIndex) {
			swap(parentIndex, minIndex);
			downheapify(minIndex);
		}
	}

	/**
	 * To get the peek element.
	 * @throws UnderFlowException
	 */
	public void peekElement() throws UnderFlowException {
		if (data.size() == 0) {
			throw new UnderFlowException();

		}
		System.out.println("Peek Element is: " + data.get(0));

	}

	/**
	 * The below function tell the size of priority queue.
	 */
	public void sizeFunction() {

		int size = data.size();
		System.out.println("Size is: " + size);

	}

	/**
	 * The display function is the traverse function it print's the value of priority queue.
	 * @throws UnderFlowException
	 */
	public void display() throws UnderFlowException {
		if (data.size() == 0) {
			throw new UnderFlowException();
		}

		for (T element : data) {
			System.out.println(element + " ");
		}
		System.out.println();

	}

	/**
	 * The below function search the given value is present or not.
	 * @param value is the item/data to be searched.
	 * @throws UnderFlowException
	 */
	public void contain(int value) throws UnderFlowException {
		if (data.size() == 0) {
			throw new UnderFlowException();
		}

		if (data.contains(value)) {
			System.out.println("Yes, Element found at index: " + data.indexOf(value));
		} else {
			System.out.println("Element Not found");
		}
	}

	/**
	 * the below function reverse the whole priority queue. 
	 * @throws UnderFlowException
	 */
	public void reverse() throws UnderFlowException {
		if (data.size() == 0) {
			throw new UnderFlowException();
		}

		ArrayList<T> revData = new ArrayList<>();
		for (int i = data.size() - 1; i >= 0; i--) {
			revData.add(data.get(i));
		}
		for (T element : revData) {
			System.out.println(element + " ");
		}
		System.out.println();

	}

}
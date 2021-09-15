/* 
  Class name : SIterator
 * 
 * Author info: Swatantra
*
 */
package com.nagarro.assignment4.Stack;

import java.util.Iterator;


/**
 * SIterator class.
 * 
 * @author Swatantra
 *
 */
public class SIterator<T> implements Iterator<T>{
	

	SNode<T>  current;
	
	public SIterator(SNode<T> n) {
		this.current = n;
	}
	
	public boolean hasNext() {
		if(current == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public T next() {
		T data = current.getData();
		current= current.next;
		return data;
	}

}

/* 
  Class name : LLIterator
 * 
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.LinkedList;
import java.util.Iterator;


/**
 * LLIterator class.
 * 
 */
public class LLIterator<T> implements Iterator<T> {
	LLNode<T>  current;
	
	public LLIterator(LLNode<T> node) {
		this.current = node;
	}
	
	@Override
	public boolean hasNext() {
		if(current == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public T next() {
		T data = current.getData();
		current= current.next;
		return data;
	}

}

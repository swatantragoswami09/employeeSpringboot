/* 
  Class name : QIterator
 * 
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.Queue;

import java.util.Iterator;

/**
 * QIterator class.
 * 
 * @author Swatantra
 *
 * @param <T> Generic for all datatype.
 */
public class QIterator<T> implements Iterator<T>{

		QNode<T>  current;
		
		public QIterator(QNode<T> node) {
			this.current = node;
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



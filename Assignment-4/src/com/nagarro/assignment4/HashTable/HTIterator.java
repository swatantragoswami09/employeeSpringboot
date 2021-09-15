/* 
  Class name : HTIterator
 * 
 * for overriding method definition and use them.
 */
package com.nagarro.assignment4.HashTable;

import java.util.Iterator;


/**
 * HTIterator class.
 * 
 * @author Swatantra
 *
 * @param <T> Generic for all datatype.
 */
public class HTIterator<K,V> implements Iterator<HTNode<K, V>>{
	HTNode<K, V>[]  curr;
	int index = 0;
	private int size = 0;
	
	public HTIterator(HTNode<K, V>[] table) {
		curr = table;
		this.size = size();
	}
	
	public int size() {
		System.out.println(curr.length);
		return curr.length;
	}
	
	public boolean hasNext() {
		return index < size;
	}
	
	public HTNode<K, V> next(){
		HTNode<K, V> e = curr[index];
		index++;
		return e;
	}
	
}

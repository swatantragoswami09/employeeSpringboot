/* 
  Class name : HTNode
 * 
 */
package com.nagarro.assignment4.HashTable;

/**
 * The below class HTNode of any type contains
 * a key,value pair and link next.
 * 
 * @author Swatantra
 *
 * @param <T> It is of generic type.
 */
public class HTNode<K,V> {
	private K key;
	private V value;
	private HTNode<K, V> next;
	
	public HTNode(K key, V val) {
		this.key= key;
		this.value = val;
		this.next = null;
	}
	
	/**
	 * Getter Setter to set the private instance variable .
	 */
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HTNode<K, V> getNext() {
		return next;
	}

	public void setNext(HTNode<K, V> next) {
		this.next = next;
	}
	
}
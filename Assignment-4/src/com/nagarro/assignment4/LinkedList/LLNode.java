/* 
  Class name : LLNode
 *
 * Copyright notice
 * 
 */
package com.nagarro.assignment4.LinkedList;
/**
 * The below class LLNode of any type contains
 * a data and link next.
 * 
 */
public class LLNode<T> {
	
	private T data;
	LLNode<T> next;

/**
 * Getter Setter to set the private instance variable .
 */
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	}
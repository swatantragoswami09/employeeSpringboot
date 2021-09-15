/* 
  Class name : QNode
 * 
 * 
 * Author info: Swatantra
 * 
 */
package com.nagarro.assignment4.Queue;

/**
 * The below class QNode of any type contains
 * a data and link next.
 * 
 * @author Swatantra
 *
 * @param <T> It is of generic type.
 */
public class QNode<T> {
	
	private T data;
	
/**
 * Getter Setter to set the private instance variable .
 */
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	QNode<T> next;

}

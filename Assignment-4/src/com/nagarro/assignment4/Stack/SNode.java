/* 
  Class name : SNode
 * 
 * Author info: Swatantra
 * *
 
 */
package com.nagarro.assignment4.Stack;

/**
 * The below class SNode of any type contains
 * a data and link next.
 * 
 * @author Swantantra
 *
 * @param <T> It is of generic type.
 */
public class SNode<T> {
	
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
	
	SNode<T> next;

}

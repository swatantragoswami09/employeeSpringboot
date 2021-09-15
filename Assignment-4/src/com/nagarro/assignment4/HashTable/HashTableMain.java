/* 
  Class name : HashTableMain
 * 
 */
package com.nagarro.assignment4.HashTable;


/**
 * LinkedListMain class is a tester/caller class.
 * @author Swatantra
 *
 */
public class HashTableMain {
	
	public static void main(String[] args) {
		HashTable<Integer, String> HashObj = new HashTable<>();
		HashObj.insert(20, "Swatantra");
		HashObj.insert(22, "Goswami");
		HashObj.insert(32, "cool");
		HashObj.insert(27, "Good");
		HashObj.insert(37, "Morning");
		HashObj.traverse();
		
//		System.out.println(HashObj.getIndex(22));
//		System.out.println(HashObj.getIndex(27));
		
		HashObj.containsKey(25);
		
//		System.out.println(HashObj.getValueByKey(22));
//		System.out.println(HashObj.getValueByKey(32));
//		HashObj.remove(27);
		
		HashObj.traverse();
	}

}

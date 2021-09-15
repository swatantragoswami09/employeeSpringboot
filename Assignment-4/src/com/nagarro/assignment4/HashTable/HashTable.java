/* 
  Class name : HashTable
 * 
 * 
 */
package com.nagarro.assignment4.HashTable;

/**
 * 
 * @author Swatantra
 *
 * @param <T> Generic Hash table class which contains all implementation.
 */
public class HashTable<K, V> {
	
	
	private int arraySize = 10;
	HTNode<K, V> table[];

	/**
	 * Default constructor.
	 */
	public HashTable() {
		table = new HTNode[arraySize];
	}

	/**
	 * Parameterized constructor.
	 * @param size is the capacity of array.
	 */
	public HashTable(int size) {
		this.arraySize = size;
		table = new HTNode[size];

	}

	/**
	 * The function below gives the unique value of index. 
	 * @param key
	 * @return
	 */
	public int getIndex(K key) {
		int hashCode = key.hashCode();
		if (hashCode < 0) {
			hashCode = hashCode * -1;
		}
		return hashCode % arraySize;
	}

	/**
	 * The below function insert the key value pair node at the array index.
	 * @param key this is unique key for every node.
	 * @param value the date to be inserted in table.
	 */
	public void insert(K key, V value) {

		int index = getIndex(key);
		HTNode<K, V> newnode = new HTNode<>(key, value);
		if (table[index] == null) {
			table[index] = newnode;
		} else {
			HTNode<K, V> prevNode = null;
			HTNode<K, V> currNode = table[index];

			while (currNode != null) {
				if (currNode.getKey().equals(key)) {
					currNode.setValue(value);
					break;
				}
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			if (prevNode != null) {
				prevNode.setNext(newnode);
			}
		}
	}
	
/**
 * The below function remove the node from the table using the key.
 * @param key  key is unique for every node to be deleted.
 */
	public void remove(K key) {
		int index = getIndex(key);

		HTNode<K, V> currNode = table[index];
		HTNode<K, V> prevNode = null;

		while (currNode != null) {
			if (currNode.getKey().equals(key)) {
				break;
			} else {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
		try {

			if (prevNode != null) {
				prevNode.setNext(currNode.getNext());
			} else {
				table[index] = currNode.getNext();

			}

			System.out.println("Removed item is: " + currNode.getValue());

		} catch (NullPointerException e) {
			System.out.println("null");
		}
	}

	
	/**
	 * The below function will give the value present at the key.
	 */
	public V getValueByKey(K key) {
		int index = getIndex(key);
		HTNode<K, V> temp = table[index];
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp.getValue();
			}
			temp = temp.getNext();
		}
		return null;
	}

	
	/**
	 * The below function finds the given key is present in table or not.
	 * @param key
	 */
	public void containsKey(K key) {
		int index = getIndex(key);
		HTNode<K, V> temp = table[index];


		while (temp != null) {
			if (temp.getKey().equals(key)) {

				System.out.println(key + " present in Hash Table");
				return;
			}
			temp = temp.getNext();
		}
		System.out.println(key + " not present in Hash Table");

	}
	
	/**
	 * Traverse function is for traversing the table.
	 */
	public void traverse() {
		for (int i = 0; i < arraySize; i++) {
			HTNode<K, V> temp = table[i];
			while (temp != null) {
				System.out.println("key: " + temp.getKey() + " value: " + temp.getValue());
				temp = temp.getNext();
			}
		}
	}
	
	
	
	/**
	 * Iterator function is to iterate the table using hasNext and next function in iterator class
	 */
	public void iterator() {

		HTIterator<K,V> iterator = new HTIterator<K,V>(table);
		
		while(iterator.hasNext()) {
			
			System.out.println(iterator.next()+ " ");
		}
		System.out.println();

	}

/**
 * The below function will calculate the size of table.
 * @return
 */
	public int size() {
		int count = 0;
		for (int i = 0; i < arraySize; i++) {
			HTNode<K, V> temp = table[i];
			while (temp != null) {
				count++;
				temp = temp.getNext();
			}
		}
		return count;
	}

}
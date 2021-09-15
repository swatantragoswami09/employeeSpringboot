/* 
  Class name : NchildTreeMain
 * 
 */
package com.nagarro.assignment4.NchildTree;

import java.util.List;


/**
 * LinkedListMain class is a tester/caller class.
 * @author Swatantra
 *
 */
public class NchildTreeMain {

    public static void main(String[] args) {
    	// Create a new Integer type node
    	TNode<Integer> root = new TNode<Integer>(1);
    	 
    	// Add a child
    	root.addChild(new TNode<Integer>(2));
    	root.addChild(new TNode<Integer>(3));
    	root.addChild(new TNode<Integer>(4));
    	//Get the elements
    	System.out.println(root.getChildAt(2));
    	System.out.println(root.getChildren());
    	 
    	// Create a tree, providing the root node
    	NchildTree<Integer> tree = new NchildTree<Integer>(root);
    	 
    	// BFS
    	List<TNode<Integer>> bfs = tree. breadthfirstsearch();
    	System.out.println(bfs);
    	System.out.println(bfs.size());
    	//DFS
    	List<TNode<Integer>> dfs = tree. deapthfirstsearch();
    	System.out.println(dfs);
    	System.out.println(dfs.size());
//    	
    	
    	
    	
	}

}
/* 
  Class name : NchildTree
 * 
  
 */
package com.nagarro.assignment4.NchildTree;

import java.util.ArrayList;


/**
 * Generic N Child Tree.
 *
 * @param <T> Any class type
 */
public class NchildTree<T> {

    private TNode<T> root;

    /**
     * Initialize a tree with the specified root node.
     *
     * @param root The root node of the tree
     */
    public NchildTree(TNode<T> root) {
        this.root = root;
    }

    /**
     * Checks if the tree is empty (root node is null)
     *
     * @return <code>true</code> if the tree is empty,
     * <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Get the root node of the tree
     *
     * @return the root node.
     */
    public TNode<T> getRoot() {
        return root;
    }

    /**
     * Set the root node of the tree. Replaces existing root node.
     *
     * @param root The root node to replace the existing root node with.
     */
    public void setRoot(TNode<T> root) {
        this.root = root;
    }

    /**
     *
     * Check if given data is present in the tree.
     *
     * @param key The data to search for
     * @return <code>true</code> if the given key was found in the tree,
     * <code>false</code> otherwise.
     */
    public boolean exists(T key) {
        return find(root, key);
    }

    /**
     * Get the number of nodes (size) in the tree.
     *
     * @return The number of nodes in the tree
     */
    public int size() {
        return getNumberOfDescendants(root) + 1;
    }

    /**
     *
     * Get the number of descendants a given node has.
     *
     * @param node The node whose number of descendants is needed.
     * @return the number of descendants
     */
    public int getNumberOfDescendants(TNode<T> node) {
        int n = node.getChildren().size();
        for (TNode<T> child : node.getChildren())
            n += getNumberOfDescendants(child);

        return n;

    }

    private boolean find(TNode<T> node, T keyNode) {
        boolean res = false;
        if (node.getData().equals(keyNode))
            return true;

        else {
            for (TNode<T> child : node.getChildren())
                if (find(child, keyNode))
                    res = true;
        }

        return res;
    }

    private TNode<T> findNode(TNode<T> node, T keyNode) {
        if (node == null)
            return null;
        if (node.getData().equals(keyNode))
            return node;
        else {
            TNode<T> cnode = null;
            for (TNode<T> child : node.getChildren())
                if ((cnode = findNode(child, keyNode)) != null)
                    return cnode;
        }
        return null;
    }

    /**
     *
     * Get the list of nodes arranged by the pre-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the pre-order
     */
    public ArrayList<TNode<T>> breadthfirstsearch() {
        ArrayList<TNode<T>> bfs = new ArrayList<TNode<T>>();
        buildbfs(root, bfs);
        return bfs;
    }

    /**
     *
     * Get the list of nodes arranged by the post-order traversal of the tree.
     *
     * @return The list of nodes in the tree, arranged in the post-order
     */
    public ArrayList<TNode<T>> deapthfirstsearch() {
        ArrayList<TNode<T>> dfs = new ArrayList<TNode<T>>();
        builddfs(root, dfs);
        return dfs;
    }

    private void buildbfs(TNode<T> node, ArrayList<TNode<T>> bfs) {
        bfs.add(node);
        for (TNode<T> child : node.getChildren()) {
            buildbfs(child, bfs);
        }
    }

    private void builddfs(TNode<T> node, ArrayList<TNode<T>> dfs) {
        for (TNode<T> child : node.getChildren()) {
            builddfs(child, dfs);
        }
        dfs.add(node);
    }

    /**
     *
     * Get the list of nodes in the longest path from root to any leaf in the tree.
     *
     * @return The list of nodes in the longest path.
     */
    public ArrayList<TNode<T>> getLongestPathFromRootToAnyLeaf() {
        ArrayList<TNode<T>> longestPath = null;
        int max = 0;
        for (ArrayList<TNode<T>> path : getPathsFromRootToAnyLeaf()) {
            if (path.size() > max) {
                max = path.size();
                longestPath = path;
            }
        }
        return longestPath;
    }//
    
    public ArrayList<Integer> bfs(ArrayList<TNode> queue,ArrayList<Integer> resultArray) {
        if (queue.size() == 0) {
            return resultArray;
        }

        TNode currentNode = queue.remove(0);
        resultArray.add(currentNode.value);
        if (currentNode.left != null) {
            queue.add((TNode) currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add((TNode) currentNode.right);
        }

        return bfs(queue, resultArray);
    }


    /**
     *
     * Get the height of the tree (the number of nodes in the longest path from root to a leaf)
     *
     * @return The height of the tree.
     */
    public int getHeight() {
        return getLongestPathFromRootToAnyLeaf().size();
    }

    /**
     *
     * Get a list of all the paths (which is again a list of nodes along a path) from the root node to every leaf.
     *
     * @return List of paths.
     */
    public ArrayList<ArrayList<TNode<T>>> getPathsFromRootToAnyLeaf() {
        ArrayList<ArrayList<TNode<T>>> paths = new ArrayList<ArrayList<TNode<T>>>();
        ArrayList<TNode<T>> currentPath = new ArrayList<TNode<T>>();
        getPath(root, currentPath, paths);

        return paths;
    }

    private void getPath(TNode<T> node, ArrayList<TNode<T>> currentPath,
                         ArrayList<ArrayList<TNode<T>>> paths) {
        if (currentPath == null)
            return;

        currentPath.add(node);

        if (node.getChildren().size() == 0) {
            // This is a leaf
            paths.add(clone(currentPath));
        }
        for (TNode<T> child : node.getChildren())
            getPath(child, currentPath, paths);

        int index = currentPath.indexOf(node);
        for (int i = index; i < currentPath.size(); i++)
            currentPath.remove(index);
    }

    private ArrayList<TNode<T>> clone(ArrayList<TNode<T>> list) {
        ArrayList<TNode<T>> newList = new ArrayList<TNode<T>>();
        for (TNode<T> node : list)
            newList.add(new TNode<T>(node));

        return newList;
    }

}
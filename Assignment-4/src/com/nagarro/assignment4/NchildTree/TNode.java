/* 
  Class name : HTNode
 * 
 */
package com.nagarro.assignment4.NchildTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A node of any type. A node contains a data and links to it's children and it's parent.
 * It also contain addchild and other method implementation
 *
 * @param <T> The class type of the node
 */
public class TNode<T> {
    private T data;
    private List<TNode<T>> children;
    private TNode<T> parent;
	public Integer value;
	public Object left;
	public Object right;

    public TNode(T data) {
        this.data = data;
        this.children = new ArrayList<TNode<T>>();
    }

    /**
     * Initialize a node with another node's data.
     * This does not copy the node's children.
     *
     * @param node The node whose data is to be copied.
     */
    public TNode(TNode<T> node) {
        this.data = node.getData();
        children = new ArrayList<TNode<T>>();
    }

    /**
     *
     * Add a child to this node.
     *
     * @param child child node
     */
    public void addChild(TNode<T> child) {
        child.setParent(this);
        children.add(child);
    }

    /**
     *
     * Add a child node at the given index.
     *
     * @param index The index at which the child has to be inserted.
     * @param child The child node.
     */
    public void addChildAt(int index, TNode<T> child) {
        child.setParent(this);
        this.children.add(index, child);
    }

    public void setChildren(List<TNode<T>> children) {
        for (TNode<T> child : children)
            child.setParent(this);

        this.children = children;
    }

    /**
     * Remove all children of this node.
     */
    public void removeChildren() {
        this.children.clear();
    }

    /**
     *
     * Remove child at given index.
     *
     * @param index The index at which the child has to be removed.
     * @return the removed node.
     */
    public TNode<T> removeChildAt(int index) {
        return children.remove(index);
    }

    /**
     * Remove given child of this node.
     *
     * @param childToBeDeleted the child node to remove.
     * @return <code>true</code> if the given node was a child of this node and was deleted,
     * <code>false</code> otherwise.
     */
    public boolean removeChild(TNode<T> childToBeDeleted) {
        List<TNode<T>> list = getChildren();
        return list.remove(childToBeDeleted);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TNode<T> getParent() {
        return this.parent;
    }

    public void setParent(TNode<T> parent) {
        this.parent = parent;
    }

    public List<TNode<T>> getChildren() {
        return this.children;
    }

    public TNode<T> getChildAt(int index) {
        return children.get(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof TNode) {
            if (((TNode<?>) obj).getData().equals(this.data))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
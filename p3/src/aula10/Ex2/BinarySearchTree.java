				package aula10.Ex2;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
	
	// o elemento do tipo T deve ser comparável para efectuar pesquisas
	// mas como pode herdar a implementação de compareTo() é mais correcto
	// usar <? super T>
	
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
	}
	
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	
	public void insert(T value) {
		if(!contains(value) && value != null) root = insert(value, root);
	}
	
	private BSTNode<T> insert(T value, BSTNode<T> r) {
		if(r == null) {			
			numNodes++;
			return new BSTNode<T>(value);
			
		} else if(value.compareTo(r.element) <= 0) {
			if(r.left == null) {
				numNodes++;
				r.left = new BSTNode<T>(value);
			} else return insert(value, r.left);
			
		} else {
			if(r.right == null) {
				numNodes++;
				r.right = new BSTNode<T>(value);
			} else return insert(value, r.right);
		}
		
		return r;
	}

	public void remove(T value) {
		if (contains(value) && value != null) root = remove(value, root);
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> r) {
		assert r != null;
		if(value.compareTo(r.element) < 0) r.left = remove(value, r.left);
		else if(value.compareTo(r.element) > 0) r.right = remove(value, r.right);
		
		else if(value.equals(root.element)) {
			if(r.left == null) return r = r.right;
			else if(r.right == null) return r = r.left;			
			else return insert(root.left.element, root.right);
		}
	
		return r;
	}

	@SuppressWarnings("unchecked")
	public boolean contains(T value) {
		return valueOf((BSTNode<T>) find(value, root)) != null;
	}
	
	private T valueOf(BSTNode<T> find) {
		if(find==null) return null;
		return find.element;
	}

	@SuppressWarnings("unchecked")
	private T find(T value, BSTNode<T> r) {
		if(r != null) {
			if (r.element.equals(value)) return (T) r;
			else if(r.left != null && r.element.compareTo(value) <= 0) return find(value, root.left);
			else if(r.right != null && r.element.compareTo(value) > 0) return find(value, root.right);
		}
		return null;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}
	
	public class BSTIterator<E> implements Iterator<E> {
		Stack<BSTNode<E>> stack;
	 
		public BSTIterator(BSTNode<E> root) {
			stack = new Stack<BSTNode<E>>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
	 
		public boolean hasNext() {
			return !stack.isEmpty();
		}
	 
		public E next() {
			BSTNode<E> node = stack.pop();
			E top = node.element;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return top;
		}
	}	

}

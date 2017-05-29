package com.gmail.shatskiy.leha.set.tree;

import com.gmail.shatskiy.leha.set.SetDemo;

public class TreeSetDemo<E> implements SetDemo<E> {

	private Node root;
	private int size;

	@Override
	public boolean add(E element) {
		Node newNode = new Node(element);
		int h1 = newNode.hash;
		if (root == null) {
			root = newNode;
			size++;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (h1 < current.hash) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						size++;
						return true;
					}
				} else {
					current = current.rightChild;
					if (current != null && current.hash == h1) {
						if (current.fData.equals(element))
							;
						return true;
					}
					if (current == null) {
						parent.rightChild = newNode;
						size++;
						return true;
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean remove(Object element) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		int h1 = element.hashCode();

		while (current.hash != h1) {
			parent = current;
			if (h1 < current.hash) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {
				return false;
			}
		}
		if (current.leftChild == null && current.rightChild == null) {
			if (current.hash == root.hash && current.fData.equals(root.fData)) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
		// удаление узла с одним потомком
		else if (current.rightChild == null) {
			if (current.hash == root.hash && current.fData.equals(root.fData)) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if (current.leftChild == null) {
			if (current.hash == root.hash && current.fData.equals(root.fData)) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		}
		// удаление узла с двумя потомком
		else {
			Node successor = getSuccessor(current);
			if (current.hash == root.hash && current.fData.equals(root.fData)) {
				successor.leftChild = root.leftChild;
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
				successor.leftChild = current.leftChild;

			} else {
				parent.rightChild = successor;
				successor.leftChild = current.leftChild;
			}
		}
		size--;
		return true;
	}

	@Override
	public boolean conteins(Object element) {
		Node current = root;
		int h1 = element.hashCode();
		while (current.hash != h1) {
			if (h1 < current.hash) {
				current = current.leftChild;
			} else {
				current = current.rightChild;

			}
			if (current == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	public void getTreeSet() {
		inOrder(root);
		System.out.println();
	}

	private Node getSuccessor(Node delNode) {
		Node succParent = delNode;
		Node succ = delNode;
		Node current = delNode.rightChild;
		while (current != null) {
			succParent = succ;
			succ = current;
			current = current.leftChild;
		}
		if (succ.hash != delNode.rightChild.hash && !succ.fData.equals(delNode.rightChild.fData)) {
			succParent.leftChild = succ.leftChild;
			succ.rightChild = delNode.rightChild;
		}
		return succ;
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.fData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	private class Node<E> {
		int hash;
		Object fData;
		Node leftChild;
		Node rightChild;

		Node(Object fData) {
			this.fData = fData;
			hash = fData.hashCode();
		}
	}
}
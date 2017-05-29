package com.gmail.shatskiy.leha.list.linked;

import com.gmail.shatskiy.leha.list.ListDemo;

public class LinkedListDemo<E> implements ListDemo {

	private int size = 0;
	private Node first;
	private Node last;

	@Override
	public E get(int index) {
		Node findNode = getNode(index);
		return (E) findNode.value;
	}

	private Node getNode(int index) {
		Node findNode;
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			findNode = first;
			for (int i = 0; i < index; i++) {
				findNode = findNode.next;
			}
		}
		return findNode;
	}

	@Override
	public boolean add(Object element) {
		Node newNode = new Node(element);
		if (first == null) {
			first = newNode;
			last = newNode;
			size++;
		} else {
			newNode.prev = last;
			last.next = newNode;
			last = newNode;
			size++;
		}
		return true;
	}

	@Override
	public E set(int index, Object element) {

		Node current = getNode(index);
		Node newNode = new Node(element);

		if (index == 0) {
			Node child = current.next;
			newNode.next = current.next;
			child.prev = newNode;
			first = newNode;
		} else if (index == (size - 1)) {
			Node parent = current.prev;
			newNode.prev = parent;
			parent.next = newNode;
			last = newNode;
		} else {
			Node parent = current.prev;
			Node child = current.next;
			parent.next = newNode;
			newNode.prev = parent;
			newNode.next = child;
			child.prev = newNode;
		}
		return (E) current.value;
	}

	@Override
	public void add(int index, Object element) {
		Node current = getNode(index);
		Node newNode = new Node(element);

		if (index == 0) {
			newNode.next = current;
			current.prev = newNode;
			first = newNode;
		} else {
			Node parent = current.prev;
			parent.next = newNode;
			newNode.prev = parent;
			newNode.next = current;
			current.prev = newNode;
		}
		size++;
	}

	@Override
	public boolean remove(int index) {

		Node current = getNode(index);

		if (index == 0) {
			Node child = current.next;
			child.prev = null;
			first = child;
		} else if (index == (size - 1)) {
			Node parent = current.prev;
			parent.next = null;
			last = parent;
		} else {
			Node parent = current.prev;
			Node child = current.next;

			parent.next = child;
			child.prev = parent;
			size--;
		}
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	public void getLinkedListDemo() {
		if (size == 0) {
			System.out.println("list is empty");
		} else {
			Node current = first;
			while (current.next != null) {
				System.out.print(current.value + " ");
				current = current.next;
			}
			System.out.print(current.value + " ");
			System.out.println();
		}

	}

	private class Node<E> {
		Object value;
		Node next;
		Node prev;

		Node(Object value) {
			this.value = value;
		}
	}

}

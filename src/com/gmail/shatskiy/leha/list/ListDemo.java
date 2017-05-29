package com.gmail.shatskiy.leha.list;

public interface ListDemo<E> {
	
	E get(int index);

	boolean add(E element);

	E set(int index, E element);

	void add(int index, E element);

	boolean remove(int index);

	int size();

}

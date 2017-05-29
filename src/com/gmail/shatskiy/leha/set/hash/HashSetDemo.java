package com.gmail.shatskiy.leha.set.hash;

import com.gmail.shatskiy.leha.set.SetDemo;

public class HashSetDemo<E> implements SetDemo<E> {

	private static final int DEFAULT_SIZE = 2;
	private static final int DEFAULT_FACTOR = 2;

	private Entity[] massElem = new Entity[DEFAULT_SIZE];

	@Override
	public boolean add(E element) {

		boolean isAdd = false;

		if (conteins(element)) {
			return true;
		} else {
			for (int i = 0; i < massElem.length; i++) {
				if (massElem[i] == null) {
					massElem[i] = new Entity(element);
					return true;
				}
			}
		}
		if (!isAdd) {
			int i = massElem.length;
			massElem = increase();
			massElem[i] = new Entity(element);
		}
		/*
		 * for (int i = 0; i < massElem.length; i++) { if (massElem[i] == null)
		 * { massElem[i] = new Entity(element); isAdd = true; break; } }
		 */
		return true;
	}

	@Override
	public boolean remove(Object element) {
		int h1;
		h1 = element.hashCode();
		int h2;
		for (int i = 0; i < massElem.length; i++) {
			h2 = massElem[i].hash();
			if (h1 == h2) {
				if (element.equals(massElem[i].getValue())) {
					massElem[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean conteins(Object element) {
		int h1;
		h1 = element.hashCode();

		int h2;
		for (Entity ent : massElem) {
			if (ent != null) {
				h2 = ent.hash();
				if (h1 == h2) {
					if (element.equals(ent.getValue())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public int size() {
		int size = 0;
		for (Entity ent : massElem) {
			if (ent != null) {
				size++;
			}
		}
		return size;
	}

	public void getHashSet() {
		System.out.println("-----------------------------");
		for (Entity ent : massElem) {
			if (ent != null) {
				System.out.print(ent.getValue() + " ");
			}
		}
		System.out.println();
		System.out.println("-----------------------------");
	}

	// вырасти массиву
	private Entity[] increase() {
		Entity[] newMass = new Entity[massElem.length * DEFAULT_FACTOR];
		System.arraycopy(massElem, 0, newMass, 0, massElem.length);

		return newMass;
	}

	private class Entity<E> {
		private Object value;
		private int hashCode;

		Entity(Object value) {
			this.value = value;
			hashCode = value.hashCode();
		}

		int hash() {
			return hashCode;
		}

		public Object getValue() {
			return value;
		}
	}

}

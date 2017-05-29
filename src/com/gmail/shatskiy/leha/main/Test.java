package com.gmail.shatskiy.leha.main;

import java.util.LinkedList;

import com.gmail.shatskiy.leha.list.linked.LinkedListDemo;
import com.gmail.shatskiy.leha.set.hash.HashSetDemo;
import com.gmail.shatskiy.leha.set.tree.TreeSetDemo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		/*
		HashSetDemo<String> set = new HashSetDemo<String>();
		set.add("asdf");

		System.out.println(set.size());
		
		set.add("asdf1");
		set.add("asdf1");
		System.out.println(set.conteins("asdf1"));
		System.out.println(set.conteins("sdfsd"));
		System.out.println(set.size());
		set.remove("asdf");
		System.out.println(set.size());
		set.print();
		System.out.println("-----------------------------");
		set.add("asdf1");
		set.add("asdf1");
		set.add("asdf2");
		set.add("asdf3");
		set.add("asdf4");
		set.add("asdf5");
		set.add("asdf6");
		set.add("asdf7");
		set.print();
		*/
		/*
		TreeSetDemo<String> tree = new TreeSetDemo<String>();
		tree.add("15");
		tree.add("10");
		tree.add("20");
		tree.add("7");
		tree.add("11");
		tree.add("14");
		tree.add("22");
		tree.getTreeSet();
	
		System.out.println(tree.remove("20"));
		System.out.println(tree.size());
		tree.getTreeSet();
		*/
		/*
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(1);
		list.add(4);
		int i = list.set(3, 5);
		System.out.println(i);
		//list.get
		 */
		 
		LinkedListDemo<String> list = new LinkedListDemo<String>();
		list.getLinkedListDemo();
		list.add("a");
		list.add("a");
		list.add("b");
		list.getLinkedListDemo();
		list.set(2, "b");
		list.getLinkedListDemo();
		list.add(2, "c");
		list.getLinkedListDemo();
		list.remove(3);
		list.getLinkedListDemo();
		System.out.println(list.get(2));
		

	}

}

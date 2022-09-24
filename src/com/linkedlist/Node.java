package com.linkedlist;

public class Node <Type extends Comparable<Type>> {
	public Type item;
	public Node<Type> next;
	
	Node(Type item) {
		super();
		this.item = item;
	}
	
	public String toString() {
		return "{ item => "+item+", next => "+next+" }";
	}
}

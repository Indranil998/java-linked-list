package com.linkedlist;

public class LinkedList <Type extends Comparable<Type>> {
	Node<Type> head; // point to first node of the linked list
	Node<Type> tail; // point to last node of the linked list
	
	/*
	 * creates empty linked list
	 */
	LinkedList(){
		head = null;
		tail = null;
	}
	
	/**
	 * add item to linked list at start of linked list
	 * @param item
	 */
	public void add(Type item) {
		// check linked list is empty if it is empty then head and tail both will point to new node
		if (isEmpty()) head = tail = new Node<Type>(item);
		else {
			// linked list is not empty
			// create new node
			Node<Type> tempNode = new Node<Type>(item);
			// add new node before first node head node is the first node
			tempNode.next = head;
			// head will point to new node because new node is the first node now
			head = tempNode;
		}
	}

	/**
	 * remove item from linked list after searching that item
	 * @param item
	 */
	public void remove(Type item) {
		// if item found in head node then head have to move to next node
		if(head.item.equals(item)) {
			// check linked list has only one element 
			if(head == tail) head = tail = null; // making linked list empty
			else head = head.next; // heads next node will be head node 
			return;
		}
		// item not found in head
		Node<Type> currentNode = head; // take current node for traverse
		while(currentNode.next != null) {
			// check item found in current nodes next node
			if(currentNode.next.item.equals(item)) {
				// check item found in tail node
				if(currentNode.next == tail) tail = currentNode; // current node will be tail node
				currentNode.next = currentNode.next.next;
				return;
			}
			currentNode = currentNode.next;
		}
	}
	
	/**
	 * search item in present in linked list or not 
	 * @param item
	 * @return true if item found in linked list otherwise false
	 */
	public boolean search(Type item) {
		// check item real index can be found or not -1 can not be any items index so if index got -1 then item not found 
		if(index(item) == -1) return false;
		else return true;
	}
	
	/**
	 * check linked list is empty or not
	 * @return true if linked list is empty otherwise false
	 */
	public boolean isEmpty() {
		// linked is empty then head will be null so when head is null then return linked list is empty
		if(head == null) return true;
		// otherwise return false
		else return false;
	}

	/**
	 * 
	 * @return number of elements in linked list
	 */
	public int size() {
		int count = 0;
		Node<Type> currentNode = head;
		// will traverse over linked list
		while(currentNode != null) {
			count++; // count nodes in linked list
			currentNode = currentNode.next;
		}
		return count;
	}
	
	/**
	 * add item to linked list at end side of linked list (i.e. tail)
	 * @param item
	 */
	public void append(Type item) {
		Node<Type> newNode = new Node<Type>(item);
		if (isEmpty()) head = tail = newNode;
		else {
			// add new node at next to tail node
			tail.next = newNode;
			// tail will always point to last node so new node will be tail node
			tail = newNode;
		}
	}
	
	/**
	 * item is present in which index 
	 * @param item
	 * @return index position of item if found otherwise -1
	 */
	public int index(Type item) {
		Node<Type> currentNode = head;
		int i = 0; // point to index
		// will traverse over linked list
		while(currentNode != null) {
			// item found in current node then return index position 
			if(currentNode.item.equals(item)) return i;
			// if not then current node will move to next node and index position will increment by 1
			currentNode = currentNode.next;
			i++;
		}
		// linked list traversing is finish and item not found in linked list
		return -1; // -1 is not any of index in linked list 
	}
	
	/**
	 * add item to specified index position
	 * @param position
	 * @param item
	 */
	public void insert(int position, Type item) {
		Node<Type> newNode = new Node<Type>(item); // node created with item
		// have to add at 0th index so its have to add starting of linked list
		if(position == 0) add(item);  // add method is adding item to starting of linked list
		// have to add to last of the inked list 
		else if(size() <= position) append(item); // append method is adding item to ending of linked list
		// linked list is empty then head and tail both will point to new node
		else if (isEmpty()) head = tail = newNode; 
		else {
			// not have to add starting or ending of linked list
			// have to add somewhere in middle of linked list according to given position
			Node<Type> currentNode = head;
			// have traverse on linked list up to just one node before of position where have to add item
			// so we can add new node next to current node
			for (int i = 0; i < (position - 1); i++) currentNode = currentNode.next;
			// current nodes next node will be new nodes next node
			newNode.next = currentNode.next;
			// current nodes next node will be new node
			currentNode.next = newNode;
		}
	}
	
	/**
	 * remove first element of linked list and return its value
	 * @return head.item
	 */
	public Type pop() {
		// store tail nodes item for return purpose
		Type currentHeadItem = headItem();
		if (currentHeadItem != null) {
			// head node is not null remove head node from linked list
			remove(headItem());
			// return stored head nodes item
			return currentHeadItem;
		} else return null; // head nodes item is null
	}
	
	/**
	 * remove last element of linked list and return its value
	 * @return tail.item
	 */
	public Type popLast() {
		if(isEmpty()) return null; // linked list is empty not have to return in linked list
		else if(size() == 1) {
			// only one node in linked list head and tail both are pointing to that one element
			// store that one nodes item for return purpose 
			Type tempItem = head.item;
			// make linked list empty by returning that one nodes item
			head = tail = null;
			return tempItem;
		} else {
			// have more than one element in linked list
			// store tail nodes item for return purpose
			Type tempItem = tail.item;
			Node<Type> currentNode = head;
			// traverse up to one node before of tail node
			while(currentNode.next != tail) currentNode = currentNode.next;
			// current node will be tail node
			tail = currentNode;
			// tail nodes next will always be null because tail is the last node of linked list
			tail.next = null;
			return tempItem;
		}
	}
	
	/*
	 * return head item when linked list is not empty otherwise return null
	 */
	public Type headItem() {
		if(isEmpty()) return null; // linked list is empty not have to return in linked list
		else return head.item; // return item value where head is pointing
	}
	
	public String toString() {
		if(head != null) return head.toString();
		else return null;
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to linked list program");
		SortedLinkedList sortedLinkedList = new SortedLinkedList<Integer>(SortedLinkedList.ASCENDING);
		sortedLinkedList.add(56);
		sortedLinkedList.add(30);
		sortedLinkedList.add(40);
		sortedLinkedList.add(70);
		System.out.println(sortedLinkedList);
	}

}

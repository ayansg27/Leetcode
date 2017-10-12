package com.primary;

import java.util.Scanner;

class Node {
	String data;
	Node next;
	
	Node(String data) {
		this.data = data;
		this.next = null;
	}
}

public class CircularQueue {
	private static final int maxSize = 12;
	private int currentPosition;		// stores the current position of insertion
	private boolean isFull;				// flag to check if max size has been reached 
	private Node head;					// start of the queue
	
	CircularQueue() {
		currentPosition = 0;
		isFull = false;
		head = null;
	}
	
	public void enqueue(String data) {
		// creating new Node for the given String
		Node newNode = new Node(data);
		
		// if queue is empty, newNode is the head
		if (head == null) {
			head = newNode;
			newNode.next = head;
		}
		
		// else if queue is not full yet, we can just append (ensure circular)
		else if (!isFull) {
			// iterate the queue and add to the end
			Node current = head;
			// check if current.next doesn't point to head 
			while (current.next != head)  {  
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;
		}
		
		// else if it is full, overwrite from the beginning
		else {
			int index = 0;
			Node prev = null, next = head;
			while (index < currentPosition) {
				// traverse till current position is reached
				prev = next;
				next = next.next;
				index++;
			}
			// in case 0th element needs to be overwritten
			if (index == 0) {
				// prev is last node
				Node curr = head;
				while (curr.next != head) {
					curr= curr.next;
				}
				prev = curr;
				// new head is the newNode
				head = newNode;
			}
			//System.out.println("prev = " + prev.data + " and current = " + current.data);
			prev.next = newNode;
			newNode.next = next.next;
		}
		
		// updating currentPosition and resetting to zero if it reaches maxSize
		currentPosition++;
		if (currentPosition == maxSize) {
			isFull = true;
			currentPosition = 0;
			System.out.println("FULL! Overwriting to head of queue!");
		}
	}
	
	public void dequeue() {
		
		Node current = head;
		if(head!=null) {
			while (current.next != head) {
				System.out.println(current.data);
				current = current.next;
			}
			// for last Node
			System.out.println(current.data);
			head = null;		// deallocating queue
		}
		else {
			System.out.println("Empty Queue!");
		}
	}
	//main method
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue();
		Scanner in = new Scanner(System.in);
		System.out.println("--------------------CIRCULAR QUEUE--------------------\n");
		System.out.println("Start entering data to add to queue");
		while (true) {
			System.out.print("Enter data to be enqueued (Q/q to quit): ");
			String input = in.next();
			if (input.toUpperCase().equals("Q")) {
				// dequeue
				queue.dequeue();
				// exit infinite loop
				break;
			}
			else {
				queue.enqueue(input);
			}
		}
		in.close();
	}

}
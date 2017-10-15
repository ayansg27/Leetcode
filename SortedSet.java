package com.primary;

import java.io.*;
import java.util.Scanner;

public class SortedSet {
	// class for Node data structure
	private class Node {
		int key;
		Node left, right;
		
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
	
	// Root for the binary search tree
	private Node root;
	
	// constructor
	SortedSet() {
		root = null;
	} 
	
	
	// method to check empty set
	boolean isEmpty() {
		if (root == null) {
			return false;
		}
		else {
			return true;
		}
	}
	// method to insert value from the BST
	void add(int value) {
		Node newNode = new Node(value);
		// for empty tree
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node current = root, prev = null;
		while (current != null) {
			if (value < current.key) {
				break;
			}
			prev = current;
			current = current.right;
		}
		
		// if value to be inserted is before root, make it the new root
		if (current == root) {
			newNode.right = root;
			root = newNode;
		}
		
		// else if end of BST is reached, add value as right child of last node
		else if (current == null) {
			prev.right = newNode;
		}
		
		// else, if value is to be added in the middle
		else {
			prev.right = newNode;
			newNode.right = current;
		}
		
	}
	
	// method to remove value from the BST
	void remove(int value) {
		Node current = root, prev = null;
		boolean found = false;
		while(current != null) {
			if (current.key == value) {
				found = true;
				break;
			}
			prev = current;
			current = current.right;
		}
		// if value does not exist in the BST
		if (!found) {
			System.out.println(value + " does not exist in the Sorted Set.");
			return;
		}
		// if root needs to be removed
		if (current == root) {
			root = current.right;
		}
		// else if a value other than root needs to be removed
		else {
			prev.right = current.right;
		}
	}
	
	// method to check if value exists in the BST
	boolean contains(int value) {
		boolean found = false;
		Node current = root;
		while(current != null) {
			if (current.key == value) {
				found = true;
				break;
			}
			current = current.right;
		}
		return found;
	}
	
	
	// print the BST
	void print() {
		System.out.print("Sorted Set Contains ");
		Node current = root;
		while(current.right != null) {
			System.out.print(current.key + ", ");
			current = current.right;
		}
		System.out.println(current.key);
		return;
	}
	
	
	public static void main(String[] args) {
		SortedSet ss = new SortedSet();
		File inFile = new File("infile.dat");
		//initialize scanner
		Scanner input=new Scanner(System.in);
		try {
			Scanner scnr = new Scanner(inFile);
			String line = scnr.nextLine();
			
			String[] items=line.split(",");
			for(int i=0;i<items.length;i++) {
				String s=items[i].replaceAll("\\s+","");
				int v=Integer.parseInt(s);
				ss.add(v);
			}
			ss.print();
			while(true) {
				//Input file name from user
				System.out.println("Enter the number you want to search: ");  
				String entry=input.next();
				if(entry.matches("^-?\\d+$")) {
					if(ss.contains(Integer.parseInt(entry))) System.out.print("Yes");
					else System.out.print("No");
					break;
				}
				else {
					System.out.println("Invalid entry! Please enter again.");
				}
			}
			//closing scanner
			scnr.close();
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
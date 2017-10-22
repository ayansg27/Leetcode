package com.primary;

import java.util.Scanner;

public class MaxHeapArrayChecker {

	public static void main(String[] args) {

		//initialize scanner
		Scanner input=new Scanner(System.in);
		//initialize max heap class
		MaxHeap mh = new MaxHeap(100);
		//take input from user
		System.out.println("Enter the values: ");
		for(int i=1;i<=10;i++) {
			int entry=input.nextInt();
			mh.insert(entry);
		}
		//
		mh.enforceMaxHeap();
		//pop all items from the heap and print
		System.out.println("Removing items from the list in descending order: ");
		for(int i=1;i<=10;i++) {
			int popped=mh.remove();
			System.out.println(popped);
		}
		//closing scanner
		input.close();
	}

}

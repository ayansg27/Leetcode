package com.primary;

import java.util.*;

public class SortedDictionary {
	
	//declaring variable
	private TreeMap<String,String> dictionary;
	//constructor
	public SortedDictionary() {
		dictionary = new TreeMap<String,String>();
	}
	//method to insert key value pair
	public void insert(String key, String val) {
		try {
			dictionary.put(key,val);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	//method to insert key value pair
	public void remove(String key) {
		try {
			dictionary.remove(key);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	//method to insert key value pair
	public String get(String key) {
		if(dictionary.containsKey(key)){
			return dictionary.get(key);
		}
		return null;
	}
	//method to insert key value pair
	public void exists(String key) {
		if(dictionary.containsKey(key))
			System.out.print("Item exists!");
		else
			System.out.print("Item does not exist!");
	}
	//method to insert key value pair
	public void print() {
		System.out.println("-----------------------");
		System.out.format("%-12s","Key");
		System.out.print("|  ");
		System.out.format("%-10s","Value");
		System.out.println();
		System.out.println("-----------------------");
		for(String s:dictionary.keySet()) {
			//System.out.println(s+"\t\t"+dictionary.get(s));
			System.out.format("%-15s",s);
			System.out.format("%-15s",dictionary.get(s));
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	//display user menu
	public void display() {
		System.out.println("-----------------------");
		System.out.println("Menu");
		System.out.println("-----------------------");
		System.out.println("1. [I]nsert");
		System.out.println("2. [E]xists");
		System.out.println("3. [D]elete");
		System.out.println("4. [S]earch");
		System.out.println("5. [P]rint");
		System.out.println("6. [Q]uit");
		System.out.println("-----------------------");
	}
	public static void main(String[] args) {
		
		//initialize scanner
		Scanner input=new Scanner(System.in);
				
		SortedDictionary sd=new SortedDictionary();
		//inserting values into dictionary
		sd.insert("hello","world");
		sd.insert("goodbye","everyone");
		sd.insert("name","student");
		sd.insert("occupation","student");
		sd.insert("year","2016");
		sd.insert("gpa","4.0");
		sd.insert("lab","yes");
		sd.insert("assignment","no");
		sd.insert("department","cs");
		//print dictionary
		sd.print();
		String key1="gpa";
		String key2="department";
		System.out.format("%-15s", key1);
		System.out.format("%-15s", sd.dictionary.get(key1));
		System.out.println();
		System.out.format("%-15s", key2);
		System.out.format("%-15s", sd.dictionary.get(key2));
		System.out.println();
		sd.display();
		while(true) {
			System.out.print("Enter your choice: ");
			String choice=input.next();
			
			if(choice.equals("i")||choice.equals("I")) {
				System.out.print("Enter key: ");
				String key=input.next();
				System.out.print("Enter value: ");
				String val=input.next();
				sd.insert(key, val);
			}
			else if(choice.equals("e")||choice.equals("E")) {
				System.out.print("Enter key: ");
				String key=input.next();
				sd.exists(key);
			}
			else if(choice.equals("d")||choice.equals("D")) {
				System.out.print("Enter key: ");
				String key=input.next();
				sd.remove(key);
			}
			else if(choice.equals("s")||choice.equals("S")) {
				System.out.print("Enter key: ");
				String key=input.next();
				System.out.println("Value:"+sd.get(key));
			}
			else if(choice.equals("p")||choice.equals("P")) {
				sd.print();
			}
			else if(choice.equals("q")||choice.equals("Q")) {
				System.out.print("Thank You!");
				break;
			}
			else {
				System.out.println("Invalid Entry!");
			}
			
		}
		
	}

}

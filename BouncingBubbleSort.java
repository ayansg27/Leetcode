package com.primary;

public class BouncingBubbleSort {

	//bubble sort 
	public void bubbleSort(int arr[]) {
		int front=0,back=arr.length-1;
		for(int i=0;i<arr.length-1;i++) {
			if(i%2==0) {
				for(int j=front;j<back;j++){
					if(arr[j]>arr[j+1]) {
						int k=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=k;
					}
				}
				back--;
			}
			else {
				for(int j=back;j>front;j--){
					if(arr[j]<arr[j-1]) {
						int k=arr[j];
						arr[j]=arr[j-1];
						arr[j-1]=k;
					}
				}
				front++;
			}
		}
	}
	//print array
	public void print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	//main method
	public static void main(String[] args) {

		BouncingBubbleSort obj = new BouncingBubbleSort();
		int arr[] = {64, 34, 25, 12, 22, 11, 90, 1, 102, 37, 89, 46, 2};
		obj.bubbleSort(arr);
        System.out.println("Sorted array");
        obj.print(arr);
	}

}

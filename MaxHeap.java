package com.primary;

public class MaxHeap {
	
	private int[] heapArray;
	private int heapSize;
	private int heapMaxSize;
	
	private static final int FRONT=1;

	//constructor
	public MaxHeap(int maxSize) {
		this.heapMaxSize=maxSize;
		this.heapSize=0;
		heapArray=new int[this.heapMaxSize+1];
		heapArray[0]=Integer.MAX_VALUE;
	}
	//method to return parent of a given position
	private int parent(int position) {
		return (position/2);
	}
	//method to return left child
	private int leftChild(int position) {
		return (position*2);
	}
	//method to return right child
	private int rightChild(int position) {
		return (position*2)+1;
	}
	//method to check whether a node is aleaf
	private boolean isLeaf(int position){
        if (position>=(heapSize/2)&&position<=heapSize)
        {
            return true;
        }
        return false;
    }
	//method to swap items in array
	private void swap(int first,int second){
        int temp = heapArray[first];
        heapArray[first] = heapArray[second];
        heapArray[second] = temp;
    }
	//method to enforce maxheap
	private void maxHeapify(int position){
        if (!isLeaf(position))
        { 
            if(heapArray[position]<heapArray[leftChild(position)]||heapArray[position]<heapArray[rightChild(position)]){
                if(heapArray[leftChild(position)]>heapArray[rightChild(position)]){
                    swap(position, leftChild(position));
                    maxHeapify(leftChild(position));
                }
                else{
                    swap(position,rightChild(position));
                    maxHeapify(rightChild(position));
                }
            }
        }
    }
	//method to insert item into the array
	public void insert(int num){
        heapArray[++heapSize] = num;
        int current = heapSize;
 
        while(heapArray[current]>heapArray[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }	
    }
	//method to call heapify action
    public void enforceMaxHeap(){
        for (int position=(heapSize/2);position>=1;position--){
            maxHeapify(position);
        }
    }
    //method to remove elements
    public int remove(){
        int popped = heapArray[FRONT];
        heapArray[FRONT] = heapArray[heapSize--]; 
        maxHeapify(FRONT);
        return popped;
    }

}

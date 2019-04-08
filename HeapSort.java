/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

import static java.lang.Math.floor;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mustafa
 */
public class HeapSort {
    
    
    public int size; //keep track of heap size
   
    
 /**
 *
 * returns the max of the heap
 */
    public int heapMax(int[] A) {
        return A[0]; //Root is max
    }
    
 /**
 *
 * Returns parent node
 */
    public int parent(int i)
    {
        return (int) floor (i/2); //node / 2 is parent
    }
    
    
    public int leftChild(int i)
    {
        return (2*i)+1; //node * 2 + 1 = left so if i = 0 stll gives child
    }
    
    public int rightChild(int i)
    {
        return (2*i)+2; //node * 2 + 2 = right child
    }
    
    
/**
 *
 * Removes root and returns the root which is max
 */
    public void extractMax(Proccess A[]) {
        
        if (size < 0) {
           System.out.println("Heap Underflow"); //check to see if heapsize is too small
           //return 0;
        }
        
        int max = A[0].getpQ(); // max set to root
        A[0] = A[size - 1]; //child is now root
        //A.remove(A[size-1]); // remove element
        size--; //decrease heap size
        maxHeapify(A,0); //max heapify again to keep  organized
        //return max; //return the root removed
    }
    


    
    public void heapSort(Proccess A[]) {
		buildMaxHeap(A); //build a largestheap
		for (int i = A.length - 1; i >= 1; i--) {
			Proccess temp = A[0]; //exchange root to each element
			A[0] = A[i];
			A[i] = temp;
                        size--; // reduce heap size
			maxHeapify(A, 0);
                        //System.out.println(size)
                        
		}
               
	}
    
    public void buildMaxHeap(Proccess  A[]) {
            size = A.length; //set heap size
            double fl = floor(A.length/2);
		for (int i = (int) fl - 1 ; i >= 0; i--){
			maxHeapify(A,i);// run from leaves up
                        
                }
                
	}
   
	public void maxHeapify(Proccess  A[], int i) {
           
               int l,r,max;
               l = leftChild(i); // set l to left child
               r = rightChild(i); // set r to right child of i
               max = i; // set the max to i
    
                if (l < size && A[l].getpQ() > A[max].getpQ()){ //check if left child bigger than max
		     max = l; // if true make max now l
                }   
                else {
                     max = i; //else keep max = i 
                }
		if (r < size && A[r].getpQ() > A[max].getpQ()) {//check if right child bigger than index
		    
                    max = r; //if right child gretaer set max to r   
                }
                
                

		if (max != i) { // max not index then run
                        Proccess temp = A[i]; // temp holds digit in i of array A
			A[i] = A[max]; //set slot i of A to whatever slot holds max its digit
			A[max] = temp; // set where max was to now temp which held 
			
			maxHeapify(A, max);// recursive till i is max
		}
                
	}
        
 /**
 *
 * 
 */

    public void maxHeapInsert(Proccess [] A, int key) {
        size = size + 1;
        A[size].setpQ("PInf"); 
        heapIncreaseKey(A,size,key);
    }
    
     
    public void heapIncreaseKey(Proccess [] A, int i, int key) {
         if (key < A[i].getpQ()){
             System.out.println("ERROR new key smaller than current");  
         }
         A[i].setpQm(key);
         while (i > 0 && A[parent(i)].getpQ() < A[i].getpQ()) {
                        Proccess  temp = A[0];
			A[0] = A[parent(i)];
			A[parent(i)] = temp;
             i = parent(i);
         }
     }

	public void buildMaxHeap1(int A[]) {
            size = 0; //set heap size
		for (int i = 1; i >= A.length-1; i++){
			//maxHeapify(A,i);// run from leaves up
                       // maxHeapInsert(A,A[i]);
                }
                
	}
}

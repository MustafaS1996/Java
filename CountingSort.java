/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counting.sort;

import java.util.Arrays;

/**
 *
 * @author Mustafa
 */
public class CountingSort {

    
    
    public static void main(String[] args) {

        
        
        int A[] = {5,5,0,6,2,0,1,3,2,6,1,4,2,4};
        int B[] = new int[A.length]; //-changed to -1 so b = 13
        System.out.println(Arrays.toString(A));
        countingSort(A,B,7);
    }
    
    
    public static void countingSort(int A[],int B[],int k) {
        
    int C[] = new int[k]; 
    
    
        for (int i = 0; i < k; i++) {
            //System.out.println(Arrays.toString(C));
            C[i] = 0;
            
        }
    System.out.println("C initialized: ");   
    System.out.println(Arrays.toString(C)); // initialized to zero
        
        for (int j = 0 ; j <= A.length-1; j++) { //j initialized at 0 so A[j] = A[0] is also counted
            System.out.print("A[j] where j = ");
            System.out.println(j); //j has to be <= 13 last element of A
            System.out.println(Arrays.toString(C));
            C[A[j]] = C[A[j]] + 1; //keeps adding one to index of C of A[j]
            //System.out.println(Arrays.toString(C));
            
            //Bug* doesnt count the last element **Fixed
        }
        System.out.print("A.length = "); 
        System.out.println(A.length); //length 14
        //System.out.println(A[A.length-1]); // last element 13
       //C[A[A.length-1]] = C[A[A.length-1]] + 1;
    System.out.println("C each i: ");   
    System.out.println(Arrays.toString(C)); //C cointains num elements equal to i
    
        for (int i = 1; i <= k-1; i++) {
            C[i]= C[i]+C[i-1];
            System.out.println(Arrays.toString(C));
        }
    System.out.println("C totals: ");
    System.out.println(Arrays.toString(C)); //C total less than i
    
        for (int j = A.length-1; j >= 0; j--) { // j must be >= 0 so it also counts the first element of A **Fixed Bug
             B[C[A[j]]-1] = A[j]; //B is indexed at 1 so must -1  **Bug Fix 
             C[A[j]] = C[A[j]] - 1;
             System.out.print("B: ");
             System.out.println(Arrays.toString(B));
             System.out.print("C: ");
             System.out.println(Arrays.toString(C));
        }
    }
 
   
    
}


//taking 10 percent 10 times starting from 100

//        double x = 100;
//        for (int i = 0; i < 10; i++) {
//           x =  x-x*.1;
//           System.out.println(x);
//        }
//        
        
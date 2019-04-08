/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuedoinsertionsort;

/**
 *
 * @author Mustafa
 */
public class PsuedoInsertionSort {

   
    public static void main(String[] args) {
        int[] arr1 = {18, 25, 6, 9, 15, 12, 5, 20, 11, 30};
        doInsertionSort(arr1);
       
    }
    
   public static int[] doInsertionSort(int[] arr){
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j]; //key is 2nd Component
            int i = j-1; //i set to 1st Component
            while ( (i > -1) && ( arr [i] > key ) ) {
                arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = key;
            
            for (int ii = 0; ii < arr.length; ii++) {
            System.out.print(arr[ii] + ", ");
            }
            System.out.println("\n");
        }
        return null;
   }
    
}

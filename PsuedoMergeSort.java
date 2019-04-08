/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuedomergesort;

/**
 *
 * @author Mustafa
 */
public class PsuedoMergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int[] A = {18, 25, 6, 9, 15, 12, 5, 20, 11, 30};
   
    mergeSort(A, 0, A.length - 1);
    
    for (int i = 0; i < A.length; i++) {
        System.out.print(" " + A[i]);
    }    
     }
    public void mergeSort(int[] arrNums, int p, int r) {
    if (p < r) {
        int q = (p + r) / 2;
        mergeSort(arrNums, p, q);
        mergeSort(arrNums, q + 1, r);
        merge(arrNums, p, q, r);
    }
}

public void merge(int[] arrNums, int p, int q, int r) {
    int nOne = q - p + 1;
    int nTwo = r - q;

    int[] arrLeft = new int[nOne + 1];
    int[] arrRight = new int[nTwo + 1];

    for (int i = 0; i < nOne; i++) {
        arrLeft[i] = arrNums[p + i - 1];
    }

    for (int j = 0; j < nTwo; j++) {
        arrRight[j] = arrNums[q + j];
    }

    arrLeft[nOne] = Integer.MAX_VALUE;
    arrRight[nTwo] = Integer.MAX_VALUE;

    // Tracks arrLeft index
    int i = 0;

    // Tracks arrRight index
    int j = 0;

    for (int k = p; k < r; k++) {
        if (arrLeft[i] <= arrRight[j]) {
            arrNums[k] = arrLeft[i];
            i++;
        } else {
            arrNums[k] = arrRight[j];
            j++;
        }
    }
}
    
    
    
    
    /*
    public void mergeSort(int[] A, int p, int r) {
    if (p < r) {
        int q = (p + r) / 2;
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);
        merge(A, p, q, r);
    }
}

public void merge(int[] A, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    int[] L = new int[n1 + 1];
    int[] R = new int[n2 + 1];

    for (int i = 1; i <= n1; i++) {
        L[i] = A[p + i - 1];
    }

    for (int j = 1; j <= n2; j++) {
        R[j] = A[q + j];
    }

    L[n1+1] = Integer.MAX_VALUE;
    R[n2+1] = Integer.MAX_VALUE;
    int i = 1;
    int j = 1;

    for (int k = p; k <= r; k++) {
        if (L[i] <= R[j]) {
            A[k] = L[i];
            i++;
        } else {
            A[k] = R[j];
            j++;
        }
    }
}
    */
}

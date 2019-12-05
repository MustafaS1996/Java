import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Author: Syed Mustafa Sarwar
 *
 */
public class BitSet implements IntSet {
   /**
    * Setter for IntSet
    */
   public BitSet() {
      this.elements = new int[10];
      this.elementCount = 0;
      this.started = true;
      this.setted = false;
      this.test = false;
      elM = new ArrayList<Integer>();
   }

   /**
    *
    * @param n recieves an int
    * @return boolean return if present
    */

   public boolean test(int n) {
      int z = ((n - start) / 32);
      int i = ((n - start) % 32);
      if (0 <= i && i < 32) {
         if (test(elements[z], i)) {
            test = true;
         }else {
            test = false;
         }
      }else {
         test = false;
      }
      return test;
   }

   /**
    *
    * @param n set the recieved int to array
    */

   public void set(int n) {
      setted = false;
      if (started == true) {
         this.start = n;
         elM.add(n);
         //z is an index of the elements array starting from 0-9
         //i is the bit in z to be turned on
         int z = (n - start) / 32;
         int i = (n - start) % 32;
         int temp = elements[z];
         elements[z] = set(temp, i);
         this.elementCount++;
         smallest = start;
         largest = start;
         System.out.println("started " + n + " in length " + elements.length + " index: " + z);
         System.out.println(Arrays.toString(elements));
         this.started = false;
      }else {
         while (setted == false) {
            if (n >= start && n < start + (elements.length * 32)) {
               elM.add(n);
               int z = ((n - start) / 32); // 132 - 100 / 32 = 32 /32 = 1 ... 200 - 100 / 32 = 3
               int i = ((n - start) % 32);
               int temp = elements[z];
               elements[z] = set(temp, i);
               this.elementCount++;
               if (n < smallest) {
                  smallest = n;
               } else {largest = n;}
               System.out.println("fits " + n + " in length " + elements.length +  " index: " + z );
               System.out.println(Arrays.toString(elements));
               setted = true;
            } else if (n < start) {
               elements = Arrays.copyOf(elements, elements.length * 2);
               System.out.println("expanding... less than " + start + " new length " + elements.length);
               this.start = n;
               System.out.println("new start " + start);
            } else {
               elements = Arrays.copyOf(elements, elements.length * 2);
               System.out.println("expanding... greater than " + start + " new length " + elements.length);
            }
         }
      }


   }

   /**
    *
    * @param n removes the recieved int from array
    */

   public void clear(int n) {

         int z = ((n - start) / 32);
         int i = ((n - start) % 32);

         if (test(elements[z],i)) {
            for (int j = 0; j < elM.size(); j++) {
               if (elM.get(j) == n){
                  elM.remove(j);
               }
            }
            z = ((n - start) / 32);
            i = ((n - start) % 32);
            int temp = elements[z];
            elements[z] = clear(temp, i);

            this.elementCount--;
            System.out.println("Delete " + n + " in length " + elements.length + " index: " + z);
            System.out.println(Arrays.toString(elements));
         }
         else {
            System.out.println("Not Found " + n + " in length " + elements.length + " index: " + z);
            System.out.println(Arrays.toString(elements));
         }

   }

   /**
    *
    * @return the min in the set of collection of elements
    */

   public int min() {

      int smallests = Collections.min(elM);
      return smallests;
   }

   /**
    *
    * @return max in the set of elements
    */

   public int max() {

      int largests = Collections.max(elM);
      return largests;
   }

   // Don't change any of these (but add javadoc)

   /**
    *
    * @return amount of elements in the array elements
    */
   public int size() {
      return elementCount;
   }

   /**
    *
    * @param n takes an int
    * @param i index of bit to be changed
    * @return boolean if index i is on
    */

   private static boolean test(int n, int i) {
      assert 0 <= i && i < 32;
      return (n & (1 << i)) != 0;
   }

   /**
    *
    * @param n int passed
    * @param i index of bit in int n to be set
    * @return new int returned after added
    */

   private static int set(int n, int i) {
      assert 0 <= i && i < 32;
      return n | (1 << i);
   }

   /**
    *
    * @param n int passed in
    * @param i index of bit in int n to be cleared
    * @return new int after clearing
    */

   private static int clear(int n, int i) {
      assert 0 <= i && i < 32;
      return n & ~(1 << i);
   }

   // These are left package visible so they can be accessed in a unit test

   boolean started;
   boolean setted;
   boolean test;
   int[] elements;
   ArrayList<Integer> elM;
   int largest = Integer.MIN_VALUE;
   int smallest = Integer.MAX_VALUE;
   int start;
   int elementCount;
}
import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Syed Mustafa Sarwar
 */
public class ArraySet implements IntSet
{
   /**
    * Setter for new ArraySets
    */
   public ArraySet() {
      this.elementCount = 0;
      this.elements = new int[10];


   }

   /**
    *
    * @param n integer to be tested in array
    * @return boolean test
    */

   public boolean test(int n)
   {

      this.test = false;
      for (int i = 0; i < elementCount; i++){
         if (elements[i] == n) {
            this.test = true;
            this.zerIndex = i;
            System.out.println("found: " + n + " " + test + " in index " + zerIndex);
            this.largest = max();
            this.smallest = min();
         }
      }
      return test;

   }

   /**
    *
    * @param n an integer to be removed from array if found
    */

   public void clear(int n) 
   {
      if (test(n)) {
         System.out.println("clearing: " + n + " at " + zerIndex);
         temp = elements[elementCount-1];
         System.out.println("inserting: " + elements[elementCount-1]);
         elements[zerIndex] = temp;
         elements[elementCount-1] = 0;
         elementCount--;
         this.largest = max();
         this.smallest = min();
      }
      else {
         System.out.println("ERROR: " + n +  " not an element in array");
      }
      System.out.println(Arrays.toString(elements));


   }

   /**
    *
    * @param n int set into elements array
    */

   public void set(int n)
   {
      if (elementCount >= elements.length ) {
         System.out.println(elementCount + " expanding... "  );
         elements = Arrays.copyOf(elements,elements.length*2);
         elementCount++;
         System.out.println(elementCount + " setting: " + n );
         elements[elementCount-1] = n;
         this.largest = max();
         this.smallest = min();

      }
      else {

         elementCount++;
         System.out.println(elementCount + " setting: " + n );
         elements[elementCount-1] = n;
         this.largest = max();
         this.smallest = min();

      }
      int temps = elementCount - 1;
      System.out.println("setted: " + n + " at index: " + temps);
      System.out.println(Arrays.toString(elements));
   }

   /**
    *
    * @param arr array passed to be extended
    * @return an array
    * UNUSED for now
    */

   public static int[] extend(int[] arr) {
      int[] elementsExtender = new int[arr.length * 2];
      System.arraycopy(arr,0,elementsExtender,elementsExtender.length-1,arr.length);
      return elementsExtender;
   }

   // Don't change any of these (but add javadoc)

   /**
    *
    * @return smallest number
    */

   public int min()
   {
      this.smallest = Integer.MAX_VALUE;
      for (int i = 0; i < elementCount; i++) {
         if (elements[i] < smallest) {
            this.smallest = elements[i];
         }
      }

      return smallest;
   }

   /**
    *
    * @return largest number
    */
   public int max()
   {
      this.largest = Integer.MIN_VALUE;


      for(int i = 0; i < elementCount; i++) {
         if (elements[i] > largest) {
            this.largest = elements[i];
         }
      }
      return largest;
   }

   /**
    *
    * @return the amount of elements
    */
   public int size()
   {
      return elementCount;
   }

   /**
    * Declared Objects left visible to unit test
    */
   // These are left package visible so they can be accessed in a unit test

   int largest = Integer.MIN_VALUE;
   int smallest = Integer.MAX_VALUE;
   int[] elements;
   int zerIndex;
   int elementCount;
   boolean test;
   int temp;

}

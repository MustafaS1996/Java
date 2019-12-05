import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArraySet implements IntSet
{
    /**
     *  ArraySetIterator
     *  work through the iterator design
     */

    private class ArraySetIterator implements Iterator<Integer>
    {
        private int modCountl = modCountg;
        private boolean afterNext = false;
        private int nextIndex;

        /**
         *
         * @return boolean if next available
         */

        @Override
        public boolean hasNext() {
            if (modCountl != modCountg) {
                throw new ConcurrentModificationException();
            }
            return nextIndex < elementCount;}

        /**
         *
         * @return the next integer
         */

        @Override
        public Integer next() {
            if (modCountl != modCountg) {
                throw new ConcurrentModificationException();
            }
            if (this.hasNext()) {
                Integer result = ArraySet.this.elements[nextIndex];
                nextIndex++;
                afterNext = true;
                return result;

            }else {
                throw new NoSuchElementException();
            }


        }

        /**
         *  remove the current element
         */

        @Override
        public void remove() {
            if (modCountl != modCountg) {
                throw new ConcurrentModificationException();
            }
            if (afterNext == false) {
                throw new IllegalStateException();
            }
                int num = elements[nextIndex-1];
                clear(num);



            modCountl++;

            afterNext = false;

        }

    }

    /**
     *
     * @return a new iterator
     */

    public Iterator<Integer> iterator()
    {
        return new ArraySetIterator();
    }

    /**
     *
     * @param n integer
     * @return boolean test
     */
    public boolean test(int n)
    {
        if (n < smallest || n > largest) return false;
        for (int i = 0; i < elementCount; i++)
            if (elements[i] == n) return true;
        return false;
    }

    /**
     *
     * @param n remove int
     */
    public void clear(int n)
    {
        //System.out.println(Arrays.toString(elements) + " " + elementCount);
        for (int i = 0; i < elementCount; i++)
            if (elements[i] == n)
            {
                //System.out.println("ele - 1 " + elements[elementCount - 1]);
                elements[i] = elements[elementCount - 1];
                elementCount--;
                modCountg++;
                if (n == smallest)
                {
                    smallest = Integer.MAX_VALUE;
                    for (int k = 0; k < elementCount; k++)
                        smallest = Math.min(elements[k], smallest);
                }
                if (n == largest)
                {
                    largest = Integer.MIN_VALUE;
                    for (int k = 0; k < elementCount; k++)
                        largest = Math.max(elements[k], largest);
                }
            }

    }

    /**
     *
     * @param n set the integer
     */

    public void set(int n)
    {
//        System.out.println(Arrays.toString(elements) + " " + elementCount);
//        System.out.println("This statement is " + test(n) + " for " + n);

        if (!test(n)) { // if false, or if not found then set
            if (elements == null) {
                elements = new int[10];
            } else if (elements.length == elementCount) {
                elements = Arrays.copyOf(elements, 2 * elements.length);
            }
            elements[elementCount] = n;
            smallest = Math.min(smallest, n);
            largest = Math.max(largest, n);
            elementCount++;
            modCountg++;
        } else {
            System.out.println(n + " already included");
        }
    }

    /**
     *
     * @return the smallest element
     */
    public int min()
    {
        return smallest;
    }

    /**
     *
     * @return largest element
     */
    public int max()
    {
        return largest;
    }

    /**
     *
     * @return the size of the array
     */
    public int size()
    {
        return elementCount;
    }



    int modCountg;
    int smallest = Integer.MAX_VALUE;
    int largest = Integer.MIN_VALUE;
    int[] elements;
    int elementCount;
}


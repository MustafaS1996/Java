
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BitSet implements IntSet
{
    /**
     * create an iterator
     */

    private class BitSetIterator implements Iterator<Integer>
    {
        private int nextIndex =0;
        private int index = 0;
        private int arrIndex;
        private int currentEl;
        private boolean afterNext;
        public int modCountl = modCountg;

        /**
         *
         * @return boolean if next element available
         */
        @Override
        public boolean hasNext() {
            if (modCountl != modCountg) {
                throw new ConcurrentModificationException();
            }
            else {return nextIndex < elementCount;}
        }

        /**
         *
         * @return the next element
         */
        @Override
        public Integer next() {
            if (modCountl != modCountg) {
                throw new ConcurrentModificationException();
            }
           else if (hasNext()) {
                for (int p = arrIndex; p < elements.length; p++) {
                    for (int i = index; i < 32; i++) {
                        if (test(elements[p], i)) {

                            index = i;
                            arrIndex = p;
                            ++index;
                            ++nextIndex;
                            currentEl = (i + (start + p * 32));
                            afterNext = true;
                            return currentEl;

                        }
                        if (i == 31) {
                            index = 0;
                        }

                    }
                }
            }
            else {
                throw new NoSuchElementException();
            }
            afterNext = true;
            return currentEl;

        }

        /**
         * remove the current element
         */
        @Override
        public void remove() {
            if (modCountl != modCountg) {
                throw new ConcurrentModificationException();
            }
            else if (afterNext == false) {
                throw new IllegalStateException();
            }
            else {
                --nextIndex;
                clear(currentEl);
                modCountl++;
                afterNext = false;
            }
        }
    }

    /**
     *
     * @return new iterator call
     */
    public Iterator<Integer> iterator() {
        return new BitSetIterator();
    }

    /**
     *
     * @param n if is available
     * @return boolean true if available
     */
    public boolean test(int n)
    {
        if (elements == null || n < start || n >= start + 32 * elements.length)
            return false;
        int p = (n - start) / 32;
        int i = (n - start) % 32;
        return test(elements[p], i);
    }

    /**
     *
     * @param n into the bitset
     */
    public void set(int n)
    {
        if (elements == null)
        {
            elements = new int[10];
            start = n;

        }
        else if (n < start)
        {                  // (100 + 32 * 10 - 99 ) / 32 + 1 == 420 - 99 / 32 + 1
            int intsNeeded = (start + 32 * elements.length - n) / 32 + 1; // indexes needed to fit the new number
            int[] newElements = new int[Math.max(intsNeeded, 2 * elements.length)]; // makes array of either 2* original length or the next highest minimum
            System.arraycopy(elements, 0,
                    newElements, newElements.length - elements.length,
                    elements.length);
            start -= 32 * (newElements.length - elements.length); //make start the smallest possible minimum of bit set
            elements = newElements; //set newelements array back to the global elements array.
        }
        else if (n >= start + 32 * elements.length)
        {
            //increase size of elements array either by *2 or the next number of indexes to accomodate new number
            int intsNeeded = (n - start) / 32 + 1;
            elements = Arrays.copyOf(elements,
                    Math.max(intsNeeded, 2 * elements.length));
        }
        int p = (n - start) / 32;
        int i = (n - start) % 32;
        if (!test(elements[p], i))
        {
            elementCount++;
            elements[p] = set(elements[p], i);
        }
        modCountg++;
    }

    /**
     *
     * @param n remove from bitset
     */
    public void clear(int n)
    {
        if (elements != null && n >= start || n < start + 32 * elements.length)
        {
            int p = (n - start) / 32;
            int i = (n - start) % 32;
            if (test(elements[p], i))
            {
                elementCount--;
                elements[p] = clear(elements[p], i);
                modCountg++;
            }
        }
    }

    /**
     *
     * @return return smallest element
     */
    public int min()
    {
        if (elements != null)
            for (int p = 0; p < elements.length; p++)
                for (int i = 0; i < 32; i++)
                    if (test(elements[p], i)) return 32 * p + i + start;
        return Integer.MAX_VALUE;
    }

    /**
     *
     * @return largest element
     */
    public int max()
    {
        if (elements!= null)
            for (int p = elements.length - 1; p >= 0; p--)
                for (int i = 31; i >= 0; i--)
                    if (test(elements[p], i)) return 32 * p + i + start;
        return Integer.MIN_VALUE;
    }

    /**
     *
     * @return amount of elements
     */
    public int size()
    {
        return elementCount;
    }

    /**
     *
     * @param n array index
     * @param i bit index
     * @return boolean if in set
     */
    private static boolean test(int n, int i)
    {
        assert 0 <= i && i < 32;
        return (n & (1 << i)) != 0;
    }

    /**
     *
     * @param n array index
     * @param i bit index
     * @return set bit on and return new int
     */

    private static int set(int n, int i)
    {
        assert 0 <= i && i < 32;
        return n | (1 << i);
    }

    /**
     *
     * @param n array index
     * @param i bit index
     * @return set bit off and return new int
     */

    private static int clear(int n, int i)
    {
        assert 0 <= i && i < 32;
        return n & ~(1 << i);
    }

    int modCountg;
    int[] elements;
    int start;
    int elementCount;
}








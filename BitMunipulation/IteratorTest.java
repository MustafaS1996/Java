import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;


public class IteratorTest {

    /**
     * Test arrayset iterator
     */
    @Test public void ArraySetTest() {

        IntSet set = new ArraySet();
        set.set(100);
        set.set(102);
        set.set(-108);
        set.set(104);
        set.set(-100);
        set.set(109);
        set.set(200);


        Iterator<Integer> iterator = set.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        assertEquals(104,iterator.next().intValue());
        iterator.remove();
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        System.out.println("It 2");

        Iterator<Integer> iteratora = set.iterator();

        System.out.println(iteratora.next());
        System.out.println(iteratora.next());
        System.out.println(iteratora.next());
        assertEquals(200,iteratora.next().intValue());
        System.out.println(iteratora.next());
        System.out.println(iteratora.next());



    }

    /**
     * Test bitset iterator
     */
    @Test public void bittySetTest() {

            BitSet set = new BitSet();
            set.set(101);
            set.set(123);
            set.set(-321);
            set.set(312);
            set.set(-543);
            set.set(143);
            set.set(127);


            Iterator<Integer> iterator = set.iterator();

            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            assertEquals(123,iterator.next().intValue());
            iterator.remove();
            System.out.println(iterator.next());
            System.out.println(iterator.next());




        System.out.println("It 2");

        Iterator<Integer> iteratora = set.iterator();
        System.out.println(iteratora.next());
        System.out.println(iteratora.next());
        System.out.println(iteratora.next());
        assertEquals(312,iterator.next().intValue());
        System.out.println(iteratora.next());
        System.out.println(iteratora.next());
        System.out.println(iteratora.next());


        }




}

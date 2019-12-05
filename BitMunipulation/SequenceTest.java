
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class SequenceTest {

    /**
     * Test arrayset sequence
     */
    @Test public void ArraySetTest() {
        IntSet set = new ArraySet();
        IntSet set1 = new ArraySet();
        set.set(100);
        set.set(102);
        set.set(-108);
        set.set(104);
        set.set(-100);
        set.set(109);
        set.set(200);

        set1.set(321);
        set1.set(213);
        set1.set(-54);
        set1.set(543);
        set1.set(423);
        set1.set(123);
        set1.set(654);


        Iterator<Integer> iterator = set.iterator();
        Iterator<Integer> iteratora = set1.iterator();
        IntSequence seq = IntSequence.fromIterator(iterator);
        IntSequence seq1 = IntSequence.fromIterator(iteratora);

        IntSequence seq2 = seq.alternate(seq1);

        System.out.println(seq2.next());
        assertEquals(321,seq2.next().intValue());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        assertEquals(-100,seq2.next().intValue());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());


    }

    /**
     * Test bitset Sequence
     */

    @Test public void bitSetTest() {
        BitSet set = new BitSet();
        BitSet set1 = new BitSet();
        set.set(423);
        set.set(436);
        set.set(-213);
        set.set(651);
        set.set(-534);
        set.set(876);
        set.set(123);

        set1.set(543);
        set1.set(982);
        set1.set(-65);
        set1.set(143);
        set1.set(742);
        set1.set(163);
        set1.set(654);


        Iterator<Integer> iterator = set.iterator();
        Iterator<Integer> iteratora = set1.iterator();
        IntSequence seq = IntSequence.fromIterator(iterator);
        IntSequence seq1 = IntSequence.fromIterator(iteratora);

        IntSequence seq2 = seq.alternate(seq1);

        System.out.println(seq2.next());
        System.out.println(seq2.next());
        assertEquals(-213,seq2.next().intValue());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());
        System.out.println(seq2.next());


    }










}

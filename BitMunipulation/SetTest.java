
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class SetTest
{
   @Test public void setAndClear()
   {
      IntSet set = new ArraySet();
      set.set(100);
      set.set(101);
      set.set(150);
      set.clear(100);
//      assertEquals(100, set.min());
//      assertEquals(150, set.max());
//      assertEquals(2, set.size());
//      assertTrue(set.test(150));
//      assertFalse(set.test(102));
   }
//   @Test public void elementOrderRemove()
//   {
//      ArraySet set = new ArraySet();
//      set.set(40);
//      set.set(110);
//      set.set(90);
//      set.set(70);
//      set.set(100);
//      set.set(80);
//      set.clear(110);
//      assertEquals(40, set.elements[0]);
//      assertEquals(80, set.elements[1]);
//      assertEquals(90, set.elements[2]);
//      assertEquals(100, set.largest);
//      assertEquals(70, set.elements[3]);
//      assertEquals(5, set.size());
//      set.clear(40);
//      set.set(1000);
//      set.set(3);
//      set.set(32);
//      set.set(31);
//      set.set(534);
//      set.set(543);
//      set.set(754);
//      set.set(654);
//      set.clear(654);
//      set.clear(9);
//      assertEquals(11, set.size());
//      assertEquals(3, set.smallest);
//      assertEquals(3, set.elements[5]);
//
//   }
//
//   @Test public void testOnesElement()
//   {
//      IntSet set = new BitSet();
//      set.set(100);
//      set.set(300);
//
//      assertEquals(100, set.min());
//      assertEquals(300, set.max());
//      set.clear(300);
//      assertEquals(100, set.max());
//      assertEquals(1, set.size());
//      assertTrue(set.test(100));
//      assertFalse(set.test(-100));
//      set.set(301);
//      set.set(301);
//      set.clear(301);
//      assertEquals(301, set.max());
//      //assertTrue(set.test(301));
//      assertFalse(set.test(99));
//   }
//
//   @Test public void testsBits()
//   {
//      BitSet set = new BitSet();
//      set.set(100);
//      set.set(102);
//      set.set(200);
//      set.set(196);
//      set.set(500);
//      //set.set(-200);
//      set.clear(100);
//      set.clear(500);
//      set.clear(196);
//
//     // assertEquals(5, set.elements[0]);
//     // assertEquals(-200, set.start);
//   }
//
//
//   @Test public void testOneElement()
//   {
//      IntSet set = new BitSet();
//      set.set(100);
//      set.set(102);
//      assertEquals(100, set.min());
//      assertEquals(102, set.max());
//      assertEquals(2, set.size());
//      assertTrue(set.test(100));
//      assertFalse(set.test(99));
//   }
//
//   @Test public void testBits()
//   {
//      BitSet set = new BitSet();
//      set.set(100);
//      set.set(102);
//      set.set(156);
//      set.clear(100);
//      set.set(500);
//      assertFalse(set.test(99));
//      assertEquals(4, set.elements[0]);
//      assertEquals(100, set.start);
//      assertEquals(3, set.size());
//   }

}


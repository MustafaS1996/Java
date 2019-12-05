import java.util.Iterator;
public interface IntSet
{
   /**
    *
    * @return creates an iterator
    */
   Iterator<Integer> iterator();


   boolean test(int n);
   void set(int n);
   void clear(int n);
   int min();
   int max();
   int size();
}

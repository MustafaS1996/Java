
import java.util.Iterator;

public interface IntSequence {
    int[] counter = {1};


    abstract Integer next();

    /**
     *
     * @param itr tests from hasnext if available
     * @return the next element
     */
    public static IntSequence fromIterator(Iterator<Integer> itr) {

        return () -> {
            if (itr.hasNext()) {
                return itr.next();
            }
            return null;
        };
    }

    /**
     *
     * @param other a sequence
     * @return next elements available
     */
     default IntSequence alternate(IntSequence other) {
         return () -> {
             if(counter[0]==1) {
                 counter[0]=0;
                 return  this.next();
             } else {
                 counter[0] =1;
                 return other.next();
             }
         };
        }

    }





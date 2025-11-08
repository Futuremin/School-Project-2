package heaps.upheap;



/**
 * An abstract base class to ease the implementation of the PriorityQueue interface.
 *
 * (modified by AD for teaching purposes)
 */
public abstract class AbstractPriorityQueue<K> implements PriorityQueue<K> {
    //---------------- nested PQEntry class ----------------
    /**
     * A concrete implementation of the Entry interface
     */
    protected static class HeapNode<K> implements Entry<K> {
        private K  key;  //key

        public HeapNode(K key) {
            this.key = key;
        }

        // methods of the Entry interface
        public K getKey() { return key; }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) { this.key = key; }

    } //----------- end of nested PQEntry class -----------



    /** Method for comparing two heapNodes according to key */
    protected int compare(Entry<K> a, Entry<K> b) {
        //return -ve int if a.getKey() < b.getKey()
        //return 0 if a.getKey() == b.getKey()
        //return +ve int if a.getKey() > b.getKey()
        return ( (Comparable<K>) a.getKey()).compareTo(b.getKey() ) ;
    }


    /**
     * Tests whether the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() { return size() == 0; }
}

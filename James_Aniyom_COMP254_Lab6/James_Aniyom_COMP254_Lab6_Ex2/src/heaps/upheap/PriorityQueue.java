package heaps.upheap;

/*
 * (modified by AD for teaching purposes)
 */

/**
 * Interface for the priority queue ADT.
 *
 */
public interface PriorityQueue<K> {

    /**
     * Returns the number of items in the priority queue.
     * @return number of items
     */
    int size();

    /**
     * Tests whether the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts a key and returns the entry created.
     */
    Entry<K> insert(K key) throws IllegalArgumentException;

    /**
     * Returns (but does not remove) an entry with minimal key.
     * @return entry having a minimal key (or null if empty)
     */
    Entry<K> min();

    /**
     * Removes and returns an entry with minimal key.
     * @return the removed entry (or null if empty)
     */
    Entry<K> removeMin();
}

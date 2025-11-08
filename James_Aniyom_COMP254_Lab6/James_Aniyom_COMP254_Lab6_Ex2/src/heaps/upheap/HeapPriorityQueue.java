package heaps.upheap;

/*
 * (modified by AD for teaching purposes)
 */

import java.util.ArrayList;

/**
 * An implementation of a priority queue using an ArrayList based heap.
 *
 */
public class HeapPriorityQueue<K> extends AbstractPriorityQueue<K> {
    /** primary collection of priority queue entries */
    public ArrayList< Entry<K> > heap = new ArrayList<>();

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public HeapPriorityQueue() { }


    //j is an index in the ArrayList that represents the heap (i.e the ArrayList
    //containing the keys of the heap)

    //return index for parent of the child stored at index j
    //(Passing either left or right child's index is fine. Here we pass
    //left child's index)
    protected int parent(int j) { return (j-1) / 2; }     // truncating division

    //what would have been the index for left child if
    //a parent was stored at index j?
    protected int computeLeftIndex(int j) { return 2*j + 1; }

    //what would have been the index for right child if
    //a parent was stored at index j?
    protected int computeRightIndex(int j) { return 2*j + 2; }

    //The two methods below are called by downheap to restore heap-order property.
    //Note that the modification of heap has already happened due to removeMin
    //before these methods are called. This implies that the heap-size
    //(i.e. number of HeapNodes in the heap arrayList) is valid
    //when each of these method are called.

    //check if parent at index j has a left child present.
    //(For this, the arrayList index returned by computeLeftIndex
    //must be within the number of HeapNodes in the heap arrayList).
    protected boolean hasLeftChild(int j) { return computeLeftIndex(j) < heap.size(); }
    //check if parent at index j has a right child present
    protected boolean hasRightChild(int j) { return computeRightIndex(j) < heap.size(); }


    /** Exchanges the entries at indices i and j of the array list. */
    protected void swap(int i, int j) {
        Entry<K> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j HIGHER, if necessary, to restore
     * the heap property.
     * This is the RECURSIVE METHOD
     */
    protected void upheap(int j) {
        System.out.println("upheap called on index " + j);

        if (j == 0) return;  // base case: we’re at the root

        int p = parent(j);

        if (compare(heap.get(j), heap.get(p)) < 0) {
            swap(j, p);      // swap with parent
            upheap(p);       // recurse up to parent
        }
        // else: heap-order is fine, do nothing
    }



    /** Moves the entry at index j LOWER, if necessary, to restore
     *  the heap property.
     */
    protected void downheap(int j) {
        System.out.println("downheap called on index " + j);

        while (hasLeftChild(j)) {               // continue to bottom of tree (or break statement)
            int leftIndex = computeLeftIndex(j);
            int smallChildIndex = leftIndex;     // although right may be smaller
            if (hasRightChild(j)) {
                int rightIndex = computeRightIndex(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
                    smallChildIndex = rightIndex;  // right child is smaller
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break;                             // heap-order property has been restored
            swap(j, smallChildIndex);
            j = smallChildIndex;                 // continue at position of the child
        }
    }


    /**
     * Removes and returns an entry with minimal key.
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K> removeMin() {
        if (heap.isEmpty()) return null;

        Entry<K> answer = heap.get(0);
        swap(0, heap.size() - 1);    // put minimum item at the end
        heap.removeLast();  // and remove it from the list;
        downheap(0);  //restore heap-order property
        //downheap_AD(0); //restore heap-order property  (by AD)
        return answer;
    }

    /**
     * Returns the number of items in the arrayList.
     * @return number of items
     */
    @Override
    public int size() { return heap.size(); }

    /**
     * Returns (but does not remove) an entry with minimal key.
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K> min() {
        if (heap.isEmpty()) return null;
        return heap.getFirst();
    }


    /**
     * Inserts a key and return the entry created.
     */
    @Override
    public Entry<K> insert(K key) throws IllegalArgumentException {
        Entry<K> newest = new HeapNode<>(key);
        heap.add(newest);      //add to the end of the arraylist
        upheap(heap.size() - 1);    //restore heap-order property
        //upheap_AD(heap.size() - 1);    //restore heap-order property   (by AD)
        return newest;
    }

    //utility method added by AD
    public <K> void displayHeap() {
        System.out.print("[");
        for (int i=0; i < this.size(); i++) {
            if(i == (this.size()-1)) {
                System.out.print(this.heap.get(i).getKey());
            }
            else {
                System.out.print(this.heap.get(i).getKey() + ", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }


    public static void main(String[] args)
    {
	  /*
	   * Heap tree-1:
	   *
	            2
	           / \
	          5   6
	         / \
	        9   7

	  */

        //create the above heap (It follows the contract of PriorityQueue interface)

        System.out.println("Heap tree-1:");
        HeapPriorityQueue<Integer> heapPQ1 = new HeapPriorityQueue<Integer>();
        heapPQ1.insert(2);
        heapPQ1.insert(5);
        heapPQ1.insert(6);
        heapPQ1.insert(9);
        heapPQ1.insert(7);

        heapPQ1.displayHeap();

	  /*
	  //insert 1
	  heapPQ1.insert(1);
	  System.out.println("after inserting 1:");
	  displayHeap(heapPQ1);
	  */





        //remove minimum key
        heapPQ1.removeMin();
        System.out.println("After removal of minimum key:");
        heapPQ1.displayHeap();
        System.out.println();



        /*
         * Heap tree-2:
         */
        System.out.println("Heap tree-2:");
        HeapPriorityQueue<Integer> heapPQ2 = new HeapPriorityQueue<Integer>();
        heapPQ2.insert(2);
        heapPQ2.insert(9);
        heapPQ2.insert(7);
        heapPQ2.insert(5);
        heapPQ2.insert(6);

        heapPQ2.displayHeap();

	  /*
	   * Heap tree-2: You get the following tree.
	   *
	            2
	           / \
	          5   7
	         / \
	        9   6

	  */

    }
}

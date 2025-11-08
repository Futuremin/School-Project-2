import heaps.upheap.HeapPriorityQueue;

public static void main(String[] args) {
    System.out.println("Testing Recursive Upheap Method");

    // Creating heap using your HeapPriorityQueue class
    HeapPriorityQueue<Integer> heap = new HeapPriorityQueue<>();

    // Inserting elements
    System.out.println("\nInserting elements into heap:");
    heap.insert(10);
    heap.insert(4);
    heap.insert(15);
    heap.insert(2);
    heap.insert(7);

    // Displaying the heap after insertions
    System.out.println("\nHeap after insertions:");
    heap.displayHeap();

    // Showing the minimum element
    System.out.println("\nMinimum key: " + heap.min().getKey());

    // Removing the minimum element and showing heap again
    System.out.println("\nRemoving min...");
    heap.removeMin();

    System.out.println("Heap after removing min:");
    heap.displayHeap();
}

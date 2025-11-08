package exercise1;
import java.util.Iterator;

public class CircularlyLinkedList<E> implements Iterable<E> {

    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------


    private Node<E> tail = null;
    private int size = 0;


    public CircularlyLinkedList() { }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }


    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }


    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }


    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }


    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // circular link
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }


    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }


    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }


    public String toString() {
        if (tail == null) return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }


    public E getMax() {
        if (isEmpty())
            throw new IllegalStateException("List is empty");

        Node<E> head = tail.getNext();
        E max = head.getElement();
        Node<E> current = head.getNext();

        while (current != head) {
            if (((Comparable<E>) current.getElement()).compareTo(max) > 0)
                max = current.getElement();
            current = current.getNext();
        }
        return max;
    }


    public Iterator<E> iterator() {
        return new ElementIterator(this);
    }

    private class ElementIterator implements Iterator<E> {
        private CircularlyLinkedList<E> cLL;
        private int cursor;
        private Node<E> cursorPointer;

        public ElementIterator(CircularlyLinkedList<E> m) {
            cLL = m;
            cursor = 0;
            cursorPointer = cLL.tail;
        }

        public boolean hasNext() {
            return (cursor < cLL.size());
        }

        public E next() {
            cursor++;
            cursorPointer = cursorPointer.getNext();
            return cursorPointer.getElement();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularlyLinkedList<String> cll = new CircularlyLinkedList<>();
        cll.addFirst("MTL");
        cll.addLast("QUE");
        cll.addLast("VIC");
        cll.addLast("YYC");

        System.out.println("Circular List: " + cll);
        System.out.println("Max element in the list: " + cll.getMax());

        // Testing iteration with for-each loop
        System.out.println("\nElements in the list:");
        for (String s : cll) {
            System.out.println(s);
        }
    }
}

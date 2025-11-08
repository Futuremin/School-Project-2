package exercise2;

public class DoublyLinkedList<E> {

    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }

        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    } //----------- end of nested Node class -----------

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }


    public void reverseList() {
        Node<E> current = header;
        // Traverse all nodes.
        while (current != null) {
            Node<E> temp = current.getNext();
            current.setNext(current.getPrev());
            current.setPrev(temp);

            current = current.getPrev();
        }

        Node<E> temp = header;
        header = trailer;
        trailer = temp;
    }

    // main method for testing the doubly linked list and reverseList
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("Kobie");
        list.addLast("James");
        list.addLast("Jude");
        list.addLast("Cole");

        System.out.println("Original list: " + list.toString());

        list.reverseList();

        System.out.println("Reversed list: " + list.toString());


        DoublyLinkedList<String> list1 = new DoublyLinkedList<>();
        list1.addFirst("A");
        list1.addFirst("B");

        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        list2.addLast("A");
        list2.addLast("B");

        DoublyLinkedList<String> list3 = new DoublyLinkedList<>();
        list3.addLast("A");
        list3.removeFirst();

        DoublyLinkedList<String> list4 = new DoublyLinkedList<>();
        list4.addLast("A");
        list4.addLast("B");
        list4.removeFirst();

        DoublyLinkedList<String> list5 = new DoublyLinkedList<>();
        list5.addLast("A");
        list5.removeLast();

        DoublyLinkedList<String> list6 = new DoublyLinkedList<>();
        list6.addLast("A");
        list6.addLast("B");
        list6.removeLast();
    }
} //----------- end of DoublyLinkedList class -----------

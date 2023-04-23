package Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<Item> implements Iterable<Item>, BagAPI<Item> {
    private Node first;     // beginning of the bag
    private int n;          // number of elements in bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty bag.
     */
    public LinkedBag() {
        first = null;
        n = 0;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns an iterator that iterates over the items in the bag.
     *
     * @return an iterator that iterates over the items in the bag
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    // an iterator over a linked list
    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit test the {@code LinkedBag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LinkedBag<String> bag = new LinkedBag<>();
        bag.add("Hello");
        bag.add("World");

        System.out.println("size of bag = " + bag.size());

        for (String s : bag) {
            System.out.println(s);
        }
    }

}

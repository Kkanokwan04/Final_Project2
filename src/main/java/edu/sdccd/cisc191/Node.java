package edu.sdccd.cisc191;

/**
 * Represents a single node in a linked list.
 * Each node contains a {@link BookOrder} object as its data and a reference to the next node in the list.
 */
public class Node {
    /**
     * The {@link BookOrder} object stored in this node.
     */
    BookOrder data;

    /**
     * A reference to the next node in the linked list.
     * If this is the last node in the list, {@code next} will be {@code null}.
     */
    Node next;

    /**
     * Constructs a new {@code Node} with the specified {@link BookOrder}.
     * The {@code next} reference is initialized to {@code null}.
     *
     * @param data the {@link BookOrder} object to store in this node
     */
    public Node(BookOrder data) {
        this.data = data; // Assign the provided BookOrder to this node
        this.next = null; // Initialize the next reference to null
    }
}

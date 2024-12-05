package edu.sdccd.cisc191;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A custom linked list implementation for managing {@link BookOrder} objects.
 * Provides methods to add, remove, and convert the list into an ObservableList.
 */
public class BookLinkedList
{
    /**
     * The head node of the linked list.
     */
    private Node head;

    /**
     * Adds a new book to the end of the linked list.
     *
     * @param book the {@link BookOrder} to add to the list
     */
    public void add(BookOrder book){
        Node newNode = new Node(book); // Create a new node with the given book
        if(head == null){
            // If the list is empty, set the new node as the head
            head = newNode;
        }else{
            // Traverse to the end of the list and add the new node
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Removes the first occurrence of the specified book from the linked list.
     *
     * @param book the {@link BookOrder} to remove from the list
     */
    public void remove(BookOrder book){
        if (head == null) {
            return; // If the list is empty, nothing to remove
        }
        if(head.data.equals(book)){
            // If the book to remove is the head, update the head to the next node
            head = head.next;
            return;
        }

        // Traverse the list to find the book to remove
        Node current = head;
        while(current.next != null && !current.next.data.equals(book)){
            current = current.next;
        }

        // If the book is found, remove it by updating the next pointer
        if(current.next != null){
            current.next = current.next.next;

        }
    }

    /**
     * Converts the linked list to an {@link ObservableList}.
     *
     * @return an {@link ObservableList} containing all {@link BookOrder} objects in the linked list
     */
    public ObservableList<BookOrder> toObservableList(){
        // Create an empty ObservableList
        ObservableList<BookOrder> lists = FXCollections.observableArrayList();
        Node current = head;

        // Create an empty ObservableList
        while(current != null){
            lists.add(current.data);
            current = current.next;
        }
        return lists; // Return the populated ObservableList
    }
}

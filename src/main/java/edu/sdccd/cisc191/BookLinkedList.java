package edu.sdccd.cisc191;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class BookLinkedList {
    private Node head;
    
    public void add(BookOrder book){
        Node newNode = new Node(book);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(BookOrder book){
        if (head == null) return;
        if(head.data.equals(book)){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null && !current.next.data.equals(book)){
            current = current.next;
        }

        if(current.next != null){
            current.next = current.next.next;

        }
    }

    public ObservableList<BookOrder> toObservableList(){
        ObservableList<BookOrder> lists = FXCollections.observableArrayList();
        Node current = head;

        while(current != null){
            lists.add(current.data);
            current = current.next;
        }
        return lists;
    }
}

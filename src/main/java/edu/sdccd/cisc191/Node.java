package edu.sdccd.cisc191;

public class Node {
    BookOrder data;
    Node next;

    public Node(BookOrder data) {
        this.data = data;
        this.next = null;
    }
}

package edu.sdccd.cisc191;

public class BookOrder {
    private Long id;
    private String bookName;

    public BookOrder() {}
    public BookOrder(String bookName) {this.bookName = bookName;}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    @Override
    public String toString() { return bookName; }

}

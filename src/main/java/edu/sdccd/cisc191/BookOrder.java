package edu.sdccd.cisc191;

/**
 * Represents a book in the library system.
 * Each book has an ID and a name.
 */
public class BookOrder {
    /**
     * The unique identifier for the book.
     * This is typically assigned by the database.
     */
    private Long id;

    /**
     * The name of the book.
     */
    private String bookName;

    /**
     * Default constructor.
     * Creates an empty {@code BookOrder} object.
     */
    public BookOrder() {}

    /**
     * Constructs a {@code BookOrder} with the specified name.
     *
     * @param bookName the name of the book
     */
    public BookOrder(String bookName) {this.bookName = bookName;}

    /**
     * Gets the unique identifier of the book.
     *
     * @return the book's ID
     */
    public Long getId() { return id; }

    /**
     * Sets the unique identifier for the book.
     *
     * @param id the book's ID to set
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Gets the name of the book.
     *
     * @return the name of the book
     */
    public String getBookName() { return bookName; }

    /**
     * Sets the name of the book.
     *
     * @param bookName the name of the book to set
     */
    public void setBookName(String bookName) { this.bookName = bookName; }

    /**
     * Returns a string representation of the book.
     * This is typically the book's name.
     *
     * @return the name of the book
     */
    @Override
    public String toString() { return bookName; }

}

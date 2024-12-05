package edu.sdccd.cisc191;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Manages a collection of books in a library system.
 * Provides operations for adding, removing, sorting, and asynchronously loading books.
 * Integrates with {@link BookLinkedList} for in-memory storage and {@link BookDAO} for database persistence.
 */
public class BookManager {

    /**
     * A linked list that stores the in-memory collection of books.
     */
    private BookLinkedList bookList = new BookLinkedList();

    /**
     * A Data Access Object for interacting with the database.
     */
    private BookDAO bookDAO = new BookDAO();
    /**
     * A callback to execute after books are loaded asynchronously.
     */
    private Runnable bookLoaded;

    /**
     * Constructs a new {@code BookManager} and loads books from the database asynchronously.
     */
    public BookManager() {
        loadBooksConcurrently();
    }

    /**
     * Sets a callback to be executed when books are successfully loaded.
     *
     * @param bookLoaded a {@link Runnable} to execute upon successful book loading
     */
    public void setBookLoaded(Runnable bookLoaded)
    {
        this.bookLoaded = bookLoaded;
    }

    /**
     * Loads books from the database asynchronously.
     * Updates the in-memory book list upon successful loading and executes the {@link #bookLoaded} callback if set.
     */
    public void loadBooksConcurrently() {
        javafx.concurrent.Task<ObservableList<BookOrder>> loadBook = new javafx.concurrent.Task()
        {
            @Override
            protected ObservableList<BookOrder> call()
            {
                return FXCollections.observableArrayList(bookDAO.getAllBooks()); // Load books from the database and convert to ObservableList
            }
        };
        // Handle successful loading
        loadBook.setOnSucceeded(event -> {
            ObservableList<BookOrder> books = loadBook.getValue();

            // Clear and update the in-memory book list
            bookList = new BookLinkedList();
            books.forEach(bookList::add);

            // Clear and update the in-memory book list
            books.forEach(book -> { System.out.println(book.getBookName()); });

            // Execute the callback, if provided
            if (bookLoaded != null) {
                bookLoaded.run();
            }
        });

        // Handle loading failure
        loadBook.setOnFailed(event -> {
            System.err.println("Failed to load books.");
            loadBook.getException().printStackTrace();
        });

        // Run the task on a new thread
        new Thread(loadBook).start();
    }

    /**
     * Retrieves the list of books as an {@link ObservableList}.
     * Useful for integration with JavaFX UI components like {@link javafx.scene.control.ListView}.
     *
     * @return an observable list of all books
     */
    public ObservableList<BookOrder> getBooks()
    {
        return bookList.toObservableList();
    }

    /**
     * Adds a new book to the library.
     * Updates both the in-memory book list and the database.
     *
     * @param book the {@link BookOrder} to add
     */
    public void addBook(BookOrder book) {
        bookList.add(book); // Add to the in-memory list
        bookDAO.addBook(book); // Persist in the database
    }

    /**
     * Removes a book from the library.
     * Updates both the in-memory book list and the database.
     *
     * @param book the {@link BookOrder} to remove
     */
    public void removeBook(BookOrder book) {
        bookList.remove(book); // Remove from the in-memory list
        bookDAO.deleteBook(book.getId()); // Delete from the database
    }

    /**
     * Sorts the in-memory book list alphabetically by book name.
     * Updates the internal linked list to reflect the sorted order.
     */
    public void sortBookByName(){
        // Create a sorted ObservableList of books
        ObservableList<BookOrder> sortedBooks = FXCollections.observableArrayList(
                getBooks().stream()
                        .sorted(Comparator.comparing(BookOrder::getBookName))
                        .collect(Collectors.toList()));

        // Update the in-memory book list with the sorted order
        bookList = new BookLinkedList();
        sortedBooks.forEach(bookList::add);
    }

}


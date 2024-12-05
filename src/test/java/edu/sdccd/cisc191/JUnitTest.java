package edu.sdccd.cisc191;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitTest {

    @Test
    public void testBookOrder() {
        BookOrder book = new BookOrder("The Best Seller");
        assertEquals("The Best Seller", book.getBookName());
    }

    @Test
    public void testSetBookName() {
        BookOrder book = new BookOrder("The Best Seller");
        book.setBookName("First Book");
        assertEquals("First Book", book.getBookName());

    }

    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        try (FileWriter fileWriter = new FileWriter("BookName.txt")){
            fileWriter.write("");
        }catch (IOException e){
            e.printStackTrace();
        }
        bookManager = new BookManager();
    }

    @Test
    void testAddBook() {
        BookOrder book = new BookOrder("Book Order");
        bookManager.addBook(book);
        ObservableList<BookOrder> books = bookManager.getBooks();
        assertTrue(books.contains(book));

    }


    @Test
    void testRemoveBook() {
        // Add a book first
        BookOrder book = new BookOrder("1984");
        bookManager.addBook(book);

        // Remove the book
        bookManager.removeBook(book);

        // Verify the book was removed
        ObservableList<BookOrder> books = bookManager.getBooks();
        assertFalse(books.contains(book));
    }

    @Test
    void testSortBookByName() {
        BookManager bookManager = new BookManager();
        BookOrder book1 = new BookOrder("Zebra");
        BookOrder book2 = new BookOrder("Chicken");
        BookOrder book3 = new BookOrder("Snake");

        // Add multiple books
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        // Sort the books by name
        bookManager.sortBookByName();

        // Verify the order of the books
        ObservableList<BookOrder> books = bookManager.getBooks();
        assertEquals("Chicken", books.get(0).getBookName());
        assertEquals("Snake", books.get(1).getBookName());
        assertEquals("Zebra", books.get(2).getBookName());
    }

    @Test
    public void testDatabaseConnection(){
        BookDAO bookDAO = new BookDAO();
        BookOrder book = new BookOrder("Check Database");

        bookDAO.addBook(book);

        List<BookOrder> books = bookDAO.getAllBooks();
        boolean found = books.stream().anyMatch(b -> b.getBookName().equals("Check Database"));
        assertTrue(found);
    }

    @Test
    public void testConcurrency(){
        BookManager bookManager = new BookManager();

        ObservableList<BookOrder> books = bookManager.getBooks();

        assertNotNull(books);
        assertTrue(books.isEmpty());
    }

    @Test
    public void testStream(){
        BookManager bookManager = new BookManager();
        BookOrder book1 = new BookOrder("First Book");
        BookOrder book2 = new BookOrder("Second Book");
        BookOrder book3 = new BookOrder("Third Book");

        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);

        List<BookOrder> filtered = bookManager.getBooks().stream()
                .filter(book -> book.getBookName().contains("Book"))
                .collect(Collectors.toList());

        assertEquals(3, filtered.size());
    }

}

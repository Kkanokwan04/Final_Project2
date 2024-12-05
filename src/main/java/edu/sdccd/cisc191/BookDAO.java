package edu.sdccd.cisc191;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) class for managing book records in the database.
 * Provides methods to add, retrieve, update, and delete books.
 */
public class BookDAO
{
    /**
     * Adds a new book to the database.
     * After the book is added, the generated ID is set in the (@link BookOrder) object.
     *
     * @param book the {@link edu.sdccd.cisc191.BookOrder} object to add to the database
     */
    public void addBook(edu.sdccd.cisc191.BookOrder book)
    {
        String sql = "INSERT INTO Book(bookName) VALUES(?)";

        try(Connection conn = edu.sdccd.cisc191.DatabaseConnection.getConnection())
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,book.getBookName());

            preparedStatement.executeUpdate();

            try(ResultSet rs = preparedStatement.getGeneratedKeys())
            {
                if(rs.next())
                {
                    book.setId(rs.getLong(1));
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all books from the database.
     *
     * @return a list of {@link edu.sdccd.cisc191.BookOrder} objects representing all books in the database
     */
    public ArrayList<edu.sdccd.cisc191.BookOrder> getAllBooks()
    {
        String sql = "SELECT * FROM Book";
        ArrayList<edu.sdccd.cisc191.BookOrder> books = new ArrayList<>();

        try(Connection conn = edu.sdccd.cisc191.DatabaseConnection.getConnection())
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            {

                while (rs.next()){
                    edu.sdccd.cisc191.BookOrder book = new edu.sdccd.cisc191.BookOrder();
                    book.setId(rs.getLong("id"));
                    book.setBookName(rs.getString("bookName"));
                    books.add(book);
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return books;
    }

    /**
     * Updates the details of an existing book in the database.
     *
     * @param book the {@link edu.sdccd.cisc191.BookOrder} object containing the updated details
     */
    public void updateBook(edu.sdccd.cisc191.BookOrder book)
    {
        String sql = "UPDATE Book SET bookName = ? WHERE id = ?";

        try(Connection conn = edu.sdccd.cisc191.DatabaseConnection.getConnection())
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setLong(2, book.getId());
            preparedStatement.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Deletes a book from the database by its ID.
     *
     * @param bookId the ID of the book to delete
     */
    public void deleteBook(Long bookId){
        String sql = "DELETE FROM Book WHERE id = ?";

        try(Connection conn = edu.sdccd.cisc191.DatabaseConnection.getConnection())
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, bookId);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

}
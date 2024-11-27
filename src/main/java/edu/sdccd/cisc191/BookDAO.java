package edu.sdccd.cisc191;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Data Access Object
 * */
public class BookDAO {

    public void addBook(BookOrder book){
        String sql = "INSERT INTO Book(bookName) VALUES(?)";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS){
            preparedStatement.setString(1,book.getBookName());

            preparedStatement.executeUpdate();

            try(ResultSet rs = preparedStatement.getGeneratedKeys()){
                if(rs.next()){
                    book.setId(rs.getLong(1));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<BookOrder> getAllBooks() {
        String sql = "SELECT * FROM Book";
        ArrayList<BookOrder> books = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql)){

            while (rs.next()){
                BookOrder book = new BookOrder();
                book.setId(rs.getLong("id"));
                books.add(book);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return books;
    }

    public void ubdateBook(BookOrder book){
        String sql = "UPDATE Book SET bookName = ? WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection;
        PreparedStatement preparedStatement = conn.prepareStatement(sql)){

            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setLong(2, book.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteBook(Long bookId){
        String sql = "DELETE FROM Book WHERE id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)){

            preparedStatement.setLong(1, bookId);
            preparedStatement.executeUpdate()
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

}

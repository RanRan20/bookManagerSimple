/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import conection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class bookController {
   
    
     public boolean saveBook(book book) {
        try (Connection connection = Conection.getConnection()) {
            String sql = "INSERT INTO book (name, author, price) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, book.getName());
                statement.setString(2, book.getAuthor());
                statement.setDouble(3, book.getPrice());

                int rowsInserted = statement.executeUpdate();

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        book.setId(id);
                    } else {
                        throw new SQLException("Fallo al obtener el ID autoincremental.");
                    }
                }

                return rowsInserted > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(book book) {
        String sql = "UPDATE book SET name = ?, author = ?, price = ? WHERE id = ?";
        try (Connection connection = Conection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(int bookId) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (Connection connection = Conection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bookId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<book> getAllBooks() {
        List<book> books = new ArrayList<>();
        String sql = "SELECT * FROM book";

        try (Connection connection = Conection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");

                book book = new book(id, name, author, price);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean deleteAllBooks() {
        String sql = "DELETE FROM book";
        try (Connection connection = Conection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}




    
    
    


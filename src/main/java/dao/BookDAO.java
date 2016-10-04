package dao;

import connections.DatabaseConnection;
import entities.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO {

    private Connection connection = DatabaseConnection.getConnection();

    public ArrayList<Book> getBooksByName(String name) {

        ArrayList<Book> books = new ArrayList<>();

        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book WHERE" +
                    " name LIKE '%" + name + "%'");

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDate(resultSet.getInt("date"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public ArrayList<Book> getBooksByAuthor(String author) {

        ArrayList<Book> books = new ArrayList<>();

        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book WHERE" +
                    " author LIKE '%" + author + "%'");

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDate(resultSet.getInt("date"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    //
    public ArrayList<Book> getBooksByDate(int date) {

        String query = "SELECT * FROM book WHERE date = ?";

        ArrayList<Book> books = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt((int) 1, date);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDate(resultSet.getInt("date"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

}

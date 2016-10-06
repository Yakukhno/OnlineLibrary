package dao.impl;

import dao.BookDAO;
import entities.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDAOJdbcImpl implements BookDAO {

    private String URL = "jdbc:mysql://localhost:3306/librarydb";
    private String login = "root";
    private String password = "root";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, login, password);
    }

    public BookDAOJdbcImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(String name, String author, int date) {

        String query = "INSERT INTO book (name, author, date) VALUES (?, ?, ?)";

        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, name);
            statement.setString(2, author);
            statement.setInt(3, date);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Book> getAllBooks() {

        ArrayList<Book> books = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");

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

    public ArrayList<Book> getBooksByName(String name) {

        ArrayList<Book> books = new ArrayList<>();

        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

        Connection connection = null;
        try {
            connection = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    @Override
    public void updateBook(int id, String name, String author, int date) {

    }

    @Override
    public void deleteBook(int id) {

    }



}

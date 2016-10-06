package dao;

import entities.Book;

import java.util.ArrayList;

public interface BookDAO {

    void addBook(String name, String author, int date);

    ArrayList<Book> getAllBooks();

    ArrayList<Book> getBooksByName(String name);

    ArrayList<Book> getBooksByAuthor(String author);

    ArrayList<Book> getBooksByDate(int date);

    void updateBook(int id, String name, String author, int date);

    void deleteBook(int id);

}

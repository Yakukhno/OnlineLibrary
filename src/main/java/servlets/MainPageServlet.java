package servlets;

import dao.BookDAO;
import dao.impl.BookDAOJdbcImpl;
import entities.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookDAO bookDAOJdbcImpl = new BookDAOJdbcImpl();

        ArrayList<Book> books = null;
        if (req.getParameter("type_of_search") != null) {
            if (req.getParameter("type_of_search").equals("name")) {
                books = bookDAOJdbcImpl.getBooksByName(req.getParameter("search"));
            } else if (req.getParameter("type_of_search").equals("author")) {
                books = bookDAOJdbcImpl.getBooksByAuthor(req.getParameter("search"));
            }
        } else {
            books = bookDAOJdbcImpl.getAllBooks();
        }

        req.setAttribute("books", books);

//        bookDAOJdbcImpl.addBook("Мастер та Маргарита", "Михайло Булгаков", 1919);

        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }

}

package servlets;

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

        BookDAOJdbcImpl bookDAOJdbcImpl = new BookDAOJdbcImpl();
        ArrayList<Book> books = bookDAOJdbcImpl.getBooksByAuthor("Шкляр");

//        bookDAOJdbcImpl.addBook("Мастер та Маргарита", "Михайло Булгаков", 1919);

        req.setAttribute("books", books);

        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }

}

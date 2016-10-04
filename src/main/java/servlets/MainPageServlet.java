package servlets;

import dao.BookDAO;
import entities.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/")
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookDAO bookDAO = new BookDAO();
        ArrayList<Book> books = bookDAO.getBooksByDate(2014);

        req.setAttribute("name", books.get(0).getName());
        req.setAttribute("author", books.get(0).getAuthor());

        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }

}

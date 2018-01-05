package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mohammedshoeb on 11/28/17.
 */
@WebServlet(name = "Payment")
public class Payment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eztollamount = request.getParameter("addAmount");
        String username = request.getParameter("username");
        eztagcode eztagcode1 = new eztagcode();
        boolean test = eztagcode1.checkAddAmount(username, eztollamount);
        if(test == true) {

            request.setAttribute("username", username);
            request.getRequestDispatcher("/home.jsp").forward(request, response);

        }
        else {
            request.setAttribute("username", username);
            request.getRequestDispatcher("/error.jsp").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

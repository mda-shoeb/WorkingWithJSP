package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mohammedshoeb on 11/9/17.
 */
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("loginame");
        String password = request.getParameter("loginpassword");
        loginCheckBackend checkBackend = new loginCheckBackend();
        String checkResult = checkBackend.loginCheck(username, password);

        if(checkResult.equals(username)) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }


        if (username.equals("user") && password.equals("root")) {

            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/eZpass.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }


    }


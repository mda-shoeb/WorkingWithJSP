package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by mohammedshoeb on 11/10/17.
 */
@WebServlet(name = "Ezpass")
public class Ezpass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eztagcode = request.getParameter("eztagcode");
        String eztollplaza = request.getParameter("eztollplaza");
        String eztollamount = request.getParameter("eztollamount");
        String username = request.getParameter("username");
        PrintWriter printWriter = response.getWriter();
        eztagcode eztagcode1 = new eztagcode();
        try {
            boolean test = eztagcode1.checkAccountNumber(username, eztollamount);

            if(test == true) {
                transcation transcation = new transcation();
                boolean tranction = transcation.transcationToDB(eztagcode,eztollamount,eztollplaza);

                request.setAttribute("username", username);
                request.getRequestDispatcher("/home.jsp").forward(request, response);


            }
            else
                printWriter.println("Incomplete because of invalid EZ Tag Code or Insufficient Balance");




        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

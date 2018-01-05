package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mohammedshoeb on 12/11/17.
 */
@WebServlet(name = "SremovingVehcile")
public class SremovingVehcile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String eztagCode = request.getParameter("vehcileEZtagCode");
        removeVehcileByEzTagCode removeVehcileByEzTagCode = new removeVehcileByEzTagCode();
        boolean test =removeVehcileByEzTagCode.updatingDatabase(eztagCode);

            request.setAttribute("username", username);
            request.getRequestDispatcher("/home.jsp").forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

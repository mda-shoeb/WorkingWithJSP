package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by mohammedshoeb on 11/27/17.
 */
@WebServlet(name = "AddVehcile")
public class AddVehcile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vehcileEZtagCode = request.getParameter("vehcileEZtagCode");
        String vehcileLCNumber = request.getParameter("vehcileLCNumber");
        String vehcileDetails = request.getParameter("vehcileDetails");
        String username = request.getParameter("username");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            String Query4 = "INSERT INTO vehcile_details(username, eztagcode, lcnumber, details) VALUES (?,?,?,?)" ;
            PreparedStatement preparedStmt = conn.prepareStatement(Query4);
            preparedStmt.setString (1, username);
            preparedStmt.setString (2, vehcileEZtagCode);
            preparedStmt.setString(3, vehcileLCNumber);
            preparedStmt.setString(4, vehcileDetails);
            preparedStmt.execute();
            preparedStmt.close();

            conn.close();
            request.setAttribute("username", username);
            //request.setAttribute("vehcileDetails", vehcileDetails);


            request.getRequestDispatcher("/home.jsp").forward(request, response);



        } catch (Exception e) {}

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

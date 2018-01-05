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
 * Created by mohammedshoeb on 11/27/17.
 */
@WebServlet(name = "Signup")
public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String signupUsername = request.getParameter("signupUsername");
        String signupPassword = request.getParameter("signupPassword");
        String signupRePassword = request.getParameter("signupRepassword");
        String signupname = request.getParameter("signupName");


        if(signupPassword.equals(signupRePassword)) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
                /*String query3 = "SELECT username FROM user_details WHERE username = '" +signupUsername+"'";
                Statement statement3 = conn.createStatement();
                ResultSet rs =statement3.executeQuery(query3);

                while(rs.next()) {
                    String username = rs.getString("username");
                    printWriter.print(username);
                    if(username.equals("")) {*/
                        String Query4 = "INSERT INTO user_details(username, password, name, amount) VALUES (?,?,?,?)" ;
                        PreparedStatement preparedStmt = conn.prepareStatement(Query4);
                        preparedStmt.setString (1, signupUsername);
                        preparedStmt.setString (2, signupPassword);
                        preparedStmt.setString(3, signupname);
                        preparedStmt.setString(4,"100");
                        preparedStmt.execute();


                        preparedStmt.close();




                conn.close();
                request.setAttribute("username", signupUsername);

                request.getRequestDispatcher("/addVehcile.jsp").forward(request, response);
            }
            catch (Exception e) {

            }

        }

    }


}

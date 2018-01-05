package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by mohammedshoeb on 11/27/17.
 */
public class loginCheckBackend {
    public String loginCheck(String username, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            String query = " SELECT username FROM user_details " + " WHERE username ='" +username +"'" + " AND password ='"+password +"'" ;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                String result = resultSet.getString("username");
                return result;
            }

        }
        catch (Exception e) {}

        return "";
    }
}

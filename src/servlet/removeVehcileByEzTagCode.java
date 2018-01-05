package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by mohammedshoeb on 12/11/17.
 */
public class removeVehcileByEzTagCode {
    public boolean updatingDatabase(String eztagcode) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            String query = "DELETE from vehcile_details where eztagcode = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, eztagcode);

            // execute the preparedstatement
            preparedStmt.executeUpdate();

            conn.close();
        }
        catch (Exception e) {
            return false;
        }


        return true;
    }
}

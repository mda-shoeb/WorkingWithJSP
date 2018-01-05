package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by mohammedshoeb on 11/11/17.
 */
public class updateTest {


    public boolean updatingDatabase(String updateBalance, String accountNumber) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");


            String query2 = " UPDATE user_details SET amount ='" + updateBalance + "' where username = '" +accountNumber+"'";
            //UPDATE DBUSER SET USERNAME = 'mkyong_new'  WHERE USER_ID = 1
            //UPDATE ezaccountDetails SET currentBalance = "300" where accountNumber = "9876543210123"

            Statement statement2 = conn.createStatement();
            statement2.executeUpdate(query2);

            statement2.close();
            conn.close();
            return true;

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

}

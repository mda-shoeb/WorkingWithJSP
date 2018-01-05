package servlet;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mohammedshoeb on 11/11/17.
 */
public class eztagcode {


    public boolean checkAccountNumber(String username, String tollamount) {


        try {
            //Checks for AccountNumber
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            String query = " SELECT * FROM user_details " + " WHERE username ='" +username +"'" ;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int accountBalanceInt = Integer.parseInt(tollamount);
            if (resultSet.next()) {
                String queryBalance = resultSet.getString("amount");
                int queryBalanceInt = Integer.parseInt(queryBalance);
                String deductedBalanceS = "" + queryBalanceInt;

                if (queryBalanceInt > accountBalanceInt) {
                    int deductedBalance = queryBalanceInt - accountBalanceInt;
                    String deductedBalanceUpdate = ""+deductedBalance;
                    statement.close();
                    conn.close();
                    updateTest updateTest = new updateTest();
                    boolean updateTestresult =updateTest.updatingDatabase(deductedBalanceUpdate, username);
                    if(updateTestresult == true) {
                        return true;
                    }



                }


            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean checkAddAmount(String username, String tollamount) {


        try {
            //Checks for AccountNumber
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            String query = " SELECT * FROM user_details " + " WHERE username ='" +username +"'" ;
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int accountBalanceInt = Integer.parseInt(tollamount);
            if (resultSet.next()) {
                String queryBalance = resultSet.getString("amount");
                int queryBalanceInt = Integer.parseInt(queryBalance);


                    int deductedBalance = queryBalanceInt + accountBalanceInt;
                    String deductedBalanceUpdate = ""+deductedBalance;
                    statement.close();
                    conn.close();
                    updateTest updateTest = new updateTest();
                    boolean updateTestresult =updateTest.updatingDatabase(deductedBalanceUpdate, username);
                    if(updateTestresult == true) {
                        return true;
                    }






            }
        } catch (Exception e) {
        }
        return false;
    }
}
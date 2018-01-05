package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Created by mohammedshoeb on 11/12/17.
 */
public class transcation {

    public boolean transcationToDB(String eztagcode,String eztollamount,String eztollplaza) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());


            String query3 = " INSERT INTO transcation(dateTime,amount,tollplaza,type) VALUES ('"+ timestamp +"','"+ eztollamount +"','"+ eztollplaza +"','manual')";

            Statement statement3 = conn.createStatement();
            statement3.executeUpdate(query3);

            statement3.close();
            conn.close();
            return true;

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

    }


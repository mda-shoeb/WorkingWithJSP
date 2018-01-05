package servlet;

/**
 * Created by mohammedshoeb on 11/10/17.
 */
import java.sql.*;
public class test {
    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB", "root", "root");
            String query = " SELECT * from ezaccountDetails " + " WHERE accountNumber = 9876543210123";
            String accountNumber = "9876543210123";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            String accountBalance = "100";
            int accountBalanceInt = Integer.parseInt(accountBalance);
            if(resultSet.next()){
                String queryBalance = resultSet.getString("currentBalance");
                int queryBalanceInt = Integer.parseInt(queryBalance);
                String deductedBalanceS = ""+queryBalanceInt;
                System.out.println(queryBalance);
                if(queryBalanceInt > accountBalanceInt) {
                    int deductedBalance = queryBalanceInt - accountBalanceInt;
                    try {

                        String query2 = " UPDATE ezaccountDetails SET currentBalance ='" +deductedBalanceS + "' where accountNumber ='" +accountNumber+"'";
                        //UPDATE DBUSER SET USERNAME = 'mkyong_new'  WHERE USER_ID = 1
                        //UPDATE ezaccountDetails SET currentBalance = "300" where accountNumber = "9876543210123"

                        Statement statement2 = conn.createStatement();
                        ResultSet resultSet2 = statement2.executeQuery(query2);
                        if(resultSet2.next()) {
                            System.out.println("Successfully updated account");
                        }
                    }
                    catch (Exception e) {}

                }
            }
            //String currentBalance = resultSet.getString("currentBalance");



            conn.close();


        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
        }
    }
}

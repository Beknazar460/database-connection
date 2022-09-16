package week5;

import java.sql.*;

import static week5.JDBC.dbConnection;

public class User {

    static Statement dbStatment;
    static ResultSet resultSet;

    public static void signUpUser(String id, String age, String firstName, String lastName, String email, String phone) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_ID + "," + Const.USERS_AGE + "," + Const.USERS_FIRSTNAME + "," +
                Const.USERS_LASTNAME + "," + Const.USERS_EMAIL + "," + Const.USERS_PHONE + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = JDBC.getDbConnection().prepareStatement(insert);
            prSt.setString(1, id);
            prSt.setString(2, age);
            prSt.setString(3, firstName);
            prSt.setString(4, lastName);
            prSt.setString(5, email);
            prSt.setString(6, phone);


            prSt.executeUpdate();

            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void selectUser() {
        String select = "SELECT * FROM " + Const.USER_TABLE;

        try {
            dbStatment = JDBC.getDbConnection().createStatement();
            resultSet = dbStatment.executeQuery(select);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int age = resultSet.getInt(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                String email = resultSet.getString(5);
                String phone = resultSet.getString(6);

                System.out.printf("%d, %d, %s, %s, %s, %s%n", id, age, firstName, lastName, email, phone);
            }
            resultSet.close();
            dbStatment.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser() {
        String update = "UPDATE Users SET first_name = 'Kubatbek'";

        try {
            dbStatment = JDBC.getDbConnection().createStatement();
            dbStatment.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void removeUser() {
        String delete = "DELETE FROM Users WHERE id = 1";

        try {
            dbStatment = JDBC.getDbConnection().createStatement();
            dbStatment.executeUpdate(delete);

            dbStatment.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

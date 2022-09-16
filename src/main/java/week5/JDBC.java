package week5;

import java.sql.*;

public class JDBC extends Configs{
    static Connection dbConnection;
    static Statement dbStatment;
    static ResultSet resultSet;

    public static void main(String[] args) {
        User.signUpUser("1", "24", "Beknazar", "Abdykalykuulu", "beknazarabdykalykuulu@gmail.com", "+996555439317");
        User.selectUser();
        User.updateUser();
        User.selectUser();
        User.removeUser();
        User.selectUser();
    }
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/example";

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionUrl, DB_USER, DB_PASS);
        return dbConnection;
    }

}

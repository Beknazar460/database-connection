package week5;

import java.sql.*;

public class JDBC extends Configs{
    static Connection dbConnection;

    public static void main(String[] args) {
        User.signUpUser("1", "24", "Beknazar", "Abdykalykuulu", "beknazarabdykalykuulu@gmail.com", "+996555439317");
        User.selectUser();
        User.updateUser();
        User.selectUser();
        User.removeUser();
        User.selectUser();
    }

    //Connection to daata base
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionUrl = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionUrl, DB_USER, DB_PASS);
        return dbConnection;
    }

}

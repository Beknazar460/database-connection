import java.sql.*;

public class JDBC extends Configs{
    static Connection dbConnection;

    public static void main(String[] args) {
        signUpUser("1", "24", "Beknazar", "Abdykalykuulu", "beknazarabdykalykuulu@gmail.com", "+996555439317");
    }
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionUrl = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionUrl, DB_USER, DB_PASS);
        return dbConnection;
    }

    public static void signUpUser(String id, String age, String firstName, String lastName, String email, String phone) {
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" + Const.USERS_ID + "," + Const.USERS_AGE + "," + Const.USERS_FIRSTNAME + "," +
                                        Const.USERS_LASTNAME + "," + Const.USERS_EMAIL + "," + Const.USERS_PHONE + ")" +
                                        "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
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

}

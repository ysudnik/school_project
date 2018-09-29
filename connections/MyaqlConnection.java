package by.TeachMeSkills.school.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyaqlConnection {
    private static String url = "jdbc:mysql://localhost/school";
    private static String user = "root";
    private static String pass = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}

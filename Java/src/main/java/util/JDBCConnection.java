package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

public class JDBCConnection {

    public static Connection conn = null;
    public static Connection getConnection(){
        if (conn == null) {
            try{
                FileInputStream input = new FileInputStream(Objects.requireNonNull(JDBCConnection.class.getClassLoader().getResource
                        ("connection.properties")).getFile());
                InputStream input2 = JDBCConnection.class.getClassLoader().getResourceAsStream
                        ("connection.properties");

                Properties props = new Properties();
                props.load(input);

                String endpoint = props.getProperty("endpoint");
                String database = props.getProperty("database");
                String url = "jdbc:postgresql://" + endpoint + "/" + database;
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return conn;

    }
    public static void main(String[] args) {

        Connection conn1 = getConnection();
        Connection conn2 = getConnection();

        System.out.println(conn1);
        System.out.println(conn2);
    }
}

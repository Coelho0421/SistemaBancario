package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    public static Connection getConnection() throws Exception{
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        String user = "root";
        String senha = "";
        String urlBanco = "jdbc:mysql://localhost/sistemabancario";

        return DriverManager.getConnection(urlBanco, user, senha);
    }

    public static void closeConnection(Connection conn) throws Exception{
        conn.close();
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) throws Exception{
        conn.close();
        ps.close();
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) throws Exception{
        conn.close();
        ps.close();
        rs.close();
    }
}

package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connect = null;

    public static Connection getConnection(){
        if (connect == null){
            try{
                Properties props = loadProperties();
                String user = props.getProperty("user");
                String password = props.getProperty("password");
                String url = props.getProperty("dbUrl");

                connect = DriverManager.getConnection(url, user, password);
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return connect;
    }

    public static void closeConnection(){
        if(connect != null){
            try {
                connect.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static Properties loadProperties() {
        try (InputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }


    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}

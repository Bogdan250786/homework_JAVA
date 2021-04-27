package com.ISG.paramud.userJDBC;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class UserJDBC {

    static final String DATABASE_URL = "jdbc:mysql://localhost/db_phonebookapp";
    /**
     * User and Password to access the server
     */
    static final String USER = "Bogdan";
    static final String PASSWORD = "Bogdan3993!";
    /**
     * You can use this method for debugging to see if user was added to database
     */
    public static void showUsersJDBC() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM Users";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("\nUsers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
            System.out.println("================\n");
            System.out.println("id: " + id);
            System.out.println("login: " + login);
            System.out.println("password: " + password);
            System.out.println("================");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
    public static void addUsersJDBC(String log, String pass) throws
            ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "INSERT INTO db_phonebookapp.Users (login, password) \n" + "VALUES ('" + log +"', '" + pass +"');";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    /**
     * You can use this method for debugging to see your user's phonebook from database
     */
    public static void showUsersTable(String table) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM db_phonebookapp." + table;
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("\nContacts:");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");
            System.out.println("================\n");
            System.out.println("name: " + name);
            System.out.println("phone: " + phone);
            System.out.println("email: " + email);
            System.out.println("================");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
    public static void createUsersTable(String table) throws
            ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "CREATE TABLE " + table + " (\n" +
                "  id INT NOT NULL AUTO_INCREMENT,\n" +
                "  name VARCHAR(100) NOT NULL,\n" +
                "  phone VARCHAR(100) NOT NULL,\n" +
                "  email VARCHAR(100) NOT NULL,\n" +
                "  PRIMARY KEY (id));";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    public static void addContactJDBC(String table, String name, String phone, String email) throws
            ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "INSERT INTO db_phonebookapp." + table + " (name, phone, email) \n" +
                "VALUES ('" + name +"', '" + phone + "', '" + email + "');";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
    public static void removeContactJDBC(String table, String value) throws
            ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "DELETE FROM db_phonebookapp." + table + " WHERE name='" + value +"' OR phone='" +
                value + "' OR email='" + value + "';";
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }
}

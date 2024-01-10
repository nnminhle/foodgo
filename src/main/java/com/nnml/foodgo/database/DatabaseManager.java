package com.nnml.foodgo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseManager {

    public static String DEFAULT_FILENAME = "application";
    private static String DRIVER_VAR = "jdbc.driverClassName";
    private static String URL_VAR = "jdbc.url";
    private static String USERNAME_VAR = "jdbc.username";

    private static String PASSWORD_VAR = "jdbc.password";
    private static String DATABASE_VAR = "jdbc.database";

    private static ConnectionBean loadDriver() {
        return loadDriver(DEFAULT_FILENAME);
    }

    public static ConnectionBean loadDriver(String fileName) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DEFAULT_FILENAME);
        ConnectionBean connectionBean = new ConnectionBean();
        connectionBean.setDriverClassName(resourceBundle.getString(DRIVER_VAR));
        connectionBean.setUrl(resourceBundle.getString(URL_VAR));
        connectionBean.setUsername(resourceBundle.getString(USERNAME_VAR));
        connectionBean.setPassword(resourceBundle.getString(PASSWORD_VAR));
        connectionBean.setDatabase(resourceBundle.getString(DATABASE_VAR));
        return connectionBean;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        ConnectionBean connectionBean = DatabaseManager.loadDriver();
        Class.forName(connectionBean.getDriverClassName());
        return DriverManager.getConnection(
                connectionBean.getUrl(),
                connectionBean.getUsername(),
                connectionBean.getPassword()
        );
    }
}

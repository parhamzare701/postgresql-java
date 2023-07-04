package com.ada;

import java.sql.SQLException;
import java.sql.Statement;

public class UsersTable {
    public void createUsersTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE USERS " +
                "(" + "ID SERIAL PRIMARY KEY," +
                " NAME  VARCHAR(25) NOT NULL , " +
                " AGE INT NOT NULL )";
        statement.executeUpdate(sql);
    }

    public void addUser(Statement statement, String name, int age) throws SQLException {
        String sql = String.format("INSERT INTO USERS (NAME, AGE) VALUES ( '%s', %d);",
                 name, age);
        statement.executeUpdate(sql);
    }
}

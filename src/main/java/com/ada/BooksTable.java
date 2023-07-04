package com.ada;

import java.sql.*;
import java.time.LocalDate;

public class BooksTable {
    public void createBooksTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE BOOKS " +
                "(ID SERIAL PRIMARY KEY NOT NULL UNIQUE ," +
                "NAME VARCHAR(50) NOT NULL, " +
                "ASSIGNED INT NULL ," +
                "FOREIGN KEY (ASSIGNED) REFERENCES USERS(ID))";
        statement.executeUpdate(sql);
    }

    public void addBook(Statement statement, String name, int assigned) throws SQLException {
        String sql = String.format("INSERT INTO BOOKS (NAME, ASSIGNED) VALUES ('%s', %d);",
                name, assigned);
        statement.executeUpdate(sql);
    }
}

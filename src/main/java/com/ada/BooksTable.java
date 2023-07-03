package com.ada;

import java.sql.*;

public class BooksTable {
    public void createBooksTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE BOOKS " +
                "(ID SERIAL PRIMARY KEY," +
                "NAME TEXT NOT NULL, " +
                "ASSIGNED INT NOT NULL)";
        statement.executeUpdate(sql);
    }

    public void addBook(Statement statement, String name, int assigned) throws SQLException {
        String sql = String.format("INSERT INTO BOOKS (NAME, ASSIGNED) VALUES ('%s', %d);",
                name, assigned);
        statement.executeUpdate(sql);
    }

    public void addAssign(Statement statement, int rowNumber, String assigned) throws SQLException {
        String sql =  String.format("UPDATE BOOKS SET ASSIGNED='%s' WHERE ID=%d", assigned , rowNumber);
        int preparedStatement = statement.executeUpdate(sql , rowNumber);
        System.out.println(rowNumber);
        System.out.println(assigned);
    }
}

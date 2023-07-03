package com.ada;

import java.sql.SQLException;
import java.sql.Statement;

public class AssignedUsers {
    public void createAssignedUsersBook(Statement statement) throws SQLException {
        String sql = "CREATE TABLE ASSIGNEDUSERS " +
                "(ID SERIAL PRIMARY KEY," +
                "BOOKID INT NOT NULL," +
                " USERID INT NOT NULL)";
        statement.executeUpdate(sql);
    }

    public void addAssigned(Statement statement, int bookId, int assignedUsers) throws SQLException {
        String sql = String.format("INSERT INTO ASSIGNEDUSERS (BOOKID, USERID) VALUES (%d, %d);",
                bookId, assignedUsers);
        System.out.println(sql);
        statement.executeUpdate(sql);
    }
}

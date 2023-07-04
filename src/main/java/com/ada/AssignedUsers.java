package com.ada;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignedUsers {
    public void createAssignedUsersBook(Statement statement) throws SQLException {
        String sql = "CREATE TABLE ASSIGNEDUSERS " +
                "(ID SERIAL PRIMARY KEY NOT NULL UNIQUE ," +
                "BOOKID int not null ," +
                "USERID int not null ," +
                "FOREIGN KEY (BOOKID) REFERENCES BOOKS(ID)," +
                "FOREIGN KEY (USERID) REFERENCES USERS(ID))";
        statement.executeUpdate(sql);
    }

    public void addAssigned(Statement statement, int bookId, int assignedUsers) throws SQLException {
        String sql = String.format("INSERT INTO ASSIGNEDUSERS (BOOKID, USERID) VALUES (%d, %d);",
                bookId, assignedUsers);
        System.out.println(sql);
        statement.executeUpdate(sql);
    }

}

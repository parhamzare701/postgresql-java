package com.ada;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AssignedUsers {
    public void createAssignedUsersBook(Statement statement) throws SQLException {
        String sql = "CREATE TABLE ASSIGNEDUSERS " +
                "(ID SERIAL PRIMARY KEY NOT NULL UNIQUE ," +
                "BOOKID int not null ," +
                "USERID int not null ," +
                "GetDate VARCHAR(30) not null ," +
                "RefundDate VARCHAR(30) NULL ," +
                "FOREIGN KEY (BOOKID) REFERENCES BOOKS(ID)," +
                "FOREIGN KEY (USERID) REFERENCES USERS(ID))";
        statement.executeUpdate(sql);
    }

    public void addAssigned(Statement statement, int bookId, int assignedUsers, String refundDate) throws SQLException {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(date.format(now));
        String sql = String.format("INSERT INTO ASSIGNEDUSERS (BOOKID, USERID, GetDate, RefundDate) VALUES (%d, %d ,'%s', '%s');",
                bookId, assignedUsers, date.format(now), refundDate);
        System.out.println(sql);
        statement.executeUpdate(sql);
    }

}

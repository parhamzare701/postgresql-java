package com.ada;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        UsersTable usersTable = new UsersTable();
        BooksTable booksTable = new BooksTable();
        AssignedUsers assignedUsers = new AssignedUsers();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ArrayList<Integer> booksAssign = new ArrayList<Integer>();
        ArrayList<Integer> booksId = new ArrayList<Integer>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/test_db",
                            "e.amini", "root");
            statement = connection.createStatement();

            usersTable.createUsersTable(statement);
            booksTable.createBooksTable(statement);
            assignedUsers.createAssignedUsersBook(statement);

            usersTable.addUser(statement, "hosein", 30);
            usersTable.addUser(statement, "parham", 15);
            ResultSet usersResultSet = statement.executeQuery("select * from USERS;");
            while (usersResultSet.next()) {
                ids.add(usersResultSet.getInt("ID"));
            }
            booksTable.addBook(statement, "The Little Prince", ids.get(new Random().nextInt(ids.size())));
            booksTable.addBook(statement, "Night Flight", ids.get(new Random().nextInt(ids.size())));

            ResultSet bookResultSet = statement.executeQuery("select * from BOOKS;");
            while (bookResultSet.next()) {
                booksAssign.add(bookResultSet.getInt("ASSIGNED"));
                booksId.add(bookResultSet.getInt("ID"));
            }
            for (int i = 0; i < booksId.size(); i++) {
                System.out.println(booksAssign.get(i));
                System.out.println(booksId.get(i));
                assignedUsers.addAssigned(statement, booksId.get(i), booksAssign.get(i));
            }

            statement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println(exception.getClass().getName() + ": " + exception.getMessage());
            System.exit(0);
        }
    }
}
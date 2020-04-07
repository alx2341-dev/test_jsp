package com.adapters;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJDBC {

    public static Connection getContext() throws NamingException, SQLException {

        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = null;
        Connection conn = null;
        try {
            ds = (DataSource) envContext.lookup("jdbc/pooldb");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (envContext == null) {
            System.out.println("envcontext is null");
        }
        if (ds == null) {
            System.out.println("datasource is null");
        }
        if (ds != null){
            conn = ds.getConnection();
        }
        return conn;
    }

    public static void closeContext(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                ;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                ;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                ;
            }
        }
    }
}

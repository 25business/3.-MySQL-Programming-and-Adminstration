package com.example.utils;
import java.sql.*;
import java.util.HashMap;

public class Database {
    private static Connection conn = null;

    public static Connection connect() throws SQLException {
        if(Database.conn == null) {
            Database.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/movies?user=jadmin&password=1234");
        }
        return conn;
    }

    public static void disable_autocommit() throws SQLException {
        Connection connection = Database.connect();
        connection.setAutoCommit(false);
    }

    public static  void commit() throws SQLException {
        Connection connection = Database.connect();
        connection.commit();
    }

    public static void rollback() throws SQLException {
        Connection connection = Database.connect();
        connection.rollback();
    }

    public static void close() throws SQLException {
        Connection connection = Database.connect();
        connection.close();
        Database.conn = null;
    }

    public static int transactional_insert(String insert_query) throws SQLException {
        Connection conn = Database.connect();
        Statement st = conn.createStatement();
        int rows_affected = st.executeUpdate(insert_query, Statement.RETURN_GENERATED_KEYS);
        ResultSet generated_keys = st.getGeneratedKeys();
        if(generated_keys.next()) {
            return generated_keys.getInt(1);
        } else {
            return rows_affected;
        }
    }

    public static int transactional_update_delete(String sql_query) throws SQLException {
        Connection conn = Database.connect();
        Statement st = conn.createStatement();
        return st.executeUpdate(sql_query);
    }

    public static ResultSet get_data_result(String select_query) throws SQLException {
        Connection conn = Database.connect();
        Statement st = conn.createStatement();
        return st.executeQuery(select_query);
    }

    public static  int prepared_insert(String insert_sql, HashMap<Integer, Object> data) throws SQLException {
        Connection conn = Database.connect();
        PreparedStatement st = conn.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
        for(Integer i : data.keySet()) {
            st.setObject(i, data.get(i));
        }
        int affected_rows = st.executeUpdate();
        ResultSet generated_keys = st.getGeneratedKeys();
        if(generated_keys.next()) {
            return generated_keys.getInt(1);
        } else {
            return affected_rows;
        }
    }
    public static  int prepared_update_delete(String string_sql, HashMap<Integer, Object> data) throws SQLException {
        Connection conn = Database.connect();
        PreparedStatement st = conn.prepareStatement(string_sql);
        for(Integer i : data.keySet()) {
            st.setObject(i, data.get(i));
        }
        return st.executeUpdate();
    }
}

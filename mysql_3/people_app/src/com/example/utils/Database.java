package com.example.utils;
import java.sql.*;

public class Database {

    public static Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/m3_test?user=jadmin&password=1234");
        return conn;
    }

    public static int execute_update_delete(String sql_query) throws SQLException {
        Connection conn = Database.connect();
        Statement st = conn.createStatement();
        return st.executeUpdate(sql_query);
    }

    public static int execute_insert(String insert_query) throws SQLException {
        Connection conn = Database.connect();
        Statement st = conn.createStatement();
        int rows_affected = st.executeUpdate(insert_query, Statement.RETURN_GENERATED_KEYS);
        if(rows_affected > 0) {
            ResultSet generated_keys = st.getGeneratedKeys();
            generated_keys.next();
            // !!! Vazi samo ako je PK kolona Auto Increment !!!
            return generated_keys.getInt(1);
        } else {
            return 0;
        }
    }

    public static ResultSet get_data_result(String select_query) throws SQLException {
        Connection conn = Database.connect();
        Statement st = conn.createStatement();
        return st.executeQuery(select_query);
    }
}

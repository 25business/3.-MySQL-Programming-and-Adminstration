package com.example.people;
import com.example.utils.Input;
import com.example.utils.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPerson {
    public static Person LOGGED_IN = null;

    public static void login_form() throws SQLException {
        String username = Input.read_string("Enter username: ");
        String password = Input.read_string("Enter password: ");

        ResultSet rs = Database.get_data_result(String.format("""
                SELECT * FROM people
                WHERE username = "%s" AND password = "%s"
                """, username, password));
        if(rs.next()) {
            LOGGED_IN = new Person();
            LOGGED_IN.setId(rs.getInt("id"));
            LOGGED_IN.setFirst_name(rs.getString("first_name"));
            LOGGED_IN.setLast_name(rs.getString("last_name"));
            LOGGED_IN.setUsername(rs.getString("username"));
            LOGGED_IN.setPassword(rs.getString("password"));
            LOGGED_IN.setFor_deletion(rs.getInt("for_deletion"));
            LOGGED_IN.setDeletion_date(rs.getInt("deletion_date"));
            System.out.println("You have successfully logged in!");
        } else {
            System.err.println("Username and/or password are invalid.");
        }
    }

    public static void logout() {
        System.out.println("You have successfully logged out!");
        LOGGED_IN = null;
    }
}

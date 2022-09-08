package com.example.people;
import com.example.utils.Input;
import com.example.utils.Database;

import java.sql.SQLException;

public class RegisterPerson {

    public static int registration_form() throws SQLException {
        String first_name = Input.read_string("Enter first name:");
        String last_name = Input.read_string("Enter last name:");
        String username = Input.read_string("Enter username:");
        String password = Input.read_string("Enter password:");
        int inserted_id = Database.execute_insert(String.format("""
                INSERT INTO people (first_name, last_name, username, password)
                VALUES ("%s","%s","%s","%s");
                """, first_name, last_name, username, password));
        return inserted_id;
    }
}

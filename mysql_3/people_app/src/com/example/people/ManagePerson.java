package com.example.people;
import com.example.utils.Input;
import com.example.utils.Database;

import java.sql.SQLException;

public class ManagePerson {

    public static int delete_data() throws SQLException {
        int id = Input.read_int("Enter user ID:");
        int affected_rows = Database.execute_update_delete(String.format("""
                DELETE FROM people WHERE id = %d;""", id));
        return affected_rows;
    }
    public static int deactivate_account(int id) throws SQLException {
        //int id = Input.read_int("Enter user ID:");
        int affected_rows = Database.execute_update_delete(String.format("""
            UPDATE people SET for_deletion=1, deletion_date=CURRENT_TIMESTAMP()
            WHERE id = %d
        """, id));
        return affected_rows;
    }
}

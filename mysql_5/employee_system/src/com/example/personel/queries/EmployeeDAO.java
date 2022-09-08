package com.example.personel.queries;

import com.example.personel.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.utils.Database;

public class EmployeeDAO {

    public static Employee get(int key) throws SQLException {
        ResultSet rs = Database.get_data_result(String.format("""
                SELECT * FROM employees WHERE employees_id = %d
                """, key));
        if(rs.next()) {
            Employee e = new Employee();
            e.setEmployees_id(rs.getInt("employees_id"));
            e.setFirst_name(rs.getString("first_name"));
            e.setLast_name(rs.getString("last_name"));
            e.setEmail(rs.getString("email"));
            return e;
        } else {
            return null;
        }
    }

    public static int save(Employee employee) {
        int return_result = -1;
        try {
            Database.disable_autocommit();
            int inserted_id = Database.transactional_insert(String.format("""
                            INSERT INTO employees VALUES(NULL,"%s","%s","%s")
                            """, employee.getFirst_name(),
                    employee.getLast_name(), employee.getEmail()));
            Database.commit();
            return_result = inserted_id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }

    public static int prepared_update(Employee employee) {
        int return_result = -1;
        try {
            Database.disable_autocommit();
            String prepared_sql = """
                    UPDATE employees SET first_name = ?,
                    last_name = ?, email = ?
                    WHERE employees_id = ?""";
            HashMap<Integer, Object> employee_map = new HashMap<>();
            employee_map.put(1, employee.getFirst_name());
            employee_map.put(2, employee.getLast_name());
            employee_map.put(3, employee.getEmail());
            employee_map.put(4, employee.getEmployees_id());
            return_result = Database.prepared_update_delete(prepared_sql, employee_map);
            Database.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }

    public static int prepared_save(Employee employee) {
        int return_result = -1;
        try {
            Database.disable_autocommit();
            String prepared_sql = "INSERT INTO employees VALUES(NULL, ?, ?, ?);";
            HashMap<Integer, Object> employee_map = new HashMap<>();
            employee_map.put(1, employee.getFirst_name());
            employee_map.put(2, employee.getLast_name());
            employee_map.put(3, employee.getEmail());
            return_result = Database.prepared_insert(prepared_sql, employee_map);
            Database.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }
    public static int prepared_delete(Employee employee) {
        int return_result = -1;
        try {
            Database.disable_autocommit();
            String prepared_sql = "DELETE FROM employees WHERE employees_id = ?";
            HashMap<Integer, Object> employee_map = new HashMap<>();
            employee_map.put(1, employee.getEmployees_id());
            return_result = Database.prepared_update_delete(prepared_sql, employee_map);
            Database.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }

    public static int update(Employee employee) {
        int return_result = -1;
        try {
            int affected_rows = Database.transactional_update_delete(String.format("""
                            UPDATE employees SET first_name = "%s",
                            last_name = "%s", email = "%s"
                            WHERE employees_id = %d
                            """, employee.getFirst_name(), employee.getLast_name(),
                    employee.getEmail(), employee.getEmployees_id()));
            return_result = affected_rows;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }

    public static int delete(Employee employee) throws SQLException {
        int return_result = -1;
        try {
        int rows_affected = Database.transactional_update_delete(String.format("""
                DELETE FROM employees WHERE employees_id = %d
                """, employee.getEmployees_id()));
        return_result = rows_affected;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }

    public static ArrayList<Employee> all() throws SQLException {
        ResultSet rs = Database.get_data_result(String.format("""
                SELECT * FROM employees"""));
        ArrayList<Employee> employees = new ArrayList();
        while(rs.next()) {
            Employee e = new Employee();
            e.setEmployees_id(rs.getInt("employees_id"));
            e.setFirst_name(rs.getString("first_name"));
            e.setLast_name(rs.getString("last_name"));
            e.setEmail(rs.getString("email"));
            employees.add(e);
        }
        return employees;
    }

    public static int save_all_info(HashMap<String, Object> employee_data) {
        int return_result = -1;
        try {
            Database.disable_autocommit();
            int new_id = Database.transactional_insert(String.format("""
                            INSERT INTO employees VALUES(NULL,"%s","%s","%s")
                            """, employee_data.get("first_name"),
                    employee_data.get("last_name"),
                    employee_data.get("email")));
            int employment_id = Database.transactional_insert(String.format("""
                            INSERT INTO employments VALUES(NULL, %d, '%s', NULL, '%s');""",
                    new_id, employee_data.get("start_date"), employee_data.get("contract_type")));
            int employees_id = Database.transactional_insert(String.format("""
                            INSERT INTO employees_departments VALUES(%d, %d);""",
                    new_id, employee_data.get("departments_id")));
            Database.commit();
            return_result = employees_id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try { Database.rollback(); } catch (SQLException exception) {}
        } finally {
            try { Database.close(); } catch (SQLException ex) {}
        }
        return return_result;
    }
}

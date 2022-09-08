package com.example;
import java.sql.*;

public class Program {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(System.getenv("M4_EMPLOYEE_SYSTEM_CONNECTION_STRING"),
                    System.getenv("MYSQL_JAVA_ADMIN"), System.getenv("MYSQL_JAVA_PWD"));
            /*Statement s1 = conn.createStatement();
            ResultSet rs1 = s1.executeQuery("CALL get_employees_with_salary_larger_than_avg()");
            while(rs1.next()) {
                System.out.println(rs1.getString("first_name"));
                System.out.println(rs1.getString("last_name"));
                System.out.println(rs1.getDouble("payment"));
                System.out.println("--------------");
            }*/
            /*
            PreparedStatement s2 = conn.prepareStatement("CALL get_employees_hired_after(?)");
            s2.setString(1,"2012-01-01");
            ResultSet rs2 = s2.executeQuery();
            while(rs2.next()) {
                System.out.println(rs2.getString("first_name"));
                System.out.println(rs2.getString("last_name"));
                System.out.println(rs2.getDate("start_date"));
                System.out.println("--------------");
            }
             */
            /*
            Statement s3 = conn.createStatement();
            ResultSet rs3 = s3.executeQuery("SELECT * FROM all_active_employee_details");
            while(rs3.next()) {
                System.out.println(rs3.getString("first_name"));
                System.out.println(rs3.getString("last_name"));
                System.out.println(rs3.getDate("start_date"));
                System.out.println(rs3.getDouble("avg_salary"));
                System.out.println("--------------");
            }*/
            PreparedStatement s4 = conn.prepareStatement("CALL new_employee(?,?,?,?)");
            s4.setString(1,"Test");
            s4.setString(2,"Test");
            s4.setString(3,"test@test.com");
            s4.setInt(4,3);
            ResultSet rs4 = s4.executeQuery();
            if(rs4.next()) {
                System.out.println(rs4.getInt(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

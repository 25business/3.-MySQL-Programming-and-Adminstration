package com.example;
import java.sql.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/m2_baza?user=jadmin&password=1234");
        Scanner input = new Scanner(System.in);
        /*
        System.out.println("Choose starting letter for people: ");
        String letter = input.nextLine();
        String sql = String.format("""
        SELECT * FROM people WHERE first_name LIKE '%s%%';
        """, letter);
        System.out.println(sql);
        */


        /*
        System.out.println("Enter start year: ");
        String start_year = input.nextLine();
        System.out.println("Enter end year: ");
        String end_year = input.nextLine();

        // 1980-01-01      1990-12-31
        start_year += "-01-01";
        end_year += "-12-31";
        String sql = String.format("""
                SELECT * FROM people 
                WHERE birthday >= '%s' AND birthday <= '%s';
                """, start_year, end_year);
        System.out.println(sql);
         */

        // Sve osobe ciji se email zavrsava na domen koji zadaje korisnik
        System.out.println("Enter a domain");
        String domain = input.nextLine();
        String sql = String.format("""
                SELECT * FROM people 
                WHERE email LIKE '%%%s';
                """, domain);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            int people_id = rs.getInt("people_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");
            Date birthday = rs.getDate("birthday");
            System.out.printf("[%d] %s %s %s %s\n", people_id,
                    first_name, last_name, email, birthday);
        }
    }
}

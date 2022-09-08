package com.example;
import java.sql.SQLException;
import com.example.people.RegisterPerson;
import com.example.people.LoginPerson;
import com.example.people.ManagePerson;
import com.example.utils.Input;

/*
*  TODO: Conversion TIMESTAMP u INT
*  TODO: Update podataka korisnika kao opcija
*  TODO: Izdvojiti delove u podprogram
* */


public class Program {
    public static void main(String[] args) {
        try {
            while(true) {
               String option = MainMenu.option();
               if(option.equals("1")) {
                   LoginPerson.login_form();

                   if(LoginPerson.LOGGED_IN != null) {
                       // OVDE IDE PODMENI!
                       while(true) {
                           System.out.println("""
                           --- USER LOGGED IN --
                           [1] Deactivate account
                           [2] Logout
                           """);
                           String submenu_option = Input.read_string("Your choice:");
                           if(submenu_option.equals("1")) {
                               int affected_rows = ManagePerson.deactivate_account(LoginPerson.LOGGED_IN.getId());
                               if(affected_rows > 0) {
                                   System.out.println("You have successfully deactivated your account.");
                                   LoginPerson.LOGGED_IN = null;
                                   break;
                               } else {
                                   System.err.println("Oops! Something went wrong with deactivation. Blame the developer.");
                               }
                           } else if(submenu_option.equals("2")) {
                               LoginPerson.logout();
                               break;
                           } else {
                               System.err.println("Invalid option!");
                           }
                       }
                   }
               } else if(option.equals("2")) {
                   RegisterPerson.registration_form();
               } else if(option.toUpperCase().equals("Q")) {
                   break;
               } else {
                   System.err.println("Invalid option!");
               }
            }
       } catch(SQLException ex) {
            ex.printStackTrace();
       }
    }
}

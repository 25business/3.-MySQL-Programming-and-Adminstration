package com.example;
import com.example.utils.Input;

public class MainMenu {
    public static String option() {
        System.out.println("""
                --- PEOPLE APPLICATION ---
                [1] Login
                [2] Register
                [Q] Quit""");
        return Input.read_string("Your choice: ");
    }
}

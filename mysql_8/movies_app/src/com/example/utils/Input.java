package com.example.utils;
import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static String read_string(String message) {
        System.out.println(message);
        return input.nextLine();
    }

    public static int read_int(String message) {
        System.out.println(message);
        return Integer.parseInt(input.nextLine());
    }
}

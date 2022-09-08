package com.example;

import com.example.data.Movie;
import com.example.data.MovieDAO;
import com.example.utils.Database;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Movie> movies = MovieDAO.get_for_genre("Action");
        //ArrayList<Movie> movies = MovieDAO.get_for_country("Canada");
        //ArrayList<Movie> movies = MovieDAO.get_names_for_phrase("battle");
        for(Movie m : movies) {
            System.out.println(m.basic_info());
        }
        /*Movie m = MovieDAO.get(5491);
        System.out.println(m.basic_info());*/
    }
}

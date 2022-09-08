package com.example;

import com.example.data.Movie;
import com.example.data.MovieDAO;
import com.example.ui.MoviePagination;
import com.example.utils.Database;
import com.example.utils.QueryBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //ArrayList<Movie> movies = MovieDAO.get_for_genre("Action");
        //ArrayList<Movie> movies = MovieDAO.get_for_country("Canada");
        //ArrayList<Movie> movies = MovieDAO.get_names_for_phrase("battle");
        //ArrayList<Movie> movies = MovieDAO.get_all();
        /*for(Movie m : movies) {
            System.out.println(m.basic_info());
        }*/
        /*Movie m = MovieDAO.get(5491);
        System.out.println(m.basic_info());*/

        /*
        * PAGE 1 / 28 (total: 4803)
        * -- ---
        * View next (N)  View previous (P)  Quit view (Q)
        * */

        /*

        int total_movies = MovieDAO.total_movies();
        MoviePagination mp = new MoviePagination(total_movies, 25);
        String option = "";
        Scanner input = new Scanner(System.in);
        do {
            System.out.println(mp.console_header());
            System.out.println("-------------------------------");
            for(Movie m : mp.get_movies()) {
                System.out.println(m.basic_info());
            }
            System.out.println("-------------------------------");
            System.out.println("[View next (N) Jump to(J)  View previous (P)  Quit view (Q)]");
            option = input.nextLine();
            if(option.toUpperCase().equals("N"))
                mp.next_page();
            else if(option.toUpperCase().equals("P"))
                mp.previous_page();
            else if(option.toUpperCase().equals("J")) {
                System.out.print("Enter page number:  ");
                int page_number = Integer.parseInt(input.nextLine());
                mp.jump_to(page_number);
            } else if(!option.toUpperCase().equals("Q"))
                System.err.println("Invalid option: " + option);
        } while(!option.toUpperCase().equals("Q"));
         */

        QueryBuilder qb = new QueryBuilder();
        qb.select("title, release_date")
          .from("movie")
          .where("title", "LIKE", "%battle%")
          .and("release_date", ">", "1990-01-01")
          .and("release_date", "<", "2020-01-01")
          .or("budget", ">", 1000000)
          .order_asc("title")
          .order_desc("release_date")
          .limit(10,25);
        System.out.println(qb);

        QueryBuilder qb2 = new QueryBuilder();
        qb2.update("movie")
                .set("release_date","2015-01-01")
                .set("title","Random title")
                .where("movie_id","=",3006);
        System.out.println(qb2);

        QueryBuilder qb3 = new QueryBuilder();
        qb3.insert_into("movie").column_value("title", "Random")
                .column_value("release_date", "2021-01-01");
        System.out.println(qb3);

    }
}

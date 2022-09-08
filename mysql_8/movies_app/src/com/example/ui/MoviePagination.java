package com.example.ui;

import com.example.data.Movie;
import com.example.data.MovieDAO;

import java.util.ArrayList;

public class MoviePagination {
    private int current_page;
    private int total_pages;
    private int results_per_page;
    private int total_results;

    public MoviePagination(int total_results, int results_per_page) {
        this.current_page = 0;
        this.total_results = total_results;
        this.results_per_page = results_per_page;
        double tmp_tp = total_results / (double)results_per_page;
        this.total_pages = (int)Math.ceil(tmp_tp);
    }

    public ArrayList<Movie> get_movies() {
        return MovieDAO.get_for_range(current_page * results_per_page, results_per_page);
    }
    public void next_page() {
        if(this.current_page < this.total_pages)
            this.current_page++;
    }
    public void previous_page() {
        if(this.current_page > 0)
            this.current_page--;
    }

    public void jump_to(int page_number) {
        if(page_number > 0 && page_number <= total_pages) {
            this.current_page = page_number-1;
        } else {
            System.err.println("Invalid page number.");
        }
    }

    public String console_header() {
        return String.format("PAGE %d / %d (total: %d)", current_page+1, total_pages, total_results);
    }
}

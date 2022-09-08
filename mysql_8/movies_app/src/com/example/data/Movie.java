package com.example.data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Movie {
    private int movie_id;
    private String title;
    private int budget;
    private String homepage;
    private String overview;
    private double popularity;
    private LocalDate release_date;
    private long revenue;
    private int runtime;
    private String movie_status;
    private String tagline;
    private double vote_average;
    private int vote_count;

    public Movie(HashMap<String, Object> movie_map) {
        this.movie_id = (int)movie_map.get("movie_id");
        if(movie_map.containsKey("title"))
            this.title = (String) movie_map.get("title");
        if(movie_map.containsKey("budget"))
            this.budget = (int) movie_map.get("budget");
        if(movie_map.containsKey("homepage"))
            this.homepage = (String) movie_map.get("homepage");
        if(movie_map.containsKey("overview"))
            this.overview = (String) movie_map.get("overview");
        if(movie_map.containsKey("popularity"))
            this.popularity = (double) movie_map.get("popularity");
        if(movie_map.containsKey("release_date")) {
            Date release_date = (Date) movie_map.get("release_date");
            this.release_date = release_date.toLocalDate();
        }
        if(movie_map.containsKey("revenue"))
            this.revenue = (long)movie_map.get("revenue");
        if(movie_map.containsKey("runtime"))
            this.runtime = (int)movie_map.get("runtime");
        if(movie_map.containsKey("movie_status"))
            this.movie_status = (String) movie_map.get("movie_status");
        if(movie_map.containsKey("tagline"))
            this.tagline = (String) movie_map.get("tagline");
        if(movie_map.containsKey("vote_average"))
            this.vote_average = (double) movie_map.get("vote_average");
        if(movie_map.containsKey("vote_count"))
            this.vote_count = (int) movie_map.get("vote_count");
    }

    public String basic_info() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[" + this.movie_id + "] ");
        if(this.title != null)
            stringBuilder.append(this.title + " ");
        if(this.release_date != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("Y");
            stringBuilder.append(release_date.format(dtf));
        }
        return stringBuilder.toString();
    }

}
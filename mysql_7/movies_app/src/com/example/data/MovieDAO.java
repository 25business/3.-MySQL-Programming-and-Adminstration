package com.example.data;

import com.example.utils.Database;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class MovieDAO {

    private static Movie resultSet_toMovie(ResultSet rs) {
        HashMap<String, Object> movie_map = new HashMap<>();
        try {
            movie_map.put("movie_id", rs.getInt("movie_id"));
        }catch (Exception ex) {}
        try {
            movie_map.put("title", rs.getString("title"));
        } catch (Exception ex) {}
        try {
            movie_map.put("budget", rs.getInt("budget"));
        }catch (Exception ex) {}
        try {
            movie_map.put("homepage", rs.getString("homepage"));
        }catch (Exception ex) {}
        try {
            movie_map.put("overview", rs.getString("overview"));
        }catch (Exception ex) {}
        try {
            movie_map.put("popularity", rs.getDouble("popularity"));
        }catch (Exception ex) {}
        try {
            movie_map.put("release_date", rs.getDate("release_date"));
        }catch (Exception ex) {}
        try {
            movie_map.put("revenue", rs.getLong("revenue"));
        }catch (Exception ex) {}
        try {
            movie_map.put("runtime", rs.getInt("runtime"));
        }catch (Exception ex) {}
        try {
            movie_map.put("movie_status", rs.getString("movie_status"));
        }catch (Exception ex) {}
        try {
            movie_map.put("tagline", rs.getString("tagline"));
        }catch (Exception ex) {}
        try {
            movie_map.put("vote_average", rs.getDouble("vote_average"));
        }catch (Exception ex) {}
        try {
            movie_map.put("vote_count", rs.getInt("vote_count"));
        }catch (Exception ex) {}
        return new Movie(movie_map);
    }

    private static ArrayList<Movie> get_for_query(String query) {
        ArrayList<Movie> results = new ArrayList<>();
        try {
            ResultSet rs = Database.get_data_result(query);
            while(rs.next()) {
                results.add(resultSet_toMovie(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public static ArrayList<Movie> get_for_genre(String genre_name) {
        return get_for_query(String.format("CALL get_movies_for_genre('%s')",
                genre_name));
    }
    public static ArrayList<Movie> get_for_country(String country_name) {
        return get_for_query(String.format("CALL get_movies_for_country('%s')",
                country_name));
    }

    public static ArrayList<Movie> get_names_for_phrase(String phrase) {
        return get_for_query(String.format("SELECT movie_id, title, release_date FROM movie WHERE title LIKE '%%%s%%'", phrase));
    }

    public static Movie get(int id) {
        try {
            ResultSet rs = Database.get_data_result(
                    String.format("SELECT * FROM movie WHERE movie_id = %d",
                            id)
            );
            if(rs.next()) {
                return resultSet_toMovie(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

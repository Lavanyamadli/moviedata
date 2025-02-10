package com;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MovieDataManager {
    private Map<Integer, Movie> movies = new HashMap<>();
    private Map<Integer, Actor> actors = new HashMap<>();
    private Map<Integer, Director> directors = new HashMap<>();

    // Load movies from CSV
    public void loadMoviesFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Acer\\OneDrive\\Desktop\\java1stday\\Management\\data\\movies.csv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int movieId = Integer.parseInt(data[0].trim().replace("\"", ""));
                String title = data[1].trim().replace("\"", "");
                int releaseYear = Integer.parseInt(data[2].trim().replace("\"", ""));
                String genre = data[3].trim().replace("\"", "");
                double rating = Double.parseDouble(data[4].trim().replace("\"", ""));
                int duration = Integer.parseInt(data[5].trim().replace("\"", ""));
                int directorId = Integer.parseInt(data[6].trim().replace("\"", ""));
                int actorId = Integer.parseInt(data[7].trim().replace("\"", ""));

                Movie movie = new Movie(movieId, title, releaseYear, genre, rating, duration, directorId, actorId);
                movies.put(movieId, movie);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading movie data: " + e.getMessage());
        }
    }


    // Load actors from CSV
    public void loadActorsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Acer\\OneDrive\\Desktop\\java1stday\\Management\\data\\actors.csv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int actorId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                // Corrected: Assuming CSV format: actorId, name, dateOfBirth, nationality
                String dateOfBirth = data[2].trim();
                String nationality = data[3].trim();

                Actor actor = new Actor(name, actorId, dateOfBirth, nationality);
                actors.put(actorId, actor);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading actor data: " + e.getMessage());
        }
    }

    // Load directors from CSV
    public void loadDirectorsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Acer\\OneDrive\\Desktop\\java1stday\\Management\\data\\directors.csv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int directorId = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                String nationality = data[2].trim();
                String dateOfBirth = data[3].trim();

                Director director = new Director(directorId, name, nationality, dateOfBirth);
                directors.put(directorId, director);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading director data: " + e.getMessage());
        }
    }

    // Get Movie by ID or Title
    public Movie getMovie(String idOrTitle) {
        return movies.values().stream()
                .filter(m -> String.valueOf(m.getMovieId()).equalsIgnoreCase(idOrTitle)
                        || m.getTitle().equalsIgnoreCase(idOrTitle))
                .findFirst()
                .orElse(null);
    }

    // Get Top 10 Rated Movies
    public List<Movie> getTop10Movies() {
        return movies.values().stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // Get Movies by Genre
    public List<Movie> getMoviesByGenre(String genre) {
        return movies.values().stream()
                .filter(movie -> movie.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // Get Movies by Director
    public List<Movie> getMoviesByDirector(String directorName) {
        return movies.values().stream()
                .filter(movie -> directors.containsKey(movie.getDirectorId()) &&
                        directors.get(movie.getDirectorId()).getName().equalsIgnoreCase(directorName))
                .collect(Collectors.toList());
    }

    // Get Movies by Release Year
    public List<Movie> getMoviesByYear(int year) {
        return movies.values().stream()
                .filter(movie -> movie.getReleaseYear() == year)
                .collect(Collectors.toList());
    }

    // Add a New Movie
    public void addMovie(Movie movie) {
        movies.put(movie.getMovieId(), movie);
    }

    // Update Movie Rating
    public void updateMovieRating(int movieId, double newRating) {
        Movie movie = movies.get(movieId);
        if (movie != null) {
            movie.setRating(newRating);
        }
    }

    // Delete a Movie
    public void deleteMovie(int movieId) {
        movies.remove(movieId);
    }

    // Get Sorted Movies by Release Year (limit to 15)
    public List<Movie> getSortedMoviesByYear() {
        return movies.values().stream()
                .sorted(Comparator.comparingInt(Movie::getReleaseYear))
                .limit(15)
                .collect(Collectors.toList());
    }
}

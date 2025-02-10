package com;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieDataManager manager = new MovieDataManager();
        // Ensure the CSV files are in your working directory or update the paths accordingly.
        manager.loadMoviesFromCSV("movies.csv");
        manager.loadActorsFromCSV("actors.csv");
        manager.loadDirectorsFromCSV("directors.csv");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Data Management System");
            System.out.println("1. Get Movie Information");
            System.out.println("2. Get Top 10 Rated Movies");
            System.out.println("3. Get Movies by Genre");
            System.out.println("4. Get Movies by Director");
            System.out.println("5. Get Movies by Release Year");
            System.out.println("6. Add a New Movie");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Delete a Movie");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie ID or Title: ");
                    String idOrTitle = scanner.nextLine();
                    Movie movie = manager.getMovie(idOrTitle);
                    System.out.println(movie != null ? movie : "Movie not found.");
                    break;

                case 2:
                    List<Movie> topMovies = manager.getTop10Movies();
                    topMovies.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    manager.getMoviesByGenre(genre).forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter Director Name: ");
                    String director = scanner.nextLine();
                    manager.getMoviesByDirector(director).forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Release Year: ");
                    int year = scanner.nextInt();
                    manager.getMoviesByYear(year).forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Enter details for the new movie:");
                    System.out.print("Movie ID: ");
                    int movieId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Release Year: ");
                    int releaseYear = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Genre: ");
                    String movieGenre = scanner.nextLine();
                    System.out.print("Rating: ");
                    double rating = scanner.nextDouble();
                    System.out.print("Duration: ");
                    int duration = scanner.nextInt();
                    System.out.print("Director ID: ");
                    int directorId = scanner.nextInt();
                    System.out.print("Actor ID: ");
                    int actorId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    manager.addMovie(new Movie(movieId, title, releaseYear, movieGenre, rating, duration, directorId, actorId));
                    System.out.println("Movie added successfully.");
                    break;

                case 7:
                    System.out.print("Enter Movie ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Rating: ");
                    double newRating = scanner.nextDouble();
                    manager.updateMovieRating(updateId, newRating);
                    System.out.println("Movie rating updated successfully.");
                    break;

                case 8:
                    System.out.print("Enter Movie ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteMovie(deleteId);
                    System.out.println("Movie deleted successfully.");
                    break;

                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
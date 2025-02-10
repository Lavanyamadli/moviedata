package com;

public class Movie {
    private int movieId;
    private String title;
    private int releaseYear;
    private String genre;
    private double rating;
    private int duration;
    private int directorId;
    private int actorIds;


    public Movie(int movieId, String title, int releaseYear, String genre, double rating, int duration, int directorId, int actorIds) {
        this.movieId = movieId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.directorId = directorId;
        this.actorIds = actorIds;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getActorIds() {
        return actorIds;
    }

    public void setActorIds(int actorIds) {
        this.actorIds = actorIds;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                ", directorId=" + directorId +
                ", actorIds=" + actorIds +
                ", movieId=" + movieId +
                '}';
    }
}

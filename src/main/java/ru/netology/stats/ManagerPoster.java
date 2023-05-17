package ru.netology.stats;

public class ManagerPoster {

    private int maxMovies;

    public ManagerPoster() {
        this.maxMovies = 5;
    }

    public ManagerPoster(int maxMovies) {
        this.maxMovies = maxMovies;
    }

    public Poster[] movies = new Poster[0];

    public void addMovie(Poster movie) {
        Poster[] newMovies = new Poster[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    public Poster[] findAll() {
        return movies;
    }

    public Poster[] findLast() {
        int resultLength;
        if (movies.length < maxMovies) {
            resultLength = movies.length;
        } else {
            resultLength = maxMovies;
        }
        Poster[] newMovie = new Poster[resultLength];
        for (int i = 0; i < newMovie.length; i++) {
            newMovie[i] = movies[movies.length - 1 - i];
        }
        return newMovie;
    }
}

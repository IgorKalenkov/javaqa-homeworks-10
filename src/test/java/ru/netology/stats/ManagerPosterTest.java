package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerPosterTest {
    Poster movie1 = new Poster(1, "Бладшот", "боевик", "картинка1");
    Poster movie2 = new Poster(2, "Вперёд", "Бладшот", "картинка2");
    Poster movie3 = new Poster(3, "Отель Белград", "комедия", "картинка3");
    Poster movie4 = new Poster(4, "Джентльмены", "боевик", "картинка4");
    Poster movie5 = new Poster(5, "Челорвек-невидимка", "ужасы", "картинка5");
    Poster movie6 = new Poster(6, "Тролли. Мировой тур", "мультфильм", "картинка6");
    Poster movie7 = new Poster(7, "Номер один", "комедия", "картинка6");


    @Test
    public void shouldFindAllMovies() {
        ManagerPoster manager = new ManagerPoster();

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);

        Poster[] expected = {movie1, movie2, movie3};
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesEqualToLimit() {
        ManagerPoster managerLimit = new ManagerPoster();

        managerLimit.addMovie(movie1);
        managerLimit.addMovie(movie2);
        managerLimit.addMovie(movie3);
        managerLimit.addMovie(movie4);
        managerLimit.addMovie(movie5);

        Poster[] expected = {movie5, movie4, movie3, movie2, movie1};
        Poster[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesLessToLimit() {
        ManagerPoster managerLimit = new ManagerPoster();

        managerLimit.addMovie(movie1);
        managerLimit.addMovie(movie2);
        managerLimit.addMovie(movie3);
        managerLimit.addMovie(movie4);

        Poster[] expected = {movie4, movie3, movie2, movie1};
        Poster[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesMoreToLimit() {
        ManagerPoster managerLimit = new ManagerPoster(4);

        managerLimit.addMovie(movie1);
        managerLimit.addMovie(movie2);
        managerLimit.addMovie(movie3);
        managerLimit.addMovie(movie4);
        managerLimit.addMovie(movie5);
        managerLimit.addMovie(movie6);

        Poster[] expected = {movie6, movie5, movie4, movie3};
        Poster[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesMoreToLimitToMaxMovies() {
        ManagerPoster managerLimit = new ManagerPoster(6);

        managerLimit.addMovie(movie1);
        managerLimit.addMovie(movie2);
        managerLimit.addMovie(movie3);
        managerLimit.addMovie(movie4);
        managerLimit.addMovie(movie5);
        managerLimit.addMovie(movie6);
        managerLimit.addMovie(movie7);

        Poster[] expected = {movie7, movie6, movie5, movie4, movie3, movie2};
        Poster[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesIfNotMovies() {
        ManagerPoster managerLimit = new ManagerPoster();

        Poster[] expected = {};
        Poster[] actual = managerLimit.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }


}

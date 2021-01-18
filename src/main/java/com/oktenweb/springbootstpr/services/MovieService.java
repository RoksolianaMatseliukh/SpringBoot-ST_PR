package com.oktenweb.springbootstpr.services;

import com.oktenweb.springbootstpr.dao.MovieRepository;
import com.oktenweb.springbootstpr.entities.Movie;
import org.apache.commons.lang3.CharUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMoviesByQueries(int id, String name) {
        return movieRepository.findFirstByIdAndName(id, name);
    }

    @Override
    public List<Movie> getMoviesByIds(List<Integer> ids) {
//        http://localhost:8080/movies?ids=1,3
        return movieRepository.findMoviesByIdIsIn(ids);
    }

    @Override
    public List<Movie> getMoviesByGtId(int gt) {
        return movieRepository.findMoviesByDurationGreaterThan(gt);
    }

    @Override
    public List<Movie> getMoviesByDurationGreaterThan(int duration) {
        return movieRepository.findAllByDurationGreaterThan(duration);
    }

    @Override
    public Movie getMovieById(int id) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("movie doesn't exists with " + id + " id");
        }

        return movieRepository.getOne(id);
    }

    @Override
    public Movie createMovie(Movie movie) {
        char firstLetter = movie.getName().charAt(0);

        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public Movie editMovieById(int id, Movie editedMovie) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("movie doesn't exists with " + id + " id");
        }

        editedMovie.setId(id);

        return movieRepository.saveAndFlush(editedMovie);
    }

    @Override
    public void deleteMovieById(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void deleteMovieByDuration(int duration) {
        movieRepository.removeByDurationGreaterThan(duration);
    }
}

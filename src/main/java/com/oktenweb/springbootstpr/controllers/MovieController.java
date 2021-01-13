package com.oktenweb.springbootstpr.controllers;

import com.oktenweb.springbootstpr.dao.MovieRepository;
import com.oktenweb.springbootstpr.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable int id){
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("movie doesn't exists with " + id + " id");
        }

        return movieRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.saveAndFlush(movie);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie editMovieById(@PathVariable int id, @RequestBody Movie editedMovie) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("movie doesn't exists with " + id + " id");
        }

        editedMovie.setId(id);

        return movieRepository.saveAndFlush(editedMovie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@PathVariable int id) {
        if (!movieRepository.existsById(id)) {
            throw new IllegalArgumentException("movie doesn't exists with " + id + " id");
        }

        movieRepository.deleteById(id);
    }
}
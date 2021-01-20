package com.oktenweb.springbootstpr.services;

import com.oktenweb.springbootstpr.entities.Movie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

public interface IMovieService {

    List<Movie> getMovies();

//    Movie getMoviesByQueries(@RequestParam int id, String name);
//
//    List<Movie> getMoviesByIds(@RequestParam List<Integer> ids);
//
//    List<Movie> getMoviesByGtId(@RequestParam int gt);
//
//    List<Movie> getMoviesByDurationGreaterThan(@RequestParam int duration);

    Movie getMovieById(@PathVariable int id);

    Movie createMovie(@RequestBody @Valid Movie movie);

//    Movie editMovieById(@PathVariable int id, @RequestBody @Valid Movie editedMovie);

    void deleteMovieById(@PathVariable int id);

//    void deleteMovieByDuration(@RequestParam int duration);
        Movie updateById(int id, HttpServletRequest data) throws IOException;
}

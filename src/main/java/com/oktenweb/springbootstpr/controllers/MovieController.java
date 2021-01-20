package com.oktenweb.springbootstpr.controllers;

import com.oktenweb.springbootstpr.entities.Movie;
import com.oktenweb.springbootstpr.services.IMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin
@Slf4j  // if lombok present (name - log)
public class MovieController {

    @Autowired
    private IMovieService iMovieService;

    // if lombok not present
                                                        // який клас в логи
//    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping
    public List<Movie> getMovies() {
        return iMovieService.getMovies();
    }

//    @GetMapping
//    public List<Movie> getMoviesByGtId(@RequestParam int gt) {
//        return iMovieService.getMoviesByGtId(gt);
//    }

//    @GetMapping
//    public Movie getMoviesByQueries(@RequestParam int id, String name) {
//        return iMovieService.getMoviesByQueries(id, name);
//    }

//    @GetMapping
//    public List<Movie> getMoviesByIds(@RequestParam(required = false) List<Integer> ids) {
//        return iMovieService.getMoviesByIds(ids);
//    }

//    @GetMapping
//    public List<Movie> getMoviesByDurationGreaterThan(@RequestParam int duration) {
//        return iMovieService.getMoviesByDurationGreaterThan(duration);
//    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id){
        return iMovieService.getMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody @Valid Movie movie) {
                                                // make movie to string and set in {}
        log.info("handle post request with movie: {} ", movie);
        return iMovieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie editMovieById(@PathVariable int id, HttpServletRequest request) throws IOException {
        return iMovieService.updateById(id, request);
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteMovieById(@PathVariable int id) {
//        iMovieService.deleteById(id);
//    }

    @DeleteMapping
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovieById(@RequestParam int duration) {
        iMovieService.deleteMovieById(duration);
    }

//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.addValidators(new MovieNameValidator());
//    }
}

package com.oktenweb.springbootstpr.dao;

import com.oktenweb.springbootstpr.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByDurationGreaterThan(int gt);
    Movie findFirstByIdAndName(int id, String name);
    List<Movie> findMoviesByIdIsIn(List<Integer> ids);
    List<Movie> findAllByDurationGreaterThan(int duration);
    void removeByDurationGreaterThan(int duration);
}

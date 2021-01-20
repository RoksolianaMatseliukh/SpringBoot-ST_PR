package com.oktenweb.springbootstpr.dao;

import com.oktenweb.springbootstpr.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByDurationGreaterThan(int gt);
    Movie findFirstByIdAndName(int id, String name);
    List<Movie> findMoviesByIdIsIn(List<Integer> ids);
    List<Movie> findAllByDurationGreaterThan(int duration);
    void removeByDurationGreaterThan(int duration);

    @Query("Select m from Movie m where m.name like :name")
    Movie findByName(String name);

    Movie findById(int id);
}

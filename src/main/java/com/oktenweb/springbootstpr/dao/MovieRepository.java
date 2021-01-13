package com.oktenweb.springbootstpr.dao;

import com.oktenweb.springbootstpr.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

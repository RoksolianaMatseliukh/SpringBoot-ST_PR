package com.oktenweb.validators;

import com.oktenweb.springbootstpr.entities.Movie;
import org.apache.commons.lang3.CharUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.server.ResponseStatusException;

public class MovieValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;

        char firstLetter = movie.getName().charAt(0);

        if (!CharUtils.isAsciiAlphaUpper(firstLetter)) {
            errors.rejectValue("name", "capital letter", "must start wih capital letter");
        }
    }
}

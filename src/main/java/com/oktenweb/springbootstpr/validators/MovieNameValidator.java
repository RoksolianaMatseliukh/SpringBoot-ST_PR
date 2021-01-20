package com.oktenweb.springbootstpr.validators;

import com.oktenweb.springbootstpr.dao.MovieRepository;
import com.oktenweb.springbootstpr.entities.Movie;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MovieNameValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Movie movie = (Movie) o;

        if (StringUtils.isNotBlank(movie.getName())) {
            char firstLetter = movie.getName().charAt(0);

            if (!CharUtils.isAsciiAlphaUpper(firstLetter)) {
                errors.rejectValue("name", "capital letter", "name must start wih capital letter");
            }
        }
    }
}

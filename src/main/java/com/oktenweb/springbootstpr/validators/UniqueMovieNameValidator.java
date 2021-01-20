package com.oktenweb.springbootstpr.validators;

import com.oktenweb.springbootstpr.dao.MovieRepository;
import com.oktenweb.springbootstpr.entities.Movie;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@NoArgsConstructor
public class UniqueMovieNameValidator implements ConstraintValidator<UniqueMovieName, String> {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void initialize(UniqueMovieName constraintAnnotation) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(name);
        final Movie movie = movieRepository.findByName(name);
        System.out.println(movie);
        return movie == null;
    }
}

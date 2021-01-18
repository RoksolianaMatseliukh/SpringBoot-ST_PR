package com.oktenweb.springbootstpr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2, max = 25)
    private String name;

    @Column(nullable = false)
    @Min(20)
    @Max(250)
    private int duration;
}

package com.springbootexcel.poc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "netflix_titles")
public class NetflixTitlesEntity implements Serializable {

    @Id
    private String showId;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String dateAdded;
    private Integer releaseYear;
    private String rating;
    private String duration;
    private String listedIn;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetflixTitlesEntity that = (NetflixTitlesEntity) o;
        return Objects.equals(showId, that.showId) && Objects.equals(type, that.type) && Objects.equals(title, that.title) && Objects.equals(director, that.director) && Objects.equals(cast, that.cast) && Objects.equals(country, that.country) && Objects.equals(dateAdded, that.dateAdded) && Objects.equals(releaseYear, that.releaseYear) && Objects.equals(rating, that.rating) && Objects.equals(duration, that.duration) && Objects.equals(listedIn, that.listedIn) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showId, type, title, director, cast, country, dateAdded, releaseYear, rating, duration, listedIn, description);
    }
}

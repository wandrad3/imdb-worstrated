package com.overflix.mappedIMDB;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class Movies {
    private String title;
    private String description;
    private String year;
    private LocalDate releaseDate;
    private String imdbID;
    private String imdbRating;
    private String voteCount;
    private String popularity;
    private String youtubeTrailerKey;
    private String rated;
    private long runtime;
    private String[] genres;
    private String[] stars;
    private String[] directors;
    private String[] countries;
    private String[] language;
    private String status;
    private String statusMessage;

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("year")
    public String getYear() { return year; }
    @JsonProperty("year")
    public void setYear(String value) { this.year = value; }

    @JsonProperty("release_date")
    public LocalDate getReleaseDate() { return releaseDate; }
    @JsonProperty("release_date")
    public void setReleaseDate(LocalDate value) { this.releaseDate = value; }

    @JsonProperty("imdb_id")
    public String getImdbID() { return imdbID; }
    @JsonProperty("imdb_id")
    public void setImdbID(String value) { this.imdbID = value; }

    @JsonProperty("imdb_rating")
    public String getImdbRating() { return imdbRating; }
    @JsonProperty("imdb_rating")
    public void setImdbRating(String value) { this.imdbRating = value; }

    @JsonProperty("vote_count")
    public String getVoteCount() { return voteCount; }
    @JsonProperty("vote_count")
    public void setVoteCount(String value) { this.voteCount = value; }

    @JsonProperty("popularity")
    public String getPopularity() { return popularity; }
    @JsonProperty("popularity")
    public void setPopularity(String value) { this.popularity = value; }

    @JsonProperty("youtube_trailer_key")
    public String getYoutubeTrailerKey() { return youtubeTrailerKey; }
    @JsonProperty("youtube_trailer_key")
    public void setYoutubeTrailerKey(String value) { this.youtubeTrailerKey = value; }

    @JsonProperty("rated")
    public String getRated() { return rated; }
    @JsonProperty("rated")
    public void setRated(String value) { this.rated = value; }

    @JsonProperty("runtime")
    public long getRuntime() { return runtime; }
    @JsonProperty("runtime")
    public void setRuntime(long value) { this.runtime = value; }

    @JsonProperty("genres")
    public String[] getGenres() { return genres; }
    @JsonProperty("genres")
    public void setGenres(String[] value) { this.genres = value; }

    @JsonProperty("stars")
    public String[] getStars() { return stars; }
    @JsonProperty("stars")
    public void setStars(String[] value) { this.stars = value; }

    @JsonProperty("directors")
    public String[] getDirectors() { return directors; }
    @JsonProperty("directors")
    public void setDirectors(String[] value) { this.directors = value; }

    @JsonProperty("countries")
    public String[] getCountries() { return countries; }
    @JsonProperty("countries")
    public void setCountries(String[] value) { this.countries = value; }

    @JsonProperty("language")
    public String[] getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(String[] value) { this.language = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("status_message")
    public String getStatusMessage() { return statusMessage; }
    @JsonProperty("status_message")
    public void setStatusMessage(String value) { this.statusMessage = value; }
}

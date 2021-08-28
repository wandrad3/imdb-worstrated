package com.overflix.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class Base {
 
    private ApiImage image;
    private String title;
    private String titleType;
    private long year;



    @JsonProperty("image")
    public ApiImage getImage() { return image; }
    @JsonProperty("image")
    public void setImage(ApiImage value) { this.image = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("titleType")
    public String getTitleType() { return titleType; }
    @JsonProperty("titleType")
    public void setTitleType(String value) { this.titleType = value; }

    @JsonProperty("year")
    public long getYear() { return year; }
    @JsonProperty("year")
    public void setYear(long value) { this.year = value; }
}

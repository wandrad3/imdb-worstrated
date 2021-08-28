package com.overflix.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class RelatedTitle {
  
    private RelatedNameImage image;
    private Title title;
    private TitleType titleType;
    private long year;

   

    @JsonProperty("image")
    public RelatedNameImage getImage() { return image; }
    @JsonProperty("image")
    public void setImage(RelatedNameImage value) { this.image = value; }

    @JsonProperty("title")
    public Title getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(Title value) { this.title = value; }

    @JsonProperty("titleType")
    public TitleType getTitleType() { return titleType; }
    @JsonProperty("titleType")
    public void setTitleType(TitleType value) { this.titleType = value; }

    @JsonProperty("year")
    public long getYear() { return year; }
    @JsonProperty("year")
    public void setYear(long value) { this.year = value; }
}

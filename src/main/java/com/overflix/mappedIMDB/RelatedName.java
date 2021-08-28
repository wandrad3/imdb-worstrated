package com.overflix.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class RelatedName {
    private String id;
    private RelatedNameImage image;
    private String legacyNameText;
    private String name;
    private String[] akas;
    private Disambiguation disambiguation;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("image")
    public RelatedNameImage getImage() { return image; }
    @JsonProperty("image")
    public void setImage(RelatedNameImage value) { this.image = value; }

    @JsonProperty("legacyNameText")
    public String getLegacyNameText() { return legacyNameText; }
    @JsonProperty("legacyNameText")
    public void setLegacyNameText(String value) { this.legacyNameText = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("akas")
    public String[] getAkas() { return akas; }
    @JsonProperty("akas")
    public void setAkas(String[] value) { this.akas = value; }

    @JsonProperty("disambiguation")
    public Disambiguation getDisambiguation() { return disambiguation; }
    @JsonProperty("disambiguation")
    public void setDisambiguation(Disambiguation value) { this.disambiguation = value; }
}

package ai.overmind.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class ApiImage {
    private String title;
    private String imdb;
    private String poster;
    private String fanart;
    private String status;
    private String statusMessage;

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("IMDB")
    public String getImdb() { return imdb; }
    @JsonProperty("IMDB")
    public void setImdb(String value) { this.imdb = value; }

    @JsonProperty("poster")
    public String getPoster() { return poster; }
    @JsonProperty("poster")
    public void setPoster(String value) { this.poster = value; }

    @JsonProperty("fanart")
    public String getFanart() { return fanart; }
    @JsonProperty("fanart")
    public void setFanart(String value) { this.fanart = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("status_message")
    public String getStatusMessage() { return statusMessage; }
    @JsonProperty("status_message")
    public void setStatusMessage(String value) { this.statusMessage = value; }
}

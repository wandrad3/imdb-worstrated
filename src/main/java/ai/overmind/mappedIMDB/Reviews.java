package ai.overmind.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class Reviews {
    private String type;
    private Base base;
    private String paginationKey;
    private Review[] reviews;
    private long totalReviews;

    @JsonProperty("@type")
    public String getType() { return type; }
    @JsonProperty("@type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("base")
    public Base getBase() { return base; }
    @JsonProperty("base")
    public void setBase(Base value) { this.base = value; }

    @JsonProperty("paginationKey")
    public String getPaginationKey() { return paginationKey; }
    @JsonProperty("paginationKey")
    public void setPaginationKey(String value) { this.paginationKey = value; }

    @JsonProperty("reviews")
    public Review[] getReviews() { return reviews; }
    @JsonProperty("reviews")
    public void setReviews(Review[] value) { this.reviews = value; }

    @JsonProperty("totalReviews")
    public long getTotalReviews() { return totalReviews; }
    @JsonProperty("totalReviews")
    public void setTotalReviews(long value) { this.totalReviews = value; }
}

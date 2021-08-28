package com.overflix.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class InterestingVotes {
    private long down;
    private long up;

    @JsonProperty("down")
    public long getDown() { return down; }
    @JsonProperty("down")
    public void setDown(long value) { this.down = value; }

    @JsonProperty("up")
    public long getUp() { return up; }
    @JsonProperty("up")
    public void setUp(long value) { this.up = value; }
}

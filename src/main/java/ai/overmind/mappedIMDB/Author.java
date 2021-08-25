package ai.overmind.mappedIMDB;

import com.fasterxml.jackson.annotation.*;

public class Author {
    private String displayName;
    private String userID;

    @JsonProperty("displayName")
    public String getDisplayName() { return displayName; }
    @JsonProperty("displayName")
    public void setDisplayName(String value) { this.displayName = value; }

    @JsonProperty("userId")
    public String getUserID() { return userID; }
    @JsonProperty("userId")
    public void setUserID(String value) { this.userID = value; }
}

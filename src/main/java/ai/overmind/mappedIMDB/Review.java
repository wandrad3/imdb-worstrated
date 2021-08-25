package ai.overmind.mappedIMDB;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class Review {
    private Author author;
    private long authorRating;
    private double helpfulnessScore;
    private String id;
    private InterestingVotes interestingVotes;
    private LanguageCode languageCode;
    private String reviewText;
    private String reviewTitle;
    private boolean spoiler;
    private LocalDate submissionDate;
    

    @JsonProperty("author")
    public Author getAuthor() { return author; }
    @JsonProperty("author")
    public void setAuthor(Author value) { this.author = value; }

    @JsonProperty("authorRating")
    public long getAuthorRating() { return authorRating; }
    @JsonProperty("authorRating")
    public void setAuthorRating(long value) { this.authorRating = value; }

    @JsonProperty("helpfulnessScore")
    public double getHelpfulnessScore() { return helpfulnessScore; }
    @JsonProperty("helpfulnessScore")
    public void setHelpfulnessScore(double value) { this.helpfulnessScore = value; }

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("interestingVotes")
    public InterestingVotes getInterestingVotes() { return interestingVotes; }
    @JsonProperty("interestingVotes")
    public void setInterestingVotes(InterestingVotes value) { this.interestingVotes = value; }

    @JsonProperty("languageCode")
    public LanguageCode getLanguageCode() { return languageCode; }
    @JsonProperty("languageCode")
    public void setLanguageCode(LanguageCode value) { this.languageCode = value; }

    @JsonProperty("reviewText")
    public String getReviewText() { return reviewText; }
    @JsonProperty("reviewText")
    public void setReviewText(String value) { this.reviewText = value; }

    @JsonProperty("reviewTitle")
    public String getReviewTitle() { return reviewTitle; }
    @JsonProperty("reviewTitle")
    public void setReviewTitle(String value) { this.reviewTitle = value; }

    @JsonProperty("spoiler")
    public boolean getSpoiler() { return spoiler; }
    @JsonProperty("spoiler")
    public void setSpoiler(boolean value) { this.spoiler = value; }

    @JsonProperty("submissionDate")
    public LocalDate getSubmissionDate() { return submissionDate; }
    @JsonProperty("submissionDate")
    public void setSubmissionDate(LocalDate value) { this.submissionDate = value; }

   
}

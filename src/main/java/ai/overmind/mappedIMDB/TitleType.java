package ai.overmind.mappedIMDB;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum TitleType {
    MOVIE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case MOVIE: return "movie";
        }
        return null;
    }

    @JsonCreator
    public static TitleType forValue(String value) throws IOException {
        if (value.equals("movie")) return MOVIE;
        throw new IOException("Cannot deserialize TitleType");
    }
}

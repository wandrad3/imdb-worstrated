package ai.overmind.mappedIMDB;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Disambiguation {
    I, III;

    @JsonValue
    public String toValue() {
        switch (this) {
            case I: return "I";
            case III: return "III";
        }
        return null;
    }

    @JsonCreator
    public static Disambiguation forValue(String value) throws IOException {
        if (value.equals("I")) return I;
        if (value.equals("III")) return III;
        throw new IOException("Cannot deserialize Disambiguation");
    }
}

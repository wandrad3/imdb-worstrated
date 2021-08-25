package ai.overmind.mappedIMDB;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Title {
    BIRDEMIC_SHOCK_AND_TERROR;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BIRDEMIC_SHOCK_AND_TERROR: return "Birdemic: Shock and Terror";
        }
        return null;
    }

    @JsonCreator
    public static Title forValue(String value) throws IOException {
        if (value.equals("Birdemic: Shock and Terror")) return BIRDEMIC_SHOCK_AND_TERROR;
        throw new IOException("Cannot deserialize Title");
    }
}

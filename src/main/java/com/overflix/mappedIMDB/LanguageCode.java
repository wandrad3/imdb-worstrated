package com.overflix.mappedIMDB;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum LanguageCode {
    ENG;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ENG: return "eng";
        }
        return null;
    }

    @JsonCreator
    public static LanguageCode forValue(String value) throws IOException {
        if (value.equals("eng")) return ENG;
        throw new IOException("Cannot deserialize LanguageCode");
    }
}

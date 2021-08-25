package ai.overmind.mappedIMDB;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Source {
    PAIDCUSTOMER, USERUPLOAD;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PAIDCUSTOMER: return "paidcustomer";
            case USERUPLOAD: return "userupload";
        }
        return null;
    }

    @JsonCreator
    public static Source forValue(String value) throws IOException {
        if (value.equals("paidcustomer")) return PAIDCUSTOMER;
        if (value.equals("userupload")) return USERUPLOAD;
        throw new IOException("Cannot deserialize Source");
    }
}

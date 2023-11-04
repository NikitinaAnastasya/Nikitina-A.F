package conteiner;

import java.util.ArrayList;

public class Token {
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    private String type;
    private String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type + " -> " + value;
    }
}

package com.sber.sber_beautiful_code.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class PairedCharacters {

    protected static char openingChar;
    protected static char closingChar;
    protected String body;

    abstract public boolean isCorrect();

    protected boolean checkTextInside() {
        String regex = "[" + openingChar + closingChar + "]";
        return !body.replaceAll(regex, "").isBlank();
    }

    protected boolean checkIsClosed() {
        boolean result = body.charAt(0) == openingChar && body.charAt(body.length() -1) == closingChar;
        return result;
    }
}

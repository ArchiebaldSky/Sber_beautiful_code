package com.sber.sber_beautiful_code.entity;

import lombok.Getter;
import lombok.Setter;

public class RoundBrackets extends PairedCharacters {

    @Getter
    @Setter
    protected boolean isClosed;
    @Getter
    protected boolean hasTextInside;

    public RoundBrackets(String body) {
        super(body);
        openingChar = '(';
        closingChar = ')';
        isClosed = checkIsClosed();
        hasTextInside = checkTextInside();
    }

    @Override
    public boolean isCorrect() {
        return isClosed && hasTextInside;
    }
}

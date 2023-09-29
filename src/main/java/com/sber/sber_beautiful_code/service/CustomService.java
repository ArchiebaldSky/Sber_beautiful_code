package com.sber.sber_beautiful_code.service;

import com.sber.sber_beautiful_code.dto.MessageDto;
import com.sber.sber_beautiful_code.entity.PairedCharacters;
import com.sber.sber_beautiful_code.entity.RoundBrackets;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class CustomService {

    public boolean checkBrackets(MessageDto messageDto) {
        List<PairedCharacters> brackets = findPairedChar(messageDto.getText());
        brackets = brackets.stream().filter(bracket -> !bracket.isCorrect()).toList();
        return brackets.size() == 0;
    }

    public List<PairedCharacters> findPairedChar(String text) {
        List<PairedCharacters> pairedCharacters = new ArrayList<>();
        pairedCharacters.addAll(findRoundBrackets(text));
        return pairedCharacters;
    }

    public List<RoundBrackets> findRoundBrackets(String text) {
        List<RoundBrackets> roundBracketsList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                if (!stack.isEmpty()) {
                    RoundBrackets roundBrackets = new RoundBrackets(text.substring(stack.pop(), i + 1));
                    roundBracketsList.add(roundBrackets);
                    System.out.println(roundBrackets.toString());
                    System.out.println(roundBrackets.isClosed());
                    System.out.println(roundBrackets.isHasTextInside());
                } else {
                    RoundBrackets roundBrackets = new RoundBrackets(text.substring(0, i + 1));
                    roundBrackets.setClosed(false);
                    roundBracketsList.add(roundBrackets);
                    System.out.println(roundBrackets.toString());
                    System.out.println(roundBrackets.isClosed());
                    System.out.println(roundBrackets.isHasTextInside());
                }
            }
        }
        if (!stack.isEmpty()){
            roundBracketsList.add(new RoundBrackets("("));
        }

        return roundBracketsList;
    }
}

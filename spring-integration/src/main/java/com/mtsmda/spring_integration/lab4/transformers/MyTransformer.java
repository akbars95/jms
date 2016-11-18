package com.mtsmda.spring_integration.lab4.transformers;

import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by dminzat on 11/18/2016.
 */
@Component("myTransformer")
public class MyTransformer {

    private static Map<Character, Integer> englishAlphabet = new LinkedHashMap();
    private List<Character> characters;

    static {
        add();
    }

    private static void add() {
        int begin = 65;
        int count = 0;
        for (int i = begin; i < begin + 26; i++) {
            englishAlphabet.put(new Character((char) i), ++count);
        }
    }

    /*public static void main(String[] args) {
        add();
        System.out.println("123ertertrew");
        System.out.println(new MyTransformer().toMyCode(new GenericMessage<String>("123ertertrew")).getPayload());
        System.out.println(englishAlphabet);
    }*/

    @Transformer(inputChannel = "messageChannelOut", outputChannel = "messageChannelOut")
    public Message<String> toMyCode(Message<String> inputMessage) {
        String payload = inputMessage.getPayload();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < payload.length(); i++) {
            char charAt = payload.charAt(i);
            encode(charAt, result);
        }
        return new GenericMessage<String>(result.toString());
    }

    private void encode(char charAt, StringBuilder result) {
        if (Character.isLetter(charAt)) {
            Integer integer = englishAlphabet.get(Character.toUpperCase(charAt));
            if (null != integer) {
                integer += 9;
                if (integer > englishAlphabet.size()) {
                    int i = integer - englishAlphabet.size();//29 - 26=3
                    integer = i;
                }
                result.append("_|_").append(englishAlphabet.get(getCharacters().get(integer)));
                return;
            }
        }
        result.append(charAt);
    }

    private List<Character> getCharacters() {
        if (null == characters) {
            characters = new ArrayList<>();
            Iterator<Character> iterator = englishAlphabet.keySet().iterator();
            while (iterator.hasNext()) {
                characters.add(iterator.next());
            }
        }
        return characters;
    }

}
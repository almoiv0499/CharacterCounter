package ua.com.foxminded.collectionframework;

import java.util.*;

public class CharCounter {

    private final Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

    public Map<Character, Integer> cachedCount(String inputString) {
        
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("The input text can't be is empty.");
        }
        cache.computeIfAbsent(inputString, this::countUniqueCharacters);
        return cache.get(inputString);
            
    }

    private Map<Character, Integer> countUniqueCharacters(String inputString) {
        
        Map<Character, Integer> numberChar = new LinkedHashMap<>();

        for (Character chars : inputString.toCharArray()) {
            numberChar.merge(chars, 1, (prev, one) -> prev + one);
        }
        return numberChar;
        
    }

}


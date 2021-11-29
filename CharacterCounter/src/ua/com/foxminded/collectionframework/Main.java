package ua.com.foxminded.collectionframework;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        CharCounter charCounter = new CharCounter();
        String inputString = inputText();
        System.out.println("The output unique characters: " + "\n" + inputString);
        print(charCounter.cachedCount(inputString));
        
    }

    public static String inputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input text: ");
        return scanner.nextLine();
    }
    
    private static void print(Map<Character, Integer> charCount) {
        charCount.forEach((key, value) -> System.out.println("\"" + key + "\"" + " - " + value));
    }

}


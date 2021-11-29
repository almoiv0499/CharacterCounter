package ua.com.foxminded.collectionframework;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

class CharCounterTest {

    @Rule
    CharCounter tester = new CharCounter();

    @Test
    void returnTheTaskCondition() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);
        expected.put('!', 1);

        assertEquals(expected, tester.cachedCount("hello world!"));
    }

    @Test
    void returnQuantityUniqueAlphabeticCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('l', 3);
        expected.put('o', 2);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);

        assertEquals(expected, tester.cachedCount("helloworld"));
    }

    @Test
    void returnQuantityUniqueCapitalAlphabeticCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('H', 1);
        expected.put('E', 1);
        expected.put('L', 3);
        expected.put('O', 2);
        expected.put('W', 1);
        expected.put('R', 1);
        expected.put('D', 1);

        assertEquals(expected, tester.cachedCount("HELLOWORLD"));
    }

    @Test
    void returnOnlyOneUniqueCharacter() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);

        assertEquals(expected, tester.cachedCount("a"));
    }

    @Test
    void returnQuantityDuplicateUniqueCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 3);
        expected.put(' ', 3);
        expected.put('A', 3);
        expected.put('1', 3);
        expected.put('!', 3);

        assertEquals(expected, tester.cachedCount("aaa AAA 111 !!!"));
    }

    @Test
    void returnQuantityUniqueSpecialCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('!', 1);
        expected.put('@', 1);
        expected.put('#', 1);
        expected.put('$', 1);
        expected.put('%', 1);
        expected.put('^', 1);
        expected.put('&', 1);
        expected.put('*', 1);
        expected.put('(', 1);
        expected.put(')', 1);
        expected.put('_', 1);
        expected.put('+', 1);

        assertEquals(expected, tester.cachedCount("!@#$%^&*()_+"));

    }

    @Test
    void returnQuantityUniqueIntegerCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('1', 1);
        expected.put('2', 1);
        expected.put('3', 1);
        expected.put('4', 1);
        expected.put('5', 1);
        expected.put('6', 1);
        expected.put('7', 1);
        expected.put('8', 1);
        expected.put('9', 1);
        expected.put('0', 1);

        assertEquals(expected, tester.cachedCount("1234567890"));
    }

    @Test
    void returnQuantityAllUniqueCharacters() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('H', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 2);
        expected.put(' ', 1);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('1', 1);
        expected.put('d', 1);
        expected.put('!', 1);

        assertEquals(expected, tester.cachedCount("Hello wor1d!"));
    }

    @Test
    void returnOnlyOneSpace() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put(' ', 1);

        assertEquals(expected, tester.cachedCount(" "));
    }

    @Test
    void returnQuantityDuplicateSpaces() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put(' ', 3);

        assertEquals(expected, tester.cachedCount("   "));
    }

    @Test
    void returnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new CharCounter().cachedCount(""));
    }

    @Test
    void returnCachedResultWhenItHasSameCachedString() {
        Map<Character, Integer> firstActual = tester.cachedCount("hello world!");
        Map<Character, Integer> secondActual = tester.cachedCount("hello world!");
        
        assertSame(firstActual, secondActual);
    }

}


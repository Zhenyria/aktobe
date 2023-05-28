package ru.zhenyria.aktobe.util;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class LanguageUtil {
    public static final Set<Character> ENGLISH_SYMBOLS;
    public static final Set<Character> KAZAKH_SYMBOLS;
    public static final Set<Character> RUSSIAN_SYMBOLS;

    static {
        ENGLISH_SYMBOLS = getAlphabet("abcdefghijklmnopqrstuvwxyz");
        KAZAKH_SYMBOLS = getAlphabet("аәбвгғдеёжзийкқлмнңоөпрстуұфхһцчшщъыіьэюя");
        RUSSIAN_SYMBOLS = getAlphabet("абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
    }

    private static Set<Character> getAlphabet(String alphabetAsString) {
        var symbols = new HashSet<Character>();

        for (char symbol : alphabetAsString.toCharArray()) {
            val lowerCaseSymbol = Character.toLowerCase(symbol);
            val upperCaseSymbol = Character.toUpperCase(symbol);
            symbols.add(lowerCaseSymbol);
            symbols.add(upperCaseSymbol);
        }

        return Collections.unmodifiableSet(symbols);
    }
}

package ru.zhenyria.aktobe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.zhenyria.aktobe.util.LanguageUtil;

import java.util.Set;

@RequiredArgsConstructor
@Getter
public enum Language {
    ENGLISH(LanguageUtil.ENGLISH_SYMBOLS),
    KAZAKH(LanguageUtil.KAZAKH_SYMBOLS),
    RUSSIAN(LanguageUtil.RUSSIAN_SYMBOLS);

    private final Set<Character> alphabet;
}

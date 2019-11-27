package com.rosetta.codegolf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Your goal is to make a program that converts an input to its acronym.
 * Your input is guaranteed to have only letters and spaces. The input will have exactly one space between words.
 * You must output the acronym of the input.
 * 获取缩略词
 *
 * https://codegolf.stackexchange.com/questions/75448/making-an-acronym
 */
public class AcronymMaker {

    private static final List<String> STOP_WORDS = Arrays.asList("AND", "OR", "BY", "OF");

    public static String acronym(final String input) {
        return Arrays
                // 英文字符串转大写,并按照不可见字符分割
                .stream(input.toUpperCase().split("\\s"))   // \s - 正则表示匹配任何不可见字符(包括\f换页符,\n换行符,\r回车符,\t制表符,\v垂直制表符)  \S - 正则表示匹配任何课件字符
                // 去除停用词
                .filter(word -> !STOP_WORDS.contains(word))
                // 获取首字母
                .map(w -> String.valueOf(w.charAt(0)))
                // 首字母组成新的字符串
                .collect(Collectors.joining(""));
    }

}

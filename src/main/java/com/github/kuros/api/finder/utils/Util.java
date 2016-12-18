package com.github.kuros.api.finder.utils;

/**
 * Created by kumarro on 19/12/16.
 */
public class Util {

    public static String convertCamelCase(final String name) {
        String formatted = "";
        final char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            formatted += Character.isUpperCase(chars[i]) ? " " + Character.toLowerCase(chars[i]) : chars[i];
        }
        return formatted;
    }
}

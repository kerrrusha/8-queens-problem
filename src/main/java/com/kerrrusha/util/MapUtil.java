package com.kerrrusha.util;

public class MapUtil {

    public static String mapArrayToString(int[] arr) {
        final StringBuilder builder = new StringBuilder();
        final String SEPARATOR = " ";

        builder.append("[ ");
        for (Object elem : arr) {
            builder.append(elem).append(SEPARATOR);
        }
        builder.replace(builder.length() - 1, builder.length(), " ]");

        return builder.toString();
    }
}

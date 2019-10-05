package com.keuangan.ewspersistence.commmon;

import java.util.Arrays;
import java.util.List;

public final class PersistenceUtils {

    private PersistenceUtils() {}

    public static String constructLike(String token) {
        return "%" + token + "%";
    }

    public static List<String> stringToList(String token, String separator) {
        return Arrays.asList(token.split(separator));
    }
}

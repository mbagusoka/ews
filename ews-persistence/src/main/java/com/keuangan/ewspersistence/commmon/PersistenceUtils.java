package com.keuangan.ewspersistence.commmon;

import com.keuangan.ewspersistence.gateway.filter.BaseFilter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

    public static boolean isStringValid(String token) {
        return null != token && !token.trim().isEmpty();
    }

    public static PageRequest constructPageRequest(BaseFilter filter) {
        return PageRequest.of(filter.getPageNumber(), filter.getPageSize(), Sort.Direction.fromString(filter.getSortingOrder()), filter.getSortBy());
    }
}

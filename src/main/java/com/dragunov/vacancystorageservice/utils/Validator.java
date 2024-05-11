package com.dragunov.vacancystorageservice.utils;

public class Validator {
    public static String validateQuery(String query) {
        return query.trim().substring(0, 1).toUpperCase() + query.trim().substring(1).toLowerCase();
    }
}

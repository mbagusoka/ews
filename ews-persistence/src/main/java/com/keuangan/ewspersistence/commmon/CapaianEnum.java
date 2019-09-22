package com.keuangan.ewspersistence.commmon;

public enum CapaianEnum {

    EXCELLENT   ("Excellent"),
    GOOD        ("Good"),
    POOR        ("Poor");

    private final String description;

    CapaianEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getCapaianDescription(int elapsedDays) {
        if (5 > elapsedDays) {
            return EXCELLENT.description;
        } else if (5 == elapsedDays) {
            return GOOD.description;
        } else {
            return POOR.description;
        }
    }
}

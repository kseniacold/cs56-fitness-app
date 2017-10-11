package com.cs56fitnessapp.models.workout;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated: 10/11/17
 */

public enum SwimmingStroke {
    // Traditional strokes + mixed
    FREESTYLE("Freestyle"), BREASTSTROKE("Breaststroke"), BACKSTROKE("Backstroke"), BUTTERFLY("Butterfly"), MIXED("Mixed");

    // String representation
    private String stringValue;

    SwimmingStroke(String stringValue) {
        this.stringValue = stringValue;
    }

    /**
     * @return String representation of SwimmingStroke
     */
    public String getStringValue() {
        return stringValue;
    }
}
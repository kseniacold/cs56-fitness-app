package com.cs56fitnessapp.models;

/**
 * @author Saori Shigehisa
 * Created: 10/6/17
 * Last Updated: 10/7/17
 */
import java.util.ArrayList;
import java.util.Date;

public class Day implements ActivityFacts, DietFacts {

    /** Date */
    private Date date;

    /** User */
    private User user;

    /** calorieGoal */
    private double calorieGoal;

    /** WorkoutList */
    private ArrayList < Workout > workoutList;

    /** MealList */
    private ArrayList < Meal > mealList;

    public boolean isToday() { return false; }

    public double getCaloriesLeft() { return 0.0; }

    /* ActivityFacts Interface */
    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTimeMins() {
        return 0;
    }

    /* DietFacts Interface */
    @Override
    public int getCaloriesIn() {
        return 0;
    }

    @Override
    public TotalFat getTotalFatIn() {
        return null;
    }

    @Override
    public TotalCarb getTotalCarbIn() {
        return null;
    }

    @Override
    public double getProteinIn() {
        return 0;
    }

    public static void main(String [] args) {
        System.out.println("Hello");
    }
}

package com.cs56fitnessapp.models;

/**
 * @author Saori Shigehisa
 * Created: 10/6/17
 * Last Updated: 10/14/17
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Day implements ActivityFacts, DietFacts {

    /** date */
    private LocalDate date;

    /** User */
    private User user;

    /** calorieGoal */
    private double calorieGoal;

    /** WorkoutList */
    private ArrayList < Workout > workoutList;

    /** MealList */
    private ArrayList < Meal > mealList;

    public Day (LocalDate date, User user, double caloriesGoal, ArrayList < Workout > workoutList, ArrayList < Meal > mealList){
      this.date = date;
      this.user = user;
      this.calorieGoal = calorieGoal;
      this.workoutList = workoutList;
      this.mealList = mealList;
    }



    public boolean isToday() {
        LocalDate now = LocalDate.now();

        if (now.getYear() == date.getYear() && now.getMonth() == date.getMonth() && now.getDayOfMonth() == date.getDayOfMonth()) {
            return true;
        } else {
            return false;

        }
    }

    //Kcal ~= METS * bodyMassKg * timePerformingHours
    public double getCaloriesLeft() { return 0.0; }

    /* ActivityFacts Interface */
    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTime() {
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

package com.cs56fitnessapp.models;

import  com.cs56fitnessapp.models.workout.Workout;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *  @author Daniel Cervantes
 *  @author Ksenia Koldaeva
 *
 * Date created: 10/18/17
 * Last updated: 10/18/17
 */


public class StrengthTraining extends Workout {


    private ArrayList<String> exerciseList = new ArrayList<>(){{

        add("Bench Press\n");
        add("Bicep Curls\n");
        add("Shoulder Press\n");
        add("Lateral Raises\n");
        add("Tricep Extensions\n");
        add("Bent Over Rows\n");
        add("Sit Ups\n");
        add("Back Squats\n");
        add("Front Squats\n");
        add("Deadlift\n");
        add("Leg Press\n");
        add("Lunges\n");
        add("Kettle Bell Swings\n");
        add("Leg Lifts\n");

    }};


    public StrengthTraining(User user, LocalDate date) {
        super(user, date);
        this.exerciseList = new ArrayList<>();
    }


    @Override
    public int getCaloriesOut() {
        return 0;
    }

    @Override
    public int getActiveTimeMins() {
        return 0;
    }
}

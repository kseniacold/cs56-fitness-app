package com.cs56fitnessapp.models;

/**
 * @author Daniel Cervantes
 * @author Ksenia Koldaeva
 * Date created: 9/24/17
 * Last updated: 10/10/17
 */

import java.time.LocalDate;

public abstract class Workout implements ActivityFacts {

    private User user;
    private LocalDate date;
    private int warmUpTime;
    private int coolDownTime;

    public Workout(User user, LocalDate date) {
        this.user = user;
        this.date = date;
    }

    // Start getters and setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWarmUpTime() {
        return warmUpTime;
    }

    public void setWarmUpTime(int warmUpTime) {
        this.warmUpTime = warmUpTime;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    // End getters and setters
}

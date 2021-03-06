package com.cs56fitnessapp.models.workout;

import com.cs56fitnessapp.models.FitnessFormulas;
import com.cs56fitnessapp.models.User;
import java.time.LocalDateTime;

/**
 * @author Ksenia Koldaeva
 * Created: 10/11/17
 * Last Updated: 12/07/17
 */
public class Cycling extends Endurance {

    private CyclingType cyclingType;

    /**
     * Constructs new Cycling object with provided parameters
     * @param user user performing cycling
     * @param date date of the cycling workout
     * @param distanceKm distance of the cycling workout
     * @param timePerformingHours duration of the cycling workout
     * @param cyclingType cycling workout type
     */
    public Cycling(Long id, User user, LocalDateTime date, double distanceKm, double timePerformingHours, CyclingType cyclingType) {
        super(id, user, date, distanceKm, timePerformingHours);
        this.cyclingType = cyclingType;
    }

    // Getters and setters start
    public CyclingType getCyclingType() {
        return cyclingType;
    }

    public void setCyclingType(CyclingType cyclingType) {
        this.cyclingType = cyclingType;
    }
    // Getters and setters end

    /**
     *
     * @return calories out based on the cycling workout
     */
    @Override
    public int getCaloriesOut() {
        int caloriesOut = 0;

        switch (cyclingType) {
            case MOUNTAIN:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_CYCLING_MOUNTAIN, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                break;
            case RACING:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_CYCLING_RACING, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
                break;
            case LEISURE:
                caloriesOut = FitnessFormulas.caloriesOutByMET(FitnessFormulas.MET_CYCLING_LEISURE, this.getUser().getBodyMassKg(), this.getTimePerformingHours());
        }

        return caloriesOut;
    }
}

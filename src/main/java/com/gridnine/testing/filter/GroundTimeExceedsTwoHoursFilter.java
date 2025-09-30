package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

public class GroundTimeExceedsTwoHoursFilter extends AbstractFlightFilter {
    private static final long MAX_GROUND_TIME_MINUTES = 120;

    @Override
    protected boolean isValid(Flight flight) {
        return flight.getTotalGroundTimeMinutes() <= MAX_GROUND_TIME_MINUTES;
    }
}

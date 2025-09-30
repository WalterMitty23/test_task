package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

public class ArrivalBeforeDepartureFilter extends AbstractFlightFilter {
    @Override
    protected boolean isValid(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(s -> !s.getArrivalDate().isBefore(s.getDepartureDate()));
    }
}

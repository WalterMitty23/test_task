package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;
import java.time.LocalDateTime;

public class DepartureBeforeNowFilter extends AbstractFlightFilter {
    @Override
    protected boolean isValid(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        return flight.getSegments().stream()
                .allMatch(s -> s.getDepartureDate().isAfter(now));
    }
}

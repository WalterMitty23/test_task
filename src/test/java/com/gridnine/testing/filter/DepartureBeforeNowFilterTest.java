package com.gridnine.testing.filter;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeNowFilterTest {
    @Test
    void shouldRemoveFlightsDepartingBeforeNow() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new DepartureBeforeNowFilter();

        List<Flight> result = filter.filter(flights);

        assertTrue(result.stream()
                .allMatch(f -> f.getSegments().stream()
                        .allMatch(s -> s.getDepartureDate().isAfter(java.time.LocalDateTime.now()))));
    }
}

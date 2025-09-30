package com.gridnine.testing.filter;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroundTimeExceedsTwoHoursFilterTest {
    @Test
    void shouldRemoveFlightsWithTooLongGroundTime() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = new GroundTimeExceedsTwoHoursFilter();

        List<Flight> result = filter.filter(flights);

        assertTrue(result.stream()
                .allMatch(f -> f.getTotalGroundTimeMinutes() <= 120));
    }
}

package com.gridnine.testing.filter;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFilterIntegrationTest {

    @Test
    void shouldApplyAllFiltersTogether() {
        // arrange
        List<Flight> flights = FlightBuilder.createFlights();
        List<FlightFilter> filters = List.of(
                new DepartureBeforeNowFilter(),
                new ArrivalBeforeDepartureFilter(),
                new GroundTimeExceedsTwoHoursFilter()
        );

        // act
        List<Flight> filtered = flights;
        for (FlightFilter filter : filters) {
            filtered = filter.filter(filtered);
        }

        // assert
        assertTrue(filtered.stream().allMatch(f ->
                // правило 1: вылет в будущем
                f.getSegments().stream().allMatch(s -> s.getDepartureDate().isAfter(LocalDateTime.now())) &&
                        // правило 2: прилёт не раньше вылета
                        f.getSegments().stream().allMatch(s -> !s.getArrivalDate().isBefore(s.getDepartureDate())) &&
                        // правило 3: общее время на земле <= 120 минут
                        f.getTotalGroundTimeMinutes() <= 120
        ));
    }
}

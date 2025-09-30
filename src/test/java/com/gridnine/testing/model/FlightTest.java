package com.gridnine.testing.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    @Test
    void shouldCalculateGroundTimeCorrectly() {
        LocalDateTime now = LocalDateTime.now();
        Segment first = new Segment(now, now.plusHours(2));
        Segment second = new Segment(now.plusHours(4), now.plusHours(6));

        Flight flight = new Flight(List.of(first, second));

        long groundMinutes = flight.getTotalGroundTimeMinutes();
        assertEquals(120, groundMinutes);
    }
}

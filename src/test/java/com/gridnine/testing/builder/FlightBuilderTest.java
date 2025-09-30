package com.gridnine.testing.builder;

import com.gridnine.testing.model.Flight;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightBuilderTest {
    @Test
    void shouldCreateFlights() {
        List<Flight> flights = FlightBuilder.createFlights();
        assertNotNull(flights);
        assertFalse(flights.isEmpty());
        assertTrue(flights.size() >= 5, "Должно создаваться несколько перелётов");
    }
}

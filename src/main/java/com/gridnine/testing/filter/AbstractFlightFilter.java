package com.gridnine.testing.filter;

import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFlightFilter implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(this::isValid)
                .collect(Collectors.toList());
    }

    protected abstract boolean isValid(Flight flight);
}

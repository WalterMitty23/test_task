package com.gridnine.testing.app;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.filter.*;
import com.gridnine.testing.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        List<FlightFilter> filters = List.of(
                new DepartureBeforeNowFilter(),
                new ArrivalBeforeDepartureFilter(),
                new GroundTimeExceedsTwoHoursFilter()
        );

        for (FlightFilter filter : filters) {
            System.out.println("Результат фильтра: " + filter.getClass().getSimpleName());
            filter.filter(flights).forEach(System.out::println);
        }
    }
}

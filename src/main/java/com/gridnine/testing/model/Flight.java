package com.gridnine.testing.model;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
    public long getTotalGroundTimeMinutes() {
        long total = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            total += Duration.between(
                    segments.get(i).getArrivalDate(),
                    segments.get(i + 1).getDepartureDate()
            ).toMinutes();
        }
        return total;
    }
}

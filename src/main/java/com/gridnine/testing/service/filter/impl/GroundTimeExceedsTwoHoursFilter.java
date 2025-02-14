package com.gridnine.testing.service.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.filter.Filter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Время полета на земле составляет более двух часов (общее время, проведённое на земле превышает два часа)
public class GroundTimeExceedsTwoHoursFilter implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    return IntStream.range(0, segments.size() - 1)
                            .allMatch(i -> {
                                LocalDateTime arrival = segments.get(i).getArrivalDate();
                                LocalDateTime departure = segments.get(i + 1).getDepartureDate();
                                Duration groundTime = Duration.between(arrival, departure);
                                return groundTime.toHours() <= 2;
                            });
                })
                .collect(Collectors.toList());
    }
}

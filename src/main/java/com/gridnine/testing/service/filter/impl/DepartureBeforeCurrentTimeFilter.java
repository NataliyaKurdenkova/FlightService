package com.gridnine.testing.service.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.filter.Filter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//Рейс, отправлявшийся в прошлом (вылет до текущего момента времени)
public class DepartureBeforeCurrentTimeFilter implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {

        return flights.stream()
                .filter(flight -> flight
                        .getSegments()
                        .get(0).getDepartureDate()
                        .isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }
}